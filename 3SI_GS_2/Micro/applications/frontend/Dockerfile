FROM node:18.16.0-alpine3.17

# Pasta em que a aplicação ficará
RUN mkdir -p /opt/app
WORKDIR /opt/app

# Para evitar que os node_modules sejam copiados, rodamos npm install primeiro e depois copiamos os arquivos da aplicação
COPY ./ods3Front/package.json .
RUN npm install

# Copiamos arquivos da aplicação
COPY ./ods3API/ .

# Start da aplicação na porta 3000
EXPOSE 3000
CMD [ "npm", "start"]