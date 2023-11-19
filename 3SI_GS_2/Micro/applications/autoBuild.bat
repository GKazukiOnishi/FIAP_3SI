@echo off
cd banco
docker build . -t ods3-db:vCompose
cd ../backend
docker build . -t ods3-api:vCompose
cd ..
docker compose up -d