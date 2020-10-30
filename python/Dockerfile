FROM python:3.6

RUN mkdir /app
WORKDIR /app
VOLUME /app

COPY requirements.txt .
RUN pip install -r requirements.txt

COPY . .

CMD chmod u+x ./service/ml_service.py && ./service/ml_service.py
