# API REST(CRUD) For a Product Catalog System 
[![NPM](https://img.shields.io/npm/l/react)](https://github.com/luizjhonata/productcatalog/blob/main/LICENCE)

## About the project
The project consist of a REST API(CRUD) for cast iron product catalog.
With some products changes it's possible to use this project to another kind of product, feel free.

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
- Details;

The system has JWT Token, you need to make authentication with user and password, to receive a jwt token and access the application.
The system has two types of roles(user and admin). 
The user with the role type user has authority to make get operations and the user with role admin can make get, put, post and delete operations.
We have two users pre-registered to make tests in the system, one with role user and another with role admin.

### User with role user
- Login: normaluser 
- Password: normaluser1

### User with role admin
- Login: admin
- Password: admin1

## Operations that the user with role user has authority to make:

- GET ALL Users;
- GET Users by Username;
- GET Users by Id;
- GET ALL Products sorted by Id;
- GET ALL Products sorted by Cod;
- GET Products by Id;
- GET Products by Cod;
- GET Welcomer;

## The user with role admin can do all GETS listeds above and the following PUT, POST and DELETE operations: 

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
- DELETE a product with his Id;
- DELETE a user with his Id;


## In this project i put in pratice my knoledge about: 
- Java;
- Spring Boot; 
- Spring Boot Starter Validation;
- Spring Data Jpa;
- Spring Security;
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
