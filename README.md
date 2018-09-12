# transmilenio-inventory
A Spring Boot MVC based application to manage the inventory of Transmilenio.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

* Java SDK 8+
* Maven
* Spring boot Maven plugin 2+

## Deployment

The application has following profiles

* `dev`: local database
* `stage`: server database

Deploy the application by running

    mvn spring-boot:run -Dspring-boot.run.profiles=<PROFILE_NAME>

if no profile is specified, the application will be deployed with the stage configuration.

You should be able to navigate to the app on http://localhost:8080/

## Authors

* **Sergio Torres** - [sdtorresl](https://github.com/sdtorresl)
* **Nicolás Arias** - [ndariass](https://github.com/ndariass)
