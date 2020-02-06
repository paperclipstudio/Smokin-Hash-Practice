#!bin/bash
echo "hello"
clear
javac -d bin *.java
read -n 1 -s
java -cp bin pointPerCar
read -n 1 -s
