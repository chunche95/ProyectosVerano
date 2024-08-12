#!/bin/bash

echo "Bajando los archivos del repositorio"
git pull

echo "Subiendo los archivos nuevos"
git add .
git nota $1
git sube
sleep 5
clear

git st
sleep 8
clear