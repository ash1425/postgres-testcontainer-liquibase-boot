#!/bin/sh
set -e

if [ -z "$LIQUIBASE_COMMAND" ]; then
  echo "Running liquibase ..........."
  echo "DB_URL : ${LIQUIBASE_URL:?}"
  echo "DB_USER : ${LIQUIBASE_USER:?}"
  SPRING_DATASOURCE_URL=${LIQUIBASE_URL} \
    SPRING_DATASOURCE_USERNAME=${LIQUIBASE_USER} \
    SPRING_DATASOURCE_PASSWORD=${LIQUIBASE_PASSWORD:?} \
    SPRING_PROFILE_ACTIVE=init,liquibase \
    java -jar app.jar
  exit
fi

java -jar app.jar
