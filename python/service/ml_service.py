#!/usr/bin/env python

from sanic import Sanic
from sanic import response
import pandas as pd
from pandas.io.json import json_normalize
import logging
import json
import yaml
from python.service.img_detector.img_detection import *
warnings.filterwarnings("ignore")

app = Sanic("ml_service")


@app.route("/ml/questionary_class", methods=["POST",])
async def get_questionary_class(request):
    df = json_normalize(request.json, 'questionary_data')
    response_dict = dict()
    response_dict["class"] = 1
    return response.text(json.dumps(response_dict, ensure_ascii=False))


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
    app.run(host="0.0.0.0", port=9001, debug=True, access_log=True)