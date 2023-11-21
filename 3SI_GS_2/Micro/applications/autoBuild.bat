@echo off
cd banco
docker build . -t ods3-db
cd ../backend
docker build . -t ods3-api
cd ../frontend
docker build . -t ods3-front