# Project OpenCart - Hybrid Automation Framework

---

## Overview

This project is a **Hybrid Automation Testing Framework** built using **Java**, **Selenium WebDriver**, **TestNG**, **Maven**, and the **Page Object Model** (POM) design pattern. The framework is designed to be highly scalable, modular, and adaptable, allowing testers to run automated tests efficiently.

### What is OpenCart?

**OpenCart** is a popular open-source e-commerce platform that provides a robust solution for online merchants to create and manage their stores. With its user-friendly interface, flexibility, and rich feature set, OpenCart is widely used for online stores of all sizes.

For this project, we are utilizing an existing deployed instance of OpenCart for our automation testing:  
**URL:** [https://opencart.abstracta.us](https://opencart.abstracta.us)

### Why OpenCart?

OpenCart offers a comprehensive platform for testing multiple e-commerce functionalities, including:
- User account registration and login.
- Product search and filtering.
- Product selection and checkout process.
- Adding/removing items from the shopping cart.
- User profile management (My Account page).

By testing on this platform, we can ensure that our **automation framework** is able to validate various real-world e-commerce scenarios in a robust and scalable way.

---

## Key Features of the Hybrid Automation Framework:

1. **Page Object Model (POM)**: For enhanced code reusability and maintainability, all page-related actions are separated into different classes, improving readability and efficiency.
2. **Data-Driven Testing** using TestNG's DataProvider.
3. **TestNG Integration**: Enables easy test configuration, parallel execution, and reporting.
4. **Cross-Browser Testing**: Supports testing on different browsers such as Chrome, Firefox, and others.
5. **Configurable Test Environment**: Test configurations (like browser type, URLs, etc.) are managed via a `config.properties` file.
6. **Maven** for dependency management and project build lifecycle.
7. **Log4j2** integrated for enhanced logging.
8. **Detailed Reporting**: Provides in-depth reports using TestNG, with potential support for advanced reporting tools like ExtentReports.
9. **Parallel Testing**: Executes multiple test cases simultaneously, reducing overall execution time.
10. - Screenshot capture on failed tests.

---

## Table of Contents

1. [Project Structure](#project-structure)
2. [Prerequisites](#prerequisites)
3. [Installation](#installation)
4. [Usage](#usage)
5. [Running Tests](#running-tests)
6. [Test Reporting](#test-reporting)
7. [Logging](#logging)
8. [Screenshots](#screenshots)
9. [Configuration Files](#configuration-files)
10. [Contributing](#contributing)
11. [References](#references)

---

## Project Structure

```
Project_OpenCart
│
├── src/test/java
│   ├── com.base
│   │   ├── BasePage.java
│   │   └── BaseTest.java
│   ├── com.ddtestcase
│   │   └── TC001_LoginDDTest.java
│   ├── com.pom
|   |   ├── AddToCartPage.java
│   │   ├── CheckoutPage.java
│   │   ├── CheckProductPage.java
│   │   ├── DropDownPage.java
│   │   ├── HomePage.java
│   │   ├── LoginPage.java
│   │   ├── MyAccountPage.java
│   │   ├── RegisterPage.java
│   │   └── SearchProductPage.java
│   ├── com.testcases
│   │   ├── TC001_AccountRegistrationTest.java
│   │   ├── TC002_AccountLoginTest.java
│   │   ├── TC003_SelectProductTest.java
│   │   ├── TC004_SearchProductTest.java
│   │   ├── TC005_DropDownProductTest.java
│   │   ├── TC006_AddToCartTest.java
│   │   └── TC007_EndToEndTest.java
│   └── com.utilities
├── src/test/resources
│   ├── config.properties
│   └── log4j2.xml
│
├── logs
├── reports
├── screenshots
├── pom.xml
└── test-output
```

---

## Prerequisites

To set up and run this project, make sure you have the following installed:

- **Java 1.8** or higher
- **Maven** for dependency management
- **Selenium WebDriver** version 4.0 or higher
- **TestNG** for test execution
- **Git** for version control

---

## Installation



---

## Usage

## Running the Project

You can execute your test cases directly from the **Eclipse IDE** using the **Run As -> TestNG** Suite option. Follow the steps below to run the tests.

## Running Tests via IDE:

          1.Open Eclipse IDE.
          2.Navigate to the src/test/resources folder.
          3.Right-click on a TestNG XML file (e.g., cross_browsing_testing.xml, grouping.xml, etc.).
          4.Select Run As -> TestNG Suite.

## Test Suites:
          cross_browsing_testing.xml: Executes cross-browser tests as configured.
          grouping.xml: Runs tests grouped into different categories (if applicable).

## Running Tests

  **From Eclipse IDE:**
  
          You can run your tests easily from within Eclipse IDE. Just follow these steps:
          
          1.Navigate to the src/test/resources directory.
          2.Locate the TestNG XML file you want to run:
          For cross-browser tests, use cross_browsing_testing.xml.
             - For grouped tests, use grouping.xml.
             - Right-click on the desired XML file.
          3.Select Run As -> TestNG Suite.
          
          This will execute the test suite, and the results will be displayed in the **TestNG Results** window in Eclipse.

---

## Test Reporting

- **TestNG Reports**: After executing the tests, TestNG generates detailed reports in the `test-output` folder.
- **Custom Reports**: Any additional custom reports configured in the project are stored in the `reports` directory.
- **HTML Reports**: TestNG provides an HTML version of the report located at `test-output/index.html`.

---

## Logging

The project uses **Log4j2** for detailed logging. Logs are generated automatically during test execution and stored in the `logs` folder.

- **Log Configuration**: You can modify log levels and patterns in the `log4j2.xml` file located in `src/test/resources/`.

---

## Screenshots

The framework captures screenshots of failed test cases automatically. These screenshots are saved in the `screenshots` directory for debugging purposes.

- **Location**: `screenshots/`
- **When Captured**: Only for failed tests.

---

## Configuration Files

### `config.properties`
This file contains various settings and configuration options for the framework, such as:

- **Browser Type**: (Chrome, Firefox, etc.)
- **Base URL**: The URL of the OpenCart application.
- **Timeouts**: Implicit wait times and other timeout values.

**Location**: `src/test/resources/config.properties`

### `log4j2.xml`
This file manages the logging configuration, including log levels, file appenders, and log file formats.

**Location**: `src/test/resources/log4j2.xml`

---


---

---

## References

- [Java 8 Documentation](https://docs.oracle.com/javase/8/docs/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)

---
