# Repte-4

This repository contains the implementation of a REST API fulfiling the [goals](https://nuwe.io/challenge/repte-4-operacions-crud) of Nuwe's 4th challenge for Barcelona's IT Academy programming league.

## Installation

The project can be downloaded as a .zip file and run in your preferred IDE.

## Usage

First of all, certain parameters in the `application.properties` file located in the resources folder may need to be changed in order for the database connection to work. Please adjust them according to your local SQL connection specification:

```
# Connection url for the database
spring.datasource.url = jdbc:mysql://localhost:3306/clients_db?serverTimezone=UTC
#User database Mysql
spring.datasource.username = root
#Password database Mysql
spring.datasource.password = 
```

A database in the SQL server called `clients_db` will have to be created manually as well. The name of this database can be changed modifying the url parameter.

## Design

The database persists two different models, a Client and a Client Address. The Client entity has a one-to-many relationship with the Client Address entity, since a client may have more than one saved address on a particular website.

The structure of the package is the following:

- Controller: includes the controllers with all the endpoints for both models. Performs the validations outlined in the Model package.
- Repository: holds the repository interfaces for both models
- Service: has the methods for performing CRUD operations on each model repository.
- Exception: defines a custom exception and also holds the controller adviser class for handling exceptions.
- Model: has the classes that define both models and their relationship. It also includes the validation layer, making use of the JSR 380 specification of the Java API for bean validation.

Once the app is running, you can see all the implemented methods in the API by visiting the Swagger UI page at `http://localhost:3000/swagger-ui/index.html#/`.

## Tests with Postman

The repository includes a json file that can be imported into Postman to test all CRUD methods for the API.
