# Customer Call Management System

This project is a Customer Call Management System designed to manage customer records and call histories. It provides functionalities to log customer details, track call records, and organise customer-related data in a structured format.

**This work was completed as a part of my undergraduate degree in Applied Software Engineering at Swansea University, which CGI Inc. sponsored.**

## Project Structure

The project is organised into the following packages:

- **app**: The main entry point for running the application.
- **model**: Holds core data models representing customers and call records.

### Files Overview

- `Main.java` (in `app`): The main class that initiates the program, providing a command-line interface for interacting with the system.
- `Customer.java` (in `model`): Represents a customer, containing essential details such as name, contact information, and unique ID.
- `CallRecord.java` (in `model`): Logs information about each call made to or from a customer, including date, time, and duration.

## Features

- **Customer Management**: Allows adding, updating, and viewing customer details.
- **Call Records**: Logs call history associated with each customer.
- **Console Interface**: Provides a simple command-line interface for navigating the program's features.

## Getting Started

### Prerequisites

- Java 8 or later
- An IDE like Eclipse or IntelliJ for running the project

### Setup

1. Clone the repository to your local machine.
2. Open the project in your preferred IDE.
3. Ensure that the project’s directory structure matches the package names.

### Running the Application

1. Compile the project files.
2. Run the `Main` class in the `main` package.
3. Follow the console instructions to interact with the application.

## Usage

1. **Customer Data**: The application allows users to add, update, or view customer information.
2. **Call Logging**: Users can log new call records associated with each customer, including call details like date, time, and duration.

## Future Enhancements

Potential improvements for the project include:

- **Database Integration**: Adding a database to store customer and call record data persistently.
- **GUI Interface**: Creating a graphical interface for more intuitive user interactions.
- **Report Generation**: Implementing functionality to generate reports based on customer interactions and call histories.

