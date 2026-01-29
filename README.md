
# Automation (Selenium + Java)

This project automates submitting a project using **Selenium WebDriver**, **Java**, and **JUnit 5**.

The framework follows **Page Object Model (POM)** and avoids fragile locators.



## Tech Stack
This project automates submitting a project using **Selenium WebDriver**, **Java**, and **JUnit 5**.

The framework follows **Page Object Model (POM)** and avoids fragile locators.




- Java (JDK 17+)
- Selenium WebDriver 4.x
- JUnit 5
- Maven
- WebDriverManager
- IntelliJ IDEA


## Project Structure


<pre>
Selenium-Java/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.assignment/
│   │   │       ├── config/
│   │   │       │   ├── Config.java
│   │   │       │   └── DriverFactory.java
│   │   │       ├── core/
│   │   │       │   ├── BasePage.java
│   │   │       │   ├── RandomText.java
│   │   │       │   └── Waits.java
│   │   │       └── pages/
│   │   │           ├── facebook/
│   │   │           │   ├── FBLoginPage.java
│   │   │           │   └── FBPostPage.java
│   │   │           └── wallethub/
│   │   │               ├── WHLoginPage.java
│   │   │               ├── WHProfilePage.java
│   │   │               └── WHReviewPage.java
│   │   ├── resources/
│   │   │   ├── config.properties
│   │   │   └── logback.xml
│   │   └── org.example/
│   │       └── Main.java
│   └── test/
│       └── java/
│           └── com.assignment.tests/
│               ├── BaseTest.java
│               ├── FacebookPostTest.java
│               └── WalletHubReviewTest.java
├── pom.xml
└── README.md
</pre>
---

## Configuration & Credentials

All environment configuration and credentials **must be placed inside**:
`src/test/resources/config.properties`


## Setup

### Java
Verify Java installation:

```bash
java -version

Recommended: Java 17 or newer

⸻

Maven

Verify Maven installation:

mvn -version


⸻

IntelliJ IDEA
	1.	Open IntelliJ IDEA
	2.	Click Open
	3.	Select the project root folder
	4.	Wait for Maven dependencies to load

⸻

Configuration

Update your configuration file with valid values:
	•	WalletHub base URL
	•	WalletHub profile URL
	•	WalletHub email
	•	WalletHub password


⸻

How to Run

Run from IntelliJ
	1.	Open
src/test/java/com.assignment.tests/WalletHubReviewTest.java
	2.	Right-click
	3.	Select Run

⸻

Run from Terminal

mvn clean test


⸻

Test Flow
	1.	Open WalletHub
	2.	Login with valid credentials
	3.	Navigate to profile review section
	4.	Select 4th star rating
	5.	Select Health Insurance
	6.	Enter a random, grammatically correct review (200+ characters)
	7.	Submit the review

⸻

Implementation Notes
	•	SVG star ratings are handled using indexed element selection
	•	No dynamic IDs are used
	•	Explicit waits are used instead of static waits
	•	Browser remains open on failure for debugging

⸻

Best Practices Used
	•	Page Object Model
	•	Explicit waits
	•	Clean locators
	•	Reusable utilities
	•	Maintainable test structure

⸻

Author

Sadiqul Alam
Sr. QA Engineer

---

