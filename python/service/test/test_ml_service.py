from json import dumps
from ..ml_service import app
import requests_async
import asyncio
import unittest
import yaml


class WebServiceTestOperations(unittest.TestCase):

    async def get_class(self, global_config):
        data = [{'idOfPet':"1001", 'nameOfTypePet': 'собака','sizeOfPet': 'средний','nameOfColorPet':'черный','nameOfTypeWoolPet':'короткая','nameOfTypeEarPet':'висячие','nameOfTypeOfTailPet':'обычный'},
                                     {'idOfPet':"1002",'nameOfTypePet': 'кошка','sizeOfPet': 'средний','nameOfColorPet':'черный','nameOfTypeWoolPet':'короткая','nameOfTypeEarPet':'полустоячие','nameOfTypeOfTailPet':'обычный'}]
        data = dumps(data)
        try:
            host = global_config["host"]
            port = global_config["port"]
            response = await requests_async.post('http://{0}:{1}/ml/questionary_class'.format(host, port), data=data)
            print(response.text)
            print(response.status_code)
        except requests_async.exceptions.ConnectionError as e:
            print(e)

    def test_class(self):
        loop = asyncio.get_event_loop()
        with open("service/SERVICE_CONF", "r") as config_file:
            global_config = yaml.load(config_file, Loader=yaml.FullLoader)
        loop.run_until_complete(self.get_class(global_config))

    async def get_img_vec_class(self, global_config):
        images = ['images/cat.png']
        data = {"img_data": images}
        data = dumps(data)
        try:
            host = global_config["host"]
            port = global_config["port"]
            response = await requests_async.post('http://{0}:{1}/ml/img_vec_class'.format(host, port), data=data)
            print(response.text)
            print(response.status_code)
        except requests_async.exceptions.ConnectionError as e:
            print(e)

    def test_img_vec_class(self):
        loop = asyncio.get_event_loop()
        with open("service/SERVICE_CONF", "r") as config_file:
            global_config = yaml.load(config_file, Loader=yaml.FullLoader)
        loop.run_until_complete(self.get_img_vec_class(global_config))

    async def get_img_class(self, global_config):
        images = ['images/cat.png']
        data = {"img_data": images}
        data = dumps(data)
        try:
            host = global_config["host"]
            port = global_config["port"]
            response = await requests_async.post('http://{0}:{1}/ml/img_class'.format(host, port), data=data)
            print(response.text)
            print(response.status_code)
        except requests_async.exceptions.ConnectionError as e:
            print(e)

    def test_img_class(self):
        loop = asyncio.get_event_loop()
        with open("service/SERVICE_CONF", "r") as config_file:
            global_config = yaml.load(config_file, Loader=yaml.FullLoader)
        loop.run_until_complete(self.get_img_class(global_config))
