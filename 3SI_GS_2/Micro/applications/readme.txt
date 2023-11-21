#Comandos para criar as imagens necessárias para rodar o docker compose
cd banco
docker build . -t ods3-db
cd backend
docker build . -t ods3-api
cd frontend
docker build . -t ods3-front

#Comando para rodar o docker compose
docker compose up -d

#Comando para remover docker compose
docker compose down

IMPORTANTE
O banco pode demorar um pouco para subir, dada a massa de dados que precisa carregar (cerca de 40 segundos)