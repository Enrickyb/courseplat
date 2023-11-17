**Finance Control API - README**

## Overview

Finance Control API is a Spring Boot project designed for personal finance management. It provides a set of APIs to manage users, transactions (expenses and incomes), categories, and companies. This README provides an overview of the project structure, key components, and instructions for running the application.

## Table of Contents

1. [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
    - [Running the Application](#running-the-application)
2. [Project Structure](#project-structure)
    - [UserControllers](#usercontrollers)
    - [TransactionControllers](#transactioncontrollers)
    - [Configs](#configs)
3. [Endpoints](#endpoints)
    - [User Endpoints](#user-endpoints)
    - [Authentication Endpoints](#authentication-endpoints)
    - [Transaction Endpoints](#transaction-endpoints)
    - [Category Endpoints](#category-endpoints)
    - [Company Endpoints](#company-endpoints)
4. [Security](#security)
    - [SecurityFilter](#securityfilter)
5. [Contributing](#contributing)
6. [License](#license)

## Getting Started

### Prerequisites

- Java 11 or later
- Maven
- Database (e.g., MySQL)

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/Enrickyb/finance_control_api.git
   ```

2. Navigate to the project directory:

   ```bash
   cd finance_control_api
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

### Running the Application

1. Configure the database connection in `application.properties`.
2. Run the application:

   ```bash
   java -jar target/finance_control_api.jar
   ```

   The application will be accessible at `http://localhost:8080`.

## Project Structure

### UserControllers

- **UserController**: Manages user-related operations, such as retrieving users by ID and listing all users.
- **AuthenticationController**: Manages user authentication operations, including login and registration.

### TransactionControllers

- **TransactionController**: Manages expense and income transactions, including creation and retrieval.
- **CategoryController**: Manages transaction categories, including creation and retrieval.
- **CompanyController**: Manages companies associated with transactions, including creation and retrieval.

### Configs

- **SecurityFilter**: Custom security filter for handling authentication and authorization.

## Endpoints

### User Endpoints

- `GET /user/{id}`: Retrieves a user by ID.
- `GET /user/all`: Lists all users.

### Authentication Endpoints

- `POST /auth/login`: Performs user login.
- `POST /auth/register`: Registers a new user.

### Transaction Endpoints

- `POST /transaction/expense/create`: Creates a new expense.
- `GET /transaction/expense/all`: Lists all expenses.
- `GET /transaction/expense/get/{id}`: Retrieves an expense by ID.
- `GET /transaction/expense/user/{id}`: Retrieves expenses for a specific user.
- `GET /transaction/all`: Lists all transactions (expenses and incomes).
- `POST /transaction/income/create`: Creates a new income.
- `GET /transaction/income/all`: Lists all incomes.
- `GET /transaction/income/{id}`: Retrieves an income by ID.

### Category Endpoints

- `POST /transaction/category/create`: Creates a new category.
- `GET /transaction/category/all`: Lists all categories.
- `GET /transaction/category/get/{id}`: Retrieves a category by ID.

### Company Endpoints

- `POST /transaction/company/create`: Creates a new company.
- `GET /transaction/company/all`: Lists all companies.
- `GET /transaction/company/get/{id}`: Retrieves a company by ID.

## Security

### SecurityFilter

The `SecurityFilter` is a custom filter responsible for token validation and user authentication. It intercepts incoming requests, validates the token, and sets the authenticated user in the security context.

