FROM node:12

WORKDIR /frontend

COPY package*.json ./
RUN npm ci

COPY *.js  *.json *.ts ./
COPY src src

CMD bash ./start.sh
