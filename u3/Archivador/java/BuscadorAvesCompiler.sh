#!/bin/bash

# Compila
echo " * Compilando el .java "
# javac -cp .:json-20250517.jar SearchBirdsAPI.java
javac -cp ".;libs/json-20250517.jar" SearchBirdsAPI.java

#javac -cp .:json-20250517.jar  -Xlint:deprecation SearchBirdsAPI.java

# Ejecuta
echo " * Ejecutando el Buscador "
# /usr/lib/jvm/java-26-openjdk-amd64/bin/java -cp .:json-20250517.jar SearchBirdsAPI
# java -cp ".;libs/json-20250517.jar" SearchBirdsAPI
java -cp ".;libs/json-20250517.jar;java" SearchBirdsAPI



exit 0