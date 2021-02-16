#!/bin/bash

set -e

postgres_password=postgres
## remove already running container, we want to start  clean
docker rm -f $(docker ps | grep postgres:13 | awk '{print $1}') || true
## start new postgres container
container_id=$(docker run -P -d -e POSTGRES_PASSWORD=$postgres_password postgres:13)
## Get random port assigned to this container
random_port=$(docker inspect --format '{{ (index (index .NetworkSettings.Ports "5432/tcp") 0).HostPort }}' $container_id)
##construct a jdbc url
jdbcUrl="jdbc:postgresql://localhost:$random_port/postgres"
## Run spring application, also run liquibase
SPRING_DATASOURCE_URL=$jdbcUrl \
  SPRING_DATASOURCE_USERNAME=postgres \
  SPRING_DATASOURCE_PASSWORD=$postgres_password \
  SPRING_PROFILES_ACTIVE=liquibase ./gradlew bootRun
