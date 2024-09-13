# 🚀 Salesforce Automation Framework

Welcome to the **Salesforce Automation Framework**! This repository contains a robust testing framework designed to streamline the automation of Salesforce workflows, regression, and functional tests. Built using **Selenium**, **BDD Cucumber**, and **TestNG**, this framework provides a comprehensive solution for automating and testing Salesforce features with ease.

![image](https://github.com/user-attachments/assets/4d66cd33-3369-452d-af68-fca544ec3051)

---

## 📋 Table of Contents

1. [Overview](#overview)
2. [Tech Stack](#tech-stack)
3. [Features](#features)
4. [Setup Instructions](#setup-instructions)
5. [Running the Tests](#running-the-tests)
6. [Contributing](#contributing)
7. [License](#license)

---

## 🌟 Overview

This automation framework is crafted to perform end-to-end **workflow testing**, **regression testing**, and **functional testing** for Salesforce applications. The framework leverages **Page Object Model (POM)** for structuring the tests and uses **BDD Cucumber** to define scenarios with readable, human-friendly Gherkin syntax.

Whether you are automating workflows or conducting regression testing for Salesforce deployments, this framework ensures smooth integration and scalability for both **QA** and **Production** environments.

---

## 🛠 Tech Stack

- **Language**: Java  
- **Automation**: Selenium, BDD Cucumber, Gherkin  
- **Framework**: Page Object Model (POM), TestNG  
- **Build Tool**: Maven  
- **Test Execution**: TestNG + Maven

---

## 🚀 Features

- **Fully Automated Salesforce Workflow Testing**: Automates key workflows to ensure that business-critical functionalities are continuously tested.
- **Regression Testing**: Ensures that changes and updates do not break existing features.
- **Functional Testing**: Validates new Salesforce functionalities to confirm that they meet the business requirements.
- **BDD Cucumber Integration**: Write test cases in plain English using Gherkin syntax for better communication between technical and non-technical stakeholders.
- **Modular POM Structure**: Ensures high code reusability, maintainability, and scalability.

---

## ⚙️ Setup Instructions

1. **Clone the repository**:
   ```bash
   gh repo clone ankitsharna-jswone/SF-Automation
   ```
   
2. **Navigate to the project directory**:
   ```bash
   cd SF_Op53_43
   ```
   
3. **Install dependencies**:
   Ensure you have Maven installed. Then run the following command:
   ```bash
   mvn clean install
   ```

4. **Configure your test environment**:
   - Update the properties in `config.properties` to match your Salesforce instance.
   - Modify `features/*.feature` files to add new test scenarios as per your needs.

---

## 🏃‍♂️ Running the Tests

1. **Run all tests via Maven**:
   ```bash
   mvn test
   ```

2. **Generate Cucumber reports**:
   ```bash
   mvn verify
   ```

   Test results and Cucumber reports can be found in the `/target` directory after execution.

3. **Test with specific tags**:
   To run tests with specific tags, use the `-Dcucumber.options`:
   ```bash
   mvn test -Dcucumber.options="--tags @yourTag"
   ```

---

## 🤝 Contributing

Contributions are what make the open-source community such an amazing place to learn, inspire, and create. Feel free to fork this project, submit issues, or make pull requests if you'd like to improve the framework.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📄 License

This project is licensed under the MIT License – see the [LICENSE](LICENSE) file for details.

---

Happy Testing! 🎉

For more details, contact Ankit Sharma(mailto:your-email@example.com) or visit the [project documentation](https://github.com/your-username/salesforce-automation-framework/wiki).

--- 

Feel free to customize the links, contact information, and any additional sections as necessary!
