# Project Framework --> HYBRID AUTOMATION FRAMEWORK

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

### Key Features of the Hybrid Automation Framework:

1. **Page Object Model (POM)**: For enhanced code reusability and maintainability, all page-related actions are separated into different classes, improving readability and efficiency.
2. **TestNG Integration**: Enables easy test configuration, parallel execution, and reporting.
3. **Cross-Browser Testing**: Supports testing on different browsers such as Chrome, Firefox, and others.
4. **Configurable Test Environment**: Test configurations (like browser type, URLs, etc.) are managed via a `config.properties` file.
5. **Detailed Reporting**: Provides in-depth reports using TestNG, with potential support for advanced reporting tools like ExtentReports.
6. **Parallel Testing**: Executes multiple test cases simultaneously, reducing overall execution time.

---

## Use Tools & Technologies
- **Java**
- **Selenium**
- **TestNG**
- **Maven**
- **Page Object Model**

---

## STEP 1: Create a New Maven Project

---

## STEP 2: Required Maven Dependencies  
Add all required dependencies in `pom.xml`:

```xml
<!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.23.0</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.testng/testng -->
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.10.2</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi</artifactId>
    <version>5.3.0</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.poi/poi-ooxml -->
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.3.0</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.23.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.23.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-slf4j-impl -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.23.1</version>
    <scope>test</scope>
</dependency>

<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.2</version>
</dependency>

<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.16.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
<dependency>
    <groupId>org.apache.commons</groupId>
    <artifactId>commons-lang3</artifactId>
    <version>3.13.0</version>
</dependency>
```

---

## STEP 3: Basic Project Structure

```
--> projectName
    -> src/test/java
        -> com.base
        -> com.pom
        -> com.testcases
        -> com.utilies
    -> src/test/resources
        -> log4j.xml
    -> JRE System Library
    -> Maven Dependencies
    -> logs
    -> reports
    -> screenshots
    -> src
    -> target
    -> testdata
    -> test-output
    | pom.xml
    | ProjectProcess.md
```

---

## STEP 4: Development of Hybrid Driven Framework

### Step 1: Create Test Case - User Account Registration

- 1.1 Create `BasePage` class under the `com.base` package which includes only the constructor. This will be invoked by every Page Object Class constructor for reusability.
- 1.2 Create page object classes for `HomePage` and `RegisterPage` under the `com.pom` package (these classes extend `BasePage`).
- 1.3 Create a class `TC001_AccountRegistrationTest` under the `com.testcases` package.
- 1.4 Create a class `BaseTest` under the `com.base` package and copy reusable methods.
- 1.5 Create reusable methods to generate random strings and numbers in the `BaseTest` class.

### Step 2: Adding Logs to Test Case (log4j)

- 2.1 Create `log4j2.xml` file under `src/test/resources` and define properties, appenders, and loggers.
- 2.2 Update the `BaseTest` class by creating a `Logger` object.
- 2.3 Add log statements to the `TC001_AccountRegistrationTest` class.

### Step 3: Run Tests on Parallel/Cross Browser/Desired Browser

- 3.1 Create a `master.xml` file to run test cases and parameterize OS and browser names for the `BaseTest` class `startUp()` method.
- 3.2 Update the `startUp()` method with the `@Parameters({ "os", "browser" })` annotation and set values according to the XML file to launch the browser.
- 3.3 Maintain a separate XML file to run tests on multiple browsers in parallel.

### Step 4: Read Common Values from the `config.properties` File

- 4.1 Create a `config.properties` file under `src/test/resources` and write the required configuration.
- 4.2 Update the `BaseTest` `startUp()` method to load the `config.properties` file.
- 4.3 Replace hardcoded values in test cases such as URL, username, and password with values from the properties file.

### Step 5: Login Test Case

- 5.1 Create a new page object class for `LoginPage` and update the `HomePage` class by adding the login link.
- 5.2 Create a test case class `LoginTest`.
- 5.3 Add an entry for `LoginTest` in the `master.xml` file.

### Step 6: Data Driven Login Test

- 6.1 Prepare test data in Excel and place the Excel file inside the `testData` folder (e.g., `OpenCart_Project.xlsx`).
- 6.2 Create an `ExcelUtility` class under the `utilities` package.
- 6.3 Update the `MyAccountPage` page object class by adding a logout link element.
- 6.4 Create a `DataProviders` class in the `utilities` package to maintain data providers for data-driven tests.
- 6.5 Create the `LoginDataDrivenTest` class under the `ddtestcases` package.
- 6.6 Add an entry for the data-driven test in the `master.xml` file.

### Step 7: Group Testing

- 7.1 Add all test cases into specific groups (sanity, regression, master, etc.).
- 7.2 Specify the group under the test method in the test class.
- 7.3 Add the `startUp()` and `tearDown()` methods from the `BaseTest` class to all groups.
- 7.4 Create a separate TestNG XML file (`grouping.xml`) to run tests by group and include the groups you want to execute.

Example:

```xml
<groups>
    <run>
        <!--<include name="sanity"></include>-->
        <!--<include name="regression"></include>-->
        <!--<include name="datadriven"></include>-->
        <include name="master"></include>
        <!--<exclude name="datadriven"></exclude>-->
    </run>
</groups>
```

### Step 8: Add Extent Reports to the Project

- 8.1 Create an `OC_ExtentReportManager` utility class under the `utilities` package.
- 8.2 Add the `captureScreen()` method in the `BaseTest` class.
- 8.3 Ensure the `WebDriver` is `public static` in the `BaseTest` class so that the same driver instance is used in `OC_ExtentReportManager`.
- 8.4 Add an entry for `OC_ExtentReportManager` in the XML files (`master.xml`, `grouping.xml`).

Example:

```xml
<listeners>
    <listener class-name="com.utilities.OC_ExtentReportManager"></listener>
</listeners>
```

### Step 9: Run Failed Tests

- 9.1 Open the `test-output/testng-failed.xml` file with a text editor.
- 9.2 Update the XML and rerun the failed tests.
- 9.3 Failed tests will be automatically removed once they pass.

### Step 10: Run Test Cases Using `pom.xml`, Command Prompt, or `run.bat` File

- 10.1 Go to the `pom.xml` and add the plugins below under the `<build>` tag. Run the tests with Maven.

```xml
<build>
    <!-- To define the plugin version in your parent POM -->
    <pluginManagement>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
               

 <version>3.13.0</version>  <!-- Compiles the project -->
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.4.0</version>  <!-- Runs the project -->
                <configuration>
                    <suiteXmlFiles>
                        <suiteXmlFile>grouping.xml</suiteXmlFile> <!-- Name of the XML file to execute -->
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </pluginManagement>
</build>
```

---


## Conclusion

This **Hybrid Automation Framework** for **OpenCart** brings together the power of modern automation tools and best practices in testing. With its modular design, based on the **Page Object Model (POM) and TestNG**, it provides a flexible, scalable solution for e-commerce testing. The framework’s ability to support cross-browser testing, parallel execution, and data-driven testing ensures efficient test coverage across different environments and data sets.

By utilizing OpenCart's deployed environment [https://opencart.abstracta.us](https://opencart.abstracta.us), this project simulates real-world e-commerce scenarios such as user registration, login, product search, and checkout processes. This ensures that the automated tests validate critical paths that users are most likely to engage with in an online store.

Additionally, the framework’s integration with Selenium WebDriver allows for seamless interaction with web elements, while Maven simplifies dependency management and project setup. With the possibility of extending the framework for advanced reporting using tools like **ExtentReports**, this framework is well-suited for teams looking to adopt a scalable and maintainable automation solution.

In conclusion, this **Automation Framework** provides QA teams with a powerful tool to perform comprehensive testing of OpenCart or similar web applications, significantly improving testing speed, accuracy, and reliability. Future enhancements, such as integrating with Docker or cloud testing platforms, will further elevate the framework's capability to meet modern testing demands.