#!/bin/bash

docker run -itd -p 8080:8080 -v "$(pwd)/default.conf:/etc/nginx/conf.d" nginxdynamics
docker ps -a
