Bank Management System (JDBC)
Overview

The Bank Management System is a Java-based application developed using JDBC (Java Database Connectivity) to manage banking operations such as customer accounts, deposits, withdrawals, and transactions.

This project is created for learning and practicing Java, JDBC, and database management in a real-world banking scenario.

Features

Create new bank accounts
View account details
Deposit money
Withdraw money
Transfer funds between accounts
Delete account
View transaction history
Simple console-based interface

Technologies Used

Java
JDBC (Java Database Connectivity)
MySQL Database
IDE (Eclipse / IntelliJ IDEA / VS Code)
Project Structure
Bank-Management-System/
│
├── src/
│   ├── Main.java
│   ├── Account.java
│   ├── Transaction.java
│   ├── BankDAO.java
│   └── DBConnection.java
│
├── lib/
│   └── mysql-connector-j.jar
│
└── README.md
Database Setup
Install MySQL and open MySQL Workbench or terminal.
Create database:
CREATE DATABASE bank_db;
USE bank_db;
Create tables:
CREATE TABLE accounts (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    account_type VARCHAR(50),
    balance DOUBLE
);
CREATE TABLE transactions (
    id INT PRIMARY KEY AUTO_INCREMENT,
    account_id INT,
    type VARCHAR(50),
    amount DOUBLE,
    transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);
JDBC Configuration

Update your database credentials inside DBConnection.java:

String url = "jdbc:mysql://localhost:3306/bank_db";
String user = "root";
String password = "your_password";
How to Run
Clone the repository:
git clone https://github.com/your-username/bank-management-system.git
Open the project in your IDE.
Add MySQL Connector JAR file to the project.
Run Main.java.

Sample Operations

Create Account
View Account
Deposit Money
Withdraw Money
Transfer Funds
View Transactions
Learning Outcomes
Understanding JDBC connectivity
Performing CRUD operations
Handling financial transactions logic
Managing relational databases
