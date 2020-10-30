import numpy as np
import torch.nn as nn
import torch.nn.functional as F
import random
import torch

from tqdm import tqdm
from PIL import Image

from torchvision import transforms, models
from torch.utils.data import Dataset, DataLoader
import warnings
warnings.filterwarnings(action='ignore', category=DeprecationWarning)

def init_random_seed(value=0): # зададим все сиды одной функцией
    random.seed(value)
    np.random.seed(value)
    torch.manual_seed(value)
    torch.cuda.manual_seed(value)
    torch.backends.cudnn.deterministic = True

init_random_seed(42)

classes_species = ['Cat', 'Dog']

classes_breed = {0: 'Abyssinian',
                 1: 'american_bulldog',
                 2: 'american_pit_bull_terrier',
                 3: 'basset_hound',
                 4: 'beagle',
                 5: 'Bengal',
                 6: 'Birman',
                 7: 'Bombay',
                 8: 'boxer',
                 9: 'British_Shorthair',
                 10: 'chihuahua',
                 11: 'Egyptian_Mau',
                 12: 'english_cocker_spaniel',
                 13: 'english_setter',
                 14: 'german_shorthaired',
                 15: 'great_pyrenees',
                 16: 'havanese',
                 17: 'japanese_chin',
                 18: 'keeshond',
                 19: 'leonberger',
                 20: 'Maine_Coon',
                 21: 'miniature_pinscher',
                 22: 'newfoundland',
                 23: 'Persian',
                 24: 'pomeranian',
                 25: 'pug',
                 26: 'Ragdoll',
                 27: 'Russian_Blue',
                 28: 'saint_bernard',
                 29: 'samoyed',
                 30: 'scottish_terrier',
                 31: 'shiba_inu',
                 32: 'Siamese',
                 33: 'Sphynx',
                 34: 'staffordshire_bull_terrier',
                 35: 'wheaten_terrier',
                 36: 'yorkshire_terrier'}


class CatsVSDogsDataset(Dataset):
    def __init__(self, data, transform):
        super().__init__()
        self.data = data
        self.transform = transform
        self.image_path = []
        self.species = []
        self.breed = []

        # read the annotations from the CSV file
        DATA_DIR = '/content/gdrive/My Drive/Кошки_Собаки/images/'
        for index, row in self.data.iterrows():
            self.image_path.append(DATA_DIR + row['Image'] + '.jpg')
            self.species.append(row['SPECIES'])
            self.breed.append(row['CLASS-ID'])

    def __len__(self):
        return len(self.data)

    def __getitem__(self, idx):
        # take the data sample by its index
        img_path = self.image_path[idx]

        # read image
        img = Image.open(img_path)

        # apply the image augmentations if needed
        img = self.transform(img)

        # return the image and all the associated labels
        dict_data = {
            'img': img,
            'labels': {
                'species_labels': self.species[idx],
                'breed_labels': self.breed[idx]
            }
        }

        return dict_data

class MultiOutputModel(nn.Module):
    def __init__(self, n_species_classes, n_breed_classes):
        super().__init__()

        self.base_model = models.resnext50_32x4d()  # take the model without classifier
        last_channel = self.base_model.fc.in_features  # size of the layer before the classifier

        # the input for the classifier should be two-dimensional, but we will have

        # [<batch_size>, <channels>, <width>, <height>]

        # so, let's do the spatial averaging: reduce <width> and <height> to 1
        self.pool = nn.AdaptiveAvgPool2d((1, 1))

        # create separate classifiers for our outputs

        self.species = nn.Sequential(
            nn.Dropout(p=0.2),
            nn.Linear(in_features=last_channel, out_features=n_species_classes)
        )

        self.breed = nn.Sequential(
            nn.Dropout(p=0.2),
            nn.Linear(in_features=last_channel, out_features=n_breed_classes)
        )
        self.base_model.fc = nn.Sequential()

    def get_loss(self, net_output, ground_truth_species, ground_truth_breed):
        species_loss = F.cross_entropy(net_output['species'], ground_truth_species)
        breed_loss = F.cross_entropy(net_output['breed'], ground_truth_breed)
        loss = species_loss + breed_loss
        return loss, {'species': species_loss, 'breed': breed_loss}

    def get_vector(self, input):
        self.base_model.eval()
        x = self.base_model(input)
        # x = self.pool(x)

        # reshape from [batch, channels, 1, 1] to [batch, channels] to put it into classifier
        x = torch.flatten(x, start_dim=1)
        return x

    def forward(self, x):
        x = self.base_model(x)
        # x = self.pool(x)

        # reshape from [batch, channels, 1, 1] to [batch, channels] to put it into classifier
        x = torch.flatten(x, start_dim=1)

        return {
            'species': self.species(x),
            'breed': self.breed(x)
        }


def copy_data_to_device(data, device):
    if torch.is_tensor(data):
        return data.to(device)
    elif isinstance(data, (list, tuple)):
        return [copy_data_to_device(elem, device) for elem in data]
    raise ValueError('Недопустимый тип данных {}'.format(type(data)))


def predict_with_model(model, dataset, device=None, batch_size=32, num_workers=32, return_labels=False):
    """
    :param model: torch.nn.Module - обученная модель
    :param dataset: torch.utils.data.Dataset - данные для применения модели
    :param device: cuda/cpu - устройство, на котором выполнять вычисления
    :param batch_size: количество примеров, обрабатываемых моделью за одну итерацию
    :return: numpy.array размерности len(dataset) x *
    """
    if device is None:
        device = "cuda" if torch.cuda.is_available() else "cpu"
    results_by_batch_species = []
    results_by_batch_breed = []

    device = torch.device(device)
    model = model.to(device)
    model.eval()

    dataloader = DataLoader(dataset, batch_size=batch_size, shuffle=False, num_workers=num_workers, collate_fn=collate_cv_fn)
    labels_species = []
    labels_breed = []
    with torch.no_grad():
        for batch in tqdm(dataloader, total=len(dataset)/batch_size):

            batch_x = copy_data_to_device(batch['features'], device)
            batch_y_species = batch['targets']['species_labels']
            batch_y_breed = batch['targets']['breed_labels']

            if return_labels:
                labels_species.append(batch_y_species.numpy())
                labels_breed.append(batch_y_breed.numpy())

            batch_pred = model(batch_x)
            results_by_batch_species.append(batch_pred['species'].detach().cpu().numpy())
            results_by_batch_breed.append(batch_pred['breed'].detach().cpu().numpy())
    if return_labels:
        return np.concatenate(results_by_batch_species, 0), np.concatenate(results_by_batch_breed, 0) ,np.concatenate(labels_species, 0), np.concatenate(labels_breed, 0)
    else:
        return np.concatenate(results_by_batch_species, 0), np.concatenate(results_by_batch_breed, 0)


def predict_one_sample(model, inputs, device='cpu'):
    """Предсказание, для одной картинки"""
    with torch.no_grad():
        inputs = inputs.to(device)
        model.eval()
        logit = model(inputs)
        probs_species = F.softmax(logit['species'], dim=-1).cpu().numpy()
        probs_breed = F.softmax(logit['breed'], dim=-1).cpu().numpy()
    return probs_species, probs_breed


mean = [0.485, 0.456, 0.406]
std = [0.229, 0.224, 0.225]

val_transform = transforms.Compose([
    transforms.Resize((224, 224)),
    transforms.ToTensor(),
    transforms.Lambda(lambda x: x[0:3]*x[-1] if x.shape[0]==4 else x),
    transforms.Normalize(mean, std)
])





