Comando para buildar imagem:
docker build . -t ods3-db:v0.0.1

Comando para rodar container:
docker run -d --name ods3db -p 3306:3306 -e MYSQL_ROOT_PASSWORD=1234 -e MYSQL_DATABASE=ODS3 -e MYSQL_USER=main -e MYSQL_PASSWORD=1234 ods3-db:v0.0.1

Comando para acessar o banco via terminal:
docker exec -it ods3db bash
mysql -uroot -p
1234

