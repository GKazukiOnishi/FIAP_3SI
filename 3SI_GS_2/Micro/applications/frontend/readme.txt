Comando para buildar imagem:
docker build . -t ods3-frontend

Comando para rodar container:
docker run -d --rm --name ods3front -p 3000:3001 --network test-net ods3-frontend

Lembrando que a aplicação irá subir, mas só irá rodar da forma que deveria se a API estiver rodando também