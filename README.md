# Project OpenCart - Hybrid Automation Framework


## Overview

**Project OpenCart** is a **Hybrid Automation Framework** built using **Java**, **Selenium WebDriver**, **TestNG**, and **Maven**. 
It follows the **Page Object Model (POM)** design pattern to provide a robust and scalable structure for testing the OpenCart application. 
The framework is designed to support data-driven, cross-browser, and parallel execution testing strategies.

### Key Features:
- **Page Object Model (POM)** to keep the test code modular and maintainable.
- **Data-Driven Testing** using TestNG's DataProvider.
- **Cross-Browser Testing** for Chrome, Firefox, and other browsers.
- **TestNG** for test execution, parallel test execution, and custom reporting.
- **Maven** for dependency management and project build lifecycle.
- **Log4j2** integrated for enhanced logging.
- Screenshot capture on failed tests.

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
              ── For grouped tests, use grouping.xml.
              ── Right-click on the desired XML file.
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

## Contributing

Contributions are welcome! If you want to contribute to the project, follow these steps:

1. Fork the repository.
2. Create a new feature branch (`git checkout -b feature-branch`).
3. Make your changes and commit them (`git commit -am 'Add new feature'`).
4. Push to the branch (`git push origin feature-branch`).
5. Create a Pull Request.

### Guidelines:
- Ensure the code passes all tests before submitting.
- Follow the existing coding standards.
- Add appropriate documentation for your changes.

---

---

## References

- [Java 8 Documentation](https://docs.oracle.com/javase/8/docs/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Documentation](https://maven.apache.org/guides/)

---
