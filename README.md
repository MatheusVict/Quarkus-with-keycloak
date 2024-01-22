# Quarkus with keycloak

A Quarkus API with keycloak authentication and h2 database.

![keycloak](https://blog.consdata.tech/assets/img/posts/2020-02-01-keycloak-uwierzytelnianie-autoryzacja-springboot-angular/Keycloak.png)

### Used Technologies

* [Java](https://www.java.com/en/)
* [Docker](https://www.docker.com/)
* [Keycloak](https://www.keycloak.org/)

## Necessary Versions and dependencies

* Java - Version: 17
* Maven - Version: 3.8.2
* Quarkus - Version: 3.6.4
* Docker - Version: 24.0.7
* Keycloak - Version: 17.0.0

### Getting Started

```
./mvnw compile quarkus:dev
```

```
docker run --name keycloak -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin -p 8180:8080 quay.io/keycloak/keycloak:17.0.0 start-dev
```

Application will be available on http://localhost:8080
Keycloak will be available on http://localhost:8180

## How to run tests

```
./mvnw test
```

## Routes

**You will need to be authenticated on [Keycloak](https://www.keycloak.org/) to access the routes below.**

### First of all, you need to create a realm on keycloak, and authenticate on it. Like this:

* http://localhost:8180/realms/quarkus/protocol/openid-connect/token

> POST

````Form Url enconded````

- username - your_username
- password - your_password
- grant_type - password

```Basic Auth```
username - backend-service
password - backend-service

### After that you'll be able to access the routes below with the token you received from keycloak, and pass on Bearer Token.

* /api/v1/consumers
> GET

return:
```json
[
  {
    "id": 1,
    "name": "Matheus",
    "lastName": "yaa",
    "age": 5,
    "email": "matheus@email.com"
  }
]
```

* /api/v1/consumers
> POST

body:
```json
{
  "name": "Matheus",
  "lastName": "yaa",
  "age": 5,
  "email": "matheus@email.com"
}
```


