#!/bin/bash

set -e
dbPass=abc123
dbUser=admin
dbName=miniminimoney

docker run -d --name postgresForMiniMiniMoney -e POSTGRES_PASSWORD=${dbPass} -e POSTGRES_USER=${dbUser} -e POSTGRES_DB=${dbName} -p 127.0.0.1:15432:5432 postgres:11 \
  -c shared_preload_libraries='pg_stat_statements'

#user defined network so containers can communicate easily using only another container's IP address or name.