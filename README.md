# IssueTrackingSystem

# Project description

The IssueTracking system is a program which stores projects and issues of those projects, so that developers can keep track of their progess on fixing those issues
and also having a record of them. The project uses a MySQL databse to establish a bi-directional one to many relationship between two entities - Projects and Issues.
One project can have many issues hence the chosen relationship. The program also uses Hibernate to take care of the interaction between the databse and the internal
logic of the program. Additialy, Spring Boot is also used for ovrall configuration of the program and establishing a connection to the server through CRUD operations
by using REST api.

# Future improvements

Currently the project does not have a User Interface and the way it has been tested is through using the Postman application for testing CRUD operations. However, in
the next update of the program will be included the integration of Angular JS to solve this useability issue. 

# Learning outcome

After completing this project I managed to learn how to use REST api with the help of Spring Boot and also how to apply my current knowledge on Hibernate and apply it 
to a Spring Boot project. Also, what caught my eye was the project structure. For the first time I decided to use multiple packages to sepparate different components
of my code and that made life much easier and helped me organise my work neetly and hopefully make it more understandable to other developers who might want to look
at the code. In addition, I understood what ResponseEntities do and how they can make you manage the HttpStatus depending on whether a request is approved or not. 
Antoher first for me was making custom exceptions which I can throw in case a certain type of issue occurs.

# Lack of understanding

The main thing that I could't fully understand was the use of Dto(Data transfer object) classes and why they act as a buffer between the entite classes and the controllers.
