#!/usr/bin/env bash
mvn clean install
docker-compose build
echo "reloading containers"
cd ..
docker-compose up -d feedback-api
echo "all done"
