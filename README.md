# API REST For a Product Catalog System 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/luizjhonata/productcatalog/blob/main/LICENCE)

## About the project
The project consist of a REST API for cast iron product catalog, but with some products changes it is possible to be applied to other products.

The project has two main entities, USER and PRODUCT;

## USER attributes:

- Id;
- Name; 
- Username;
- Password; 
- RoleModels;

## PRODUCT attributes:

- Id;
- Cod;
- Description;
- Price;
- Weight;

The system has user and password authentication, with two types of roles(user and admin). 
The user with the role type user has authority to make get operations and the user with role admin can make get, put and post operations.

## Operations that the user with role user has authority to make:

- GET ALL Users;
- GET Users by Username;
- GET Users by Id;
- GET ALL Products sorted by Id;
- GET ALL Products sorted by Cod;
- GET Products by Id;
- GET Products by Cod;
- GET Welcomer;

## The user with role admin can do all GETS listeds above and the following PUT and POST operations: 

- POST a new user;
- PUT all data in a user using his Id;
- PUT the Username using his Id;
- PUT the Password using his Id;
- PUT the Name using his Id;
- POST a new product;
- PUT all data in a product using his Id;
- PUT the Weight using his Id;
- PUT the Price using his Id;
- PUT the Description using his Id;
- PUT the Cod using his Id;


## In this project i put in pratice my knoledge about: 
- Java;
- Spring Boot; 
- Spring Boot Starter Validation;
- Spring Data Jpa;
- Spring Security;
- Swagger;
- H2;  
- MVC; 
- REST API;
- Relational Object Mapping;

## Layers Patterns
![Web](https://github.com/luizjhonata/assetsreadme/blob/main/foodDeliveryBackEnd/layerPatterns.png)

## How to run the project

Prerequisites: Java 11

```bash
# clone repository
git clone https://github.com/luizjhonata/productcatalog

# enter in the productcatalog project folder
cd productcatalog

# run the project
./mvnw spring-boot:run
```

# Autor

Jhonata de Souza Luiz

https://www.linkedin.com/in/jhonataluiz/
