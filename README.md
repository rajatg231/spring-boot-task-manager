# TASK MANAGER API WITH SPRING BOOT
A CRUD API for Task Management System using Spring Boot, and PostgreSQL database. For frontend UI follow this [link](https://github.com/rajatg231/flutter-task-manager.git).

A working demonstration of the task manager can be seen in this [video](https://www.loom.com/share/6592251f03b74094952b2f31f3c91b45).

## Running Spring Boot Application
This repository contains a Spring Boot application that you can clone and run on your local machine. Follow the steps below to get started.

## Clone the Repository
```bash
git clone https://github.com/rajatg231/spring-boot-task-manager.git
```

## Database Configuration
y default, this application uses postgreSQL database for development purposes. If you want to use a different database, you will need to modify the application.properties file.

Navigate to the **src/main/resources** directory and open the **application.properties** file. Modify the following properties to match your database configuration:

```properties
spring.datasource.url=jdbc:mysql://<your database URL>
spring.datasource.username=<your database username>
spring.datasource.password=<your database password>
spring.datasource.driver-class-name=<driver class name based on your database>
spring.jpa.hibernate.ddl-auto=create
```

## Run the Application
Navigate to the root directory of the cloned repository in your terminal, This app is using Maven so use the following command to run the application:
```bash
./mvnw spring-boot:run
```

The application should now be running at http://localhost:8080. You can access the application by opening a web browser and navigating to that URL.

To stop the application, press CTRL+C in the terminal where it is running.
