REST-api to access the country flags based on continents and/or countries , develop using Spring Boot

Requirements:
Install Java 1.8
Install Maven


optional :
Postman - to access the REST -API

oracle DB Schema :


To access the end points
curl -X GET http://localhost:8080/countries/flags
curl -X GET http://localhost:8080/countries/flags?continent=Africa
curl -X GET http://localhost:8080/countries/flags?continent=Africa&countries=Nigeria,Egypt
