Java-RestAssured API Testing Framework.

This repository contains a REST API test automation framework built using Java, RestAssured, and TestNG. It includes automated test cases for various HTTP operations and is structured for easy maintenance, scalability, and CI/CD integration.

🔧 Tech Stack

Programming Language: Java

Testing Library: RestAssured

Test Runner: TestNG

Build Tool: Maven

CI/CD Compatible: Yes (Jenkins-ready)

📁 Project Structure

src/
├── main/
│   └── java/
├── test/
│   └── java/
│       └── userManagement/
│           ├── getUsers.java
│           └── getPostmanEcho.java
testng.xml
pom.xml

✅ Features

API testing with GET endpoints

Organized test classes under userManagement package

TestNG XML suite for running grouped tests

Easily extendable for other HTTP methods (POST, PUT, DELETE)

Maven integration for build and dependency management

Ready for Jenkins or other CI tools

🧪 How to Run Tests Locally

Clone the repository:

git clone https://github.com/Deepika5reddy/Java-RestAssured.git
cd Java-RestAssured

Build and run tests:

mvn clean test

To run a specific TestNG suite:

mvn test -DsuiteXmlFile=SmokeSuite.xml

🧾 Test Suites

SmokeSuite.xml — includes getUsers and getPostmanEcho test cases for quick validation

📦 Maven Dependency (For Reference)

<dependency>
  <groupId>io.rest-assured</groupId>
  <artifactId>rest-assured</artifactId>
  <version>5.3.0</version>
  <scope>test</scope>
</dependency>

🚀 Jenkins Integration

To integrate this project into a Jenkins pipeline, you can use the Jenkinsfile in Repo

💡 You can use -DskipTests=true to skip test execution when needed, or configure conditional execution using environment variables.

📈 Future Enhancements

Add logging and custom reporting (e.g., Allure or ExtentReports)
