# WebApplication
<details>
<summary>Table of Contents</summary>

* [Introduction](#Introduction)
* [What went well and What didn't go well](#What-went-well-and-What-didn't-go-well)
* [Scope and Minimum Viable Product](#Scope-and-Minimum-Viable-Produc)
* [Getting Started](#Getting-Started)
  * [Prerequisites](#Prerequisites)
* [Installing](#Installing)
  * [Import project to Eclipse](#Import-project-from-Eclipse)
* [Running Application](#Running-Application)
  * [To run from Eclipse](#To-run-from-Eclipse)
  * [To run on command line](#To-run-on-command-line)
* [Running the Tests](#Running-the-Tests)
  * [Unit tests](#Unit-tests)
  * [Integration test](#Integration-test)
  * [Service test](#Service-test)
* [Build with](#Build-with)
* [Postman and API Interactions](#Postman-and-API-Interactions)
  * [GET  request - /project/getAll](#GET-request-/project/getAll)
  * [POST to created a new music input -/project/Create](#POST-to-created-a-new-music-input-/project/Create)
  * [PUT to update music - /project/Update/{id}](#PUT-to-update-music-/project/Update/{id})
  * [DELETE to remove music - /project/delete/ {id}](#DELETE-to-remove-music-/project/delete/{id})
  * [Custom Exception of any request - /project/getById/{id}](#Custom-Exception-of-any-request-/project/getById/{id})
* [Persistent database](#Persistent-database)
  * [SQL table](#SQL-table)
  * [Spring Boot API Running](#Spring-Boot-API-Running)
* [Test Results and Coverage](#Test-Results-and-Coverage)
* [Swagger API](#Swagger-API)
* [Jira Board](#Jira-Board)
* [Author](#Author)

</details>

## Introduction

I have designed individual projects to show off the skills we have learned over the past several weeks. The major aim of this project is:

> “ To create a OOP-based web application, with utilisation of supporting tools, 
> methodologies and technologies, that encapsulates all fundamental and practical 
> modules covered during training ”

The Spring Boot Framework is used to build a Java back-end application with a persistent database to do this. MySQL, which is used to working with Postman API calls, will be used to host the managed database locally. Jira will also be used for this project's entire project management. For integration and unit testing of the back-end application, JUnit and Mockito will be utilised.

I developed an API that can perform CRUD functions (Create, Read, Update, and Delete) specific information about Music (songs) that can be accessed in the Music Playlist database in order to meet the requirements of this project. 

## What went well and What didn't go well

I learned a lot during this project week. I was able to use Agile and Scrum Methodology practically thanks to Jira, which is really new to me. I learned about testing, why it's important for programmers, and how to use tools for continuous integration like GitHub and Git Bash. It's been a good and informative experience this past week.

The main problem with this project was its use of GitHub. It took some time for me to fully grasp how to actively add to, commit , and push to GitHub using Git Bash. I was still having issues with the feature-branch strategy on GitHub as the project came to an end. When building more components in the back-end application, it required some getting used to remembering to switch to the appropriate branch for changes made to various elements of the code.

Another issue that developed throughout the development of this project was the fixing of small code errors. I once had to spend a full 30 minutes going through my application-prod.properties file on Eclipse because my database wouldn't display in MySQL Workbench. However, I later discovered that I had added a semicolon on a line of code that wasn't supposed to have one. The need and necessity of peer review programming was made clear by this. Only five minutes after I asked the trainer to look at the code, he discovered the problem.

## Scope and Minimum Viable Product

* Code fully integrated into a Version Control System using the feature-branch model: main/dev/multiple features.
* A project management board with full expansion on user stories, acceptance criteria and tasks needed to complete the project.
* A risk assessment which outlines the issues and risks faced during the project timeframe.
* A relational database, hosted locally, which is used to persist data for the project. This database must contain at least one entity, with their structure and relationships modelled using an ERD. 
* A functional application created in Java (Spring Boot), following best practices and design principles, that you have covered during training that meets the requirements set on your Kanban Board with a functioning front-end website and integrated API.
* A build of your application, including any dependencies it might need, produced using an integrated build tool.
* Fully designed test suites for the application you are creating. You should aim to reach the industry-standard of 80% test coverage through unit and integration testing

## Getting Started

These instructions will get you a copy of the project and allow you to run it on your local machine for development and testing purposes. 

### Prerequisites

* Java - [Java SE Development Kit] [Java-link]
* Eclipse - [Eclipse for Developers] [Eclipse-link]
* MySQL Server - [MySQL Workbench] [MySQL Workbench-link]

[Java-link]: https://www.oracle.com/java/technologies/javase/jdk14-archive-downloads.html
[Eclipse-link]:  https://www.eclipse.org/downloads/
[MySQL Workbench-link]: https://dev.mysql.com/downloads/windows/installer/8.0.html

## Installing

To clone this repository to your local machine, enter the command listed below in any command-line terminal you have available:
```
git clone https://github.com/JoannaOyegbile/WebApplication.git 
```
### Import project to Eclipse: 

* Go to **_File > import_** 
* Under **Maven** choose existing **Maven project**
* Select the imported repository as the root directory 
* Then click import. 

## Running Application

### To run from Eclipse:

**_Right click the project folder > Run as > Spring Boot App_**

### To run on command line:

* Open a command prompt in the root folder. Then execute the following command:
```
java - jar WebApplication-0.0.1-SNAPSHOT.jar
```

## Running the Tests

* To run the test all together:

* Open project in Eclipse
* Drop down the hidden folders in the package explorer
* Go to **_src/test/java_**
* **_Right click> Run as > JUnit test_**

### **Unit tests**
* To run unit test:
  * Go to **_src/test/java/com.BAE.main.controller package._**
  * Locate **MusicControllerUnitTest** file and **_Right click > Run as > JUnit test._**
  * This would run the **Music controller** class alone to test its methods. 

### **Integration test**
* To run integration test:
  * Go to **_src/test/java/com.BAE.main.controller package._**
  * Locate **MusicControllerIntergrationTest** file and **_Right click > Run as > JUnit test_**
  * This would run the **Music controller**bclass alone to test its methods. 

### **Service test**
* To run servvice test:
  * Go to **_src/test/java/com.BAE.main.service package._**
  * Locate **MusicServiceUnitTest** file and **_Right click > Run as > JUnit test_**
  * This would run the **Music service** class alone to test its methods. 

## Build with:

* Spring Boot
* Mavern
* Java
* HTML, CSS, Javascript
* JUnit
* Mockito
* MySQL server
* GitHub

## Postman and API Interactions

This section will display the various Postman requests that were made along with the API responses.

### GET  request - /project/getAll

A straightforward GET request to display an empty database

![Empty GETAll request](https://github.com/JoannaOyegbile/WebApplication/blob/main/Documentation/Screenshots/Empty%20getAll%20request.png)
 
### POST to created a new music input -/project/Create

A POST request to add fields to an object and create it in the database.

![Post request](https://github.com/JoannaOyegbile/WebApplication/blob/main/Documentation/Screenshots/Create%20image.png)

### PUT to update music - /project/Update/{id}

Updating the database's music with the Id as a point of reference. The updated entry is displayed in the body console at the bottom. 

![PUT request](https://github.com/JoannaOyegbile/WebApplication/blob/main/Documentation/Screenshots/PUT%20image.png)


### Get All request to show the changed fields to reflect the update. 

![Get All request](https://github.com/JoannaOyegbile/WebApplication/blob/main/Documentation/Screenshots/GETALL%20image.png)


### DELETE to remove music - /project/delete/ {id}

This shows an entry being removed from the Music database, and the body console at the bottom returns “true” to show that the object with the “Id 10” has been deleted. 

![DELETE request](https://github.com/JoannaOyegbile/WebApplication/blob/main/Documentation/Screenshots/Delete%20image.png)

Get All request was made to show that the input with the Id 10 has been deleted and no longer exists in the database. 

![DELETE Get All request](https://github.com/JoannaOyegbile/WebApplication/blob/main/Documentation/Screenshots/Get%20All%20to%20show%20deletion.png)

### Custom Exception of any request - /project/getById/{id}
When on entry is found with the suggests input, this exception is returned
![Custom Exception of any request](https://github.com/JoannaOyegbile/WebApplication/blob/dev/Documentation/Screenshots/Example%20of%20Custom%20exceptions.png)


## Persistent database

Screenshots of the database in the Postman and MySQL GET requests are provided in this section

### SQL table 

![SQL table](https://github.com/JoannaOyegbile/WebApplication/blob/dev/Documentation/Screenshots/SQL%20table%20on%20Workbench.png)

### Spring Boot API Running
![Spring Boot API Running](https://github.com/JoannaOyegbile/WebApplication/blob/dev/Documentation/Screenshots/Spring%20Boot%20API%20Running.png)

## Test Results and Coverage

This is the test coverage for Web Application - src/main/java project with 87.1% coverage:
![test coverage](https://github.com/JoannaOyegbile/WebApplication/blob/dev/Documentation/Screenshots/Test%20results%20of%20all%20test.png)

![test coverage](https://github.com/JoannaOyegbile/WebApplication/blob/dev/Documentation/Screenshots/Coverage%20test.png)

## Swagger API

![Swagger API](https://github.com/JoannaOyegbile/WebApplication/blob/dev/Documentation/Swagger%20API.PNG)


## Jira Board

Please find the link here for the project’s [Jira Board][Jira Board-link].


## Author

Joanna Oyegbile - [JoannaOyegbile][JoannaOyegbile-link]

[JoannaOyegbile-link]: https://github.com/JoannaOyegbile
[Jira Board-link]: https://joyegbile99.atlassian.net/jira/software/projects/WAPM/boards/2/roadmap



