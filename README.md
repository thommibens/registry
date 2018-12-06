[![Build Status](https://travis-ci.org/thommibens/registry.svg?branch=master)](https://travis-ci.org/thommibens/registry)
#  Registry
A simple Spring Boot App, made to try Conteinerized deploy

# Getting Started

## Requirements
* Jdk >= 1.8
* Maven >= 3.3.3
* Docker(Optional)

## Dowload
download
```console
$ git clone https://thomas-benetton.visualstudio.com/RegistryApp/_git/RegistryApp
```


## Build a Jar

Will create the jar in the `target/` folder

```console
$ mvn package
```

## Run the application with Spring Boot
Will serve the application under `localhost:8080`
```console
$ mvn spring-boot:run
```

## Build and run a docker image 
Create a docker image `thommibens/registry:latest`
```console
$ mvn install dockerfile:build
```
Run the image and serve the application on th port `8080`
```console
$ docker run -it -p 8080:80 thommibens/registry
```

## App urls
You can check the application by navigating to the following urls:

*   ```urls
    http:\\{hostname}:{port}/v1/customer
    ```
    > Example `http:\\localhost:8080/v1/customer`
---
*  ```urls
    http:\\{hostname}:{port}/v1/customer/{customer ID}
    ```
    > Example `http:\\localhost:8080/v1/customer/5bca37f70129ec46f2554120`
---

*   ```urls
    http:\\{hostname}:{port}/v1/customer/search
    ```
    > Example `http:\\localhost:8080/v1/customer/search`
---

*   ```urls
    http:\\{hostname}:{port}/v1/customer/search?name={word to check}
    ```
    > Example `http:\\localhost:8080/v1/customer/search?name=phoebe`
