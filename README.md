Java Banking Application

Welcome to the Java Banking Application. This is a console-based project built using core Java to simulate basic banking operations while demonstrating Object-Oriented Programming (OOP) concepts like abstraction, inheritance, interfaces, and polymorphism.

* Overview

The application allows users to:

->Open different types of accounts (Savings, Current, Loan)

->Deposit money into an account

->Withdraw money from an account

->Display bank and account details

The system supports both Nationalized and Cooperative banks, each with branch-wise account tracking and unique codes.

* Technologies Used

->Java 8 or higher

->No external libraries

->Console-based application (no GUI)

->Can be run using any Java IDE or terminal

* Features

->Open account (Savings, Current, Loan)

->Deposit and withdraw money

->Display full bank and account details

->Handles multiple branches and account types

->Demonstrates OOP concepts:

      Abstraction (Account, Bank classes)

      Interface (AccountOperations)

      Inheritance (SavingsAccount, CurrentAccount, LoanAccount, Bank types)

      Polymorphism (Account and Bank references)

* Project Structure

->BankApp.java - Main class with menu interface

->Account.java - Abstract base class for account details

->AccountOperations.java - Interface for deposit/withdraw

->Bank.java - Abstract class for bank-level operations

->NationalizedBank.java - Implementation of a nationalized bank

->CooperativeBank.java - Implementation of a cooperative bank

->SavingsAccount.java - Concrete savings account class

->CurrentAccount.java - Concrete current account class

->LoanAccount.java - Concrete loan account class

* Use Cases Implemented

->Open Account

Create an account with holder name, type, and balance

Auto-generates account number and adds it to the selected branch

->Deposit Amount

Input account number and branch

Deposits the entered amount and updates balance

->Withdraw Amount

Input account number and branch

Checks for sufficient balance before withdrawing

->Display Bank and Account Details

Lists all accounts in a bank branch

Shows bank code, name, branch, and account holder info

* How to Run

->Open the project in any Java IDE or terminal

->Compile all Java files

    Example: javac banking/*.java

->Run the main class

    Example: java banking.BankApp

->Follow the on-screen menu to interact with the system

* Sample Menu

Open Account

Deposit

Withdraw

Display Bank & Account Details

Exit
