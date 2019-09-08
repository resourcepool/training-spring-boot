#!/bin/bash
# Create and run mariadb container called mariadb_container and bind to local volume on your machine
docker run --name mariadb_container -p 3306:3306 -e MYSQL_ROOT_PASSWORD=toor -d -v /home/$USER/Documents/docker-mariadb:/var/lib/mysql mariadb/server:10.1
# Wait creation
sleep 2
# Create database inside mariadb_container
docker exec -it mariadb_container mysql -uroot -ptoor --execute="CREATE DATABASE madbamoi;"