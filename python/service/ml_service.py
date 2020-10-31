#!/usr/bin/env python
from sanic import Sanic
from sanic import response
import pandas as pd
from pandas.io.json import json_normalize
import joblib
import logging
import yaml
from python.service.img_detector.img_detection import *
warnings.filterwarnings("ignore")

app = Sanic("ml_service")

label_encoder = {'nameOfTypePet': {'кошка': 0, 'собака': 1},
'sizeOfPet':{'большой': 0, 'крупный': 1, 'малый': 2, 'средний': 3},
'nameOfColorPet':{'абркосовый': 0, 'арлекин': 1, 'белый': 2, 'биколор': 3, 'голубо-кремовый черепаховый': 4, 'голубой с белым': 5, 'дымчатый': 6, 'золотой': 7, 'красный': 8, 'красный с белым': 9, 'кремовый': 10, 'мраморный': 11, 'палевый': 12, 'перец с солью': 13, 'рыжий': 14, 'светло-коричневый': 15, 'серебристый': 16, 'соболиный': 17, 'темно-коричневый': 18, 'тигровый': 19, 'триколор': 20, 'фавн (бежевый)': 21, 'чепрачный': 22, 'черепаховый': 23, 'черно-белый': 24, 'черно-красный-белый': 25, 'черный': 26, 'черный с белым': 27, 'шоколадный': 28},
'nameOfTypeWoolPet':{'гладкая': 0, 'длинная': 1, 'короткая': 2, 'обычная': 3},
'nameOfTypeEarPet':{'висячие': 0, 'купированные': 1, 'полустоячие': 2, 'стоячие': 3},
'nameOfTypeOfTailPet':{'крючком': 0, 'купированный': 1, 'обычный': 2, 'поленом': 3, 'прутом': 4, 'саблевидный': 5}}


@app.route("/ml/questionary_class", methods=["POST",])
async def get_questionary_class(request):
    df = json_normalize(request.json)
    df = pd.DataFrame.from_records(df)
    cols = ['nameOfTypePet','sizeOfPet','nameOfColorPet','nameOfTypeWoolPet','nameOfTypeEarPet','nameOfTypeOfTailPet']
    df_test = df[cols]
    for i in range(len(cols)):
        col = cols[i]
        df_test[col] = df_test[col].map(label_encoder[col])
    cl = knn_model.predict(df_test.to_numpy())
    df = df[['idOfPet']]
    df['label'] = cl
    return response.text(df.to_json(orient='records'))


@app.route("/ml/img_vec_class", methods=["POST",])
async def get_img_vec_class(request):
    images = request.json['img_data']
    speciesl = []
    breedl = []
    embbl = []
    namel = []
    for img_path in images:
        img = Image.open(img_path)
        img = val_transform(img).to(device)
        prob_pred_species, prob_pred_breed = predict_one_sample(model, img.unsqueeze(0))
        y_pred_species = np.argmax(prob_pred_species)
        y_pred_breed = np.argmax(prob_pred_breed)
        embb = model.get_vector(img.unsqueeze(0)).cpu().detach().numpy()
        norm = np.linalg.norm(embb)
        embb = embb / norm
        predicted_label_species = classes_species[y_pred_species]
        predicted_label_breed = classes_breed[y_pred_breed]
        speciesl.append(predicted_label_species)
        breedl.append(predicted_label_breed)
        embbl.append(embb)
        namel.append(img_path)
    df = pd.DataFrame({"img_name": namel, "species": speciesl, "breed": breedl, "vec": embbl})
    return response.text(df.to_json(orient='records'))


@app.route("/ml/img_class", methods=["POST",])
async def get_img_class(request):
    images = request.json['img_data']
    speciesl = []
    breedl = []
    namel = []
    for img_path in images:
        img = Image.open(img_path)
        img = val_transform(img).to(device)
        prob_pred_species, prob_pred_breed = predict_one_sample(model, img.unsqueeze(0))
        y_pred_species = np.argmax(prob_pred_species)
        y_pred_breed = np.argmax(prob_pred_breed)
        predicted_label_species = classes_species[y_pred_species]
        predicted_label_breed = classes_breed[y_pred_breed]
        speciesl.append(predicted_label_species)
        breedl.append(predicted_label_breed)
        namel.append(img_path)
    df = pd.DataFrame({"img_name": namel, "species":speciesl, "breed": breedl})
    return response.text(df.to_json(orient='records'))


if __name__ == "__main__":
    with open("LOGGING_CONF", "r") as config_file:
        global_config = yaml.load(config_file, Loader=yaml.FullLoader)
    logging.config.dictConfig(global_config['logging'])
    logger = logging.getLogger('ml.server')
    N_SPECIES_CLASSES = 2
    N_BREED_CLASSES = 37

    model = MultiOutputModel(n_species_classes=N_SPECIES_CLASSES,
                             n_breed_classes=N_BREED_CLASSES)
    path = f"img_detector/weights/resnext50_DogsvsCats.pt"
    device = torch.device("cuda:0" if torch.cuda.is_available() else "cpu")
    model = model.to(device)
    model.load_state_dict(torch.load(path, map_location=device))
    knn_model = joblib.load('KNNGraph_1.pkl')
    app.run(host="0.0.0.0", port=9001, debug=True, access_log=True)