# Project Description: Simple Calculator Application
This is a Spring Boot-based web application that serves as a simple calculator. It allows users to perform basic arithmetic operations such as addition, subtraction, multiplication, division, and modulus. The application is designed with a user-friendly interface and robust error handling to ensure smooth functionality. Here's a detailed breakdown:


# Features
Basic Operations

Addition: Adds two numbers.
Subtraction: Subtracts the second number from the first.
Multiplication: Multiplies two numbers.
Division: Divides the first number by the second (with zero-division protection).
Modulus: Computes the remainder when the first number is divided by the second.
Error Handling

Prevents division or modulus by zero with clear error messages.
Handles invalid operations with appropriate user feedback.
Ensures users cannot submit empty or invalid inputs.
User-Friendly Interface

A clean homepage (home.html) where users input numbers and select an operation.
A result page (result.html) displaying the operation, result, and any errors if applicable.
Spring MVC Architecture

Utilizes the Model-View-Controller pattern to separate concerns.
CalculatorController handles user requests and delegates calculations to the service layer.
CalculatorService contains the business logic for calculations.


# Technical Overview
1. Project Structure
Controller (CalculatorController):
Manages user requests, performs validation, handles errors, and sends results to the view.

Service (CalculatorService):
Encapsulates all arithmetic operations (add, subtract, multiply, divide, modulus).

Frontend (home.html & result.html):
Uses Thymeleaf templates for dynamic HTML rendering and user interaction.

2. Technology Stack
Backend: Spring Boot (Spring MVC, Spring Dependency Injection)
Frontend: HTML5, CSS, Thymeleaf
Build Tool: Maven
Java Version: Compatible with Java 8 and above

# Workflow
Homepage (home.html):

Users enter two numbers and select an operation (via buttons).
The form submits the data to the /calculate endpoint.
Controller (CalculatorController):

Accepts user input from the form.
Validates the input (e.g., checks for zero-division).
Delegates calculations to the CalculatorService.
Service (CalculatorService):

Executes the requested arithmetic operation.
Returns the result to the controller.
Result Page (result.html):

Displays the calculation result along with the numbers and operation.
If an error occurs (e.g., invalid operation, division by zero), the error message is displayed instead.
