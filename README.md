# Invoice Management System

This is a simple Invoice Management System web application built with Java and Spring Boot.

## Introduction

This application provides a basic invoice management system where users can create, update, and delete invoices. It also includes a RESTful API for managing tasks programmatically.

## Features

- Create, update, and delete invoices
- View list of invoices
- RESTful API for invoice management

## Prerequisites

Before running the application, make sure you have the following installed on your system:

- Java 17 or higher
- Maven
- PostgreSQL or any other compatible database

## How to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/your-username/invoice-management-system.git
   cd invoice-management-system

2. **Set Up the Database**:

- Create a PostgreSQL database named postgres.
- Run the following SQL script to create the invoices table:
   ```bash
   CREATE TABLE invoices (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   invoice_number VARCHAR(255) NOT NULL UNIQUE,
   date DATE, amount DECIMAL(10,2),
   customer_name VARCHAR(255)
   );

3. **Configure Database Connection**:

- Open src/main/resources/application.properties file.
- Update the database connection details according to your PostgreSQL configuration:

   ```bash
   spring.application.name=InvoiceManagementSystem
   spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
   spring.datasource.username=postgres
   spring.datasource.password=root
   spring.datasource.driver-class-name=org.postgresql.Driver

4. **Build and Run the Application**:
   
- Build the application using Maven:
   ```bash
     mvn clean install

- Run the application:
   ```bash
   java -jar target/InvoiceManagementSystem-1.0.0.jar

5. **Access the Application**:
Open your web browser and go to http://localhost:8080/invoices/home to access the application.

- **Endpoints:**
- **GET /invoices/allTasks**: Get all invoices.
- **GET /invoices/{id}**: Get an invoice by ID.
- **POST /invoices**: Create a new invoice.
- **PUT /invoices/{id}**: Update an existing invoice.
- **DELETE /invoices/{id}**: Delete an invoice by ID.

- **Frontend Structure:**
- The frontend is implemented using HTML and JavaScript.
- The main HTML file is `index.html`, which contains the structure for displaying invoices in a table and forms for adding and editing invoices.
- Inline JavaScript is used within `index.html` to handle user interactions such as fetching invoices via AJAX, populating the table dynamically, adding new invoices, editing existing invoices, and deleting invoices.

## Database Schema

- The application uses a PostgreSQL database with the following schema:  
   ```bash
   CREATE TABLE invoices (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   invoice_number VARCHAR(255) NOT NULL UNIQUE,
   date DATE, amount DECIMAL(10,2),
   customer_name VARCHAR(255)
   );

## Contributing

- Contributions are welcome! If you find any issues or have suggestions for improvements, please open an issue or submit a pull request.

### Feel free to customize this README.md file further if needed, and don't forget to replace placeholders like `your-username`, `your_password`, and any others with your actual project details.
