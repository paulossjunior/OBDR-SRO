# Ontology-Based Data Repository Based on Scrum Reference Ontology

## 🚀 Goal
An Ontology-Based Data Repository that implements the conceps of Scrum Reference Ontology (SRO). SRO provides a common and comprehensive conceptualization about Scrum in the software development context and can be used to support application integration.

## 📕 Domain Documentation

Domain documentation can be found [here](./docs/README.md)

## ⚙️ Requirements

1. Postgresql
2. Java 17
3. Maven

## ⚙️ Stack
1. Spring Boot 3.0
2. Hibernate


## 🔧 Install

1) Create a database with name sro with **CREATE DATABASE sro**.
2) Run the command to start the webservice and create table of database:

```bash
mvn Spring-boot:run
```

## Debezium

Go to folder named *register* and performs following command to register in debezium:

```bash
curl -i -X POST -H "Accept:application/json" -H  "Content-Type:application/json" http://localhost:8083/connectors/ -d @register-sro.json
```

To delete, uses:

```bash
curl -i -X DELETE localhost:8083/connectors/sro-connector/
```


