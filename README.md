# Hello World Rest API
Sample Java and Spring Boot Rest API

---

#### Pre-requisites
* Java Development Kit (JDK) 11
* Apache Maven 3.9

---

#### Environment used for developments
* OS: Windows 11
* IDE: IntelliJ IDEA 2025.2.3
* Back-end technologies: Java with Spring Boot, Maven

---

#### Config & Build
1. Goto the location of the project directory.

2. Run following command.

`mvn clean install`

---

#### Execute only unit tests
1. Goto the location of the project directory.
2. Run following command.

`mvn test`

---

#### Execute the program
1. Goto the project built directory.

`<project-directory>/target`

2. Execute the jar file as follows.

`java -jar Hello-World-Rest-API-<project-version>.jar`

e.g: `java -jar Hello-World-Rest-API-0.0.1-SNAPSHOT.jar`

i.e: Please refer the following link to find more ways to build and execute Spring Boot application.
https://docs.spring.io/spring-boot/tutorial/first-application/index.html

---

#### Access the program
By default, program will start in port 8080. You may access the hello world endpoint using the following cURL.

`curl --location '<host>:<port>/hello-world?name=alice'`

e.g: `curl --location 'localhost:8080/hello-world?name=alice'`

* Sample response if the name is in the first half of the English alphabet (A–M or a–m):

    `{ "message": "Hello Alice" }`

* Sample response If the first letter is in the second half (N–Z or n–z) or empty:
    
    `{ "error": "Invalid Input" }`
