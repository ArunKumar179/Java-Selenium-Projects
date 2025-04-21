The project appears to be an automation testing script for the Myntra e-commerce website using Selenium WebDriver with TestNG. The tests performed include verifying the logo, searching and adding products, performing login validation, and searching for products in the Studio section of the website.

Key Features
Launch Application: The test suite opens the Myntra website in Incognito Mode using the Chrome browser.

Logo Validation: It verifies the visibility of the Myntra logo on the homepage.

Search and Add Functionality: The script performs a search for products (like "Shirts"), clicks on brand filters, and selects a product to view details like its name and price.

Login Validation: It performs a login functionality test by entering different phone numbers from the DataProvider and checks for an invalid login message.

Studio Search Functionality: The script interacts with the "Studio" section of Myntra, performs a search for products from the provided list, and validates the display of products.

Prerequisites
Java 8 or higher.

Selenium WebDriver (for browser automation).

TestNG (for running test cases).

ChromeDriver (make sure the correct version is installed to match your Chrome version).

Maven (if dependencies are managed via Maven, otherwise ensure all necessary jars are included in the project).

Technologies Used
Selenium WebDriver: For browser automation.

TestNG: For structuring and running tests.

Java: Programming language used for test script development.

ChromeDriver: To interact with the Google Chrome browser.

Actions Class: For simulating complex user interactions like hovering and clicking.

WebDriverWait: For waiting until certain conditions are met before interacting with elements.

JavascriptExecutor: For executing JavaScript directly in the browser (for actions like scrolling).

How to Set Up
Clone the Repository: Download or clone the repository to your local machine.

bash
Copy
Edit
git clone <repository-url>
Install Dependencies: If using Maven, make sure to add the necessary dependencies (Selenium, TestNG) in your pom.xml. If you're managing dependencies manually, download the relevant JAR files.

Download ChromeDriver: Ensure that the version of ChromeDriver matches your installed Chrome browser. You can download it from the official site: ChromeDriver Download.

Set up Environment: Make sure the ChromeDriver is in your system’s PATH or update the path in the script.

Running the Tests
To run the tests, use TestNG. If you are using Maven, you can run it through the following command:

bash
Copy
Edit
mvn test
Alternatively, you can run the tests from your IDE by selecting the Main class and executing the tests as TestNG tests.

Test Methods
logo():

Verifies if the Myntra logo is displayed on the homepage.

testCase1():

Searches for the keyword "Shirts".

Applies filters for brands and selects a product to view.

Prints the product name, price, and other details.

login(String phno):

Attempts login using different phone numbers from the DataProvider.

Checks if the invalid login error message is displayed.

studioTest(String data):

Navigates to the Studio section and performs a product search using different brands.

Validates if products matching the search criteria are displayed.

Test Data Providers
loginData: Provides different phone numbers for testing login functionality.

dp: Provides a list of brands ("Puma", "nike", "Woodland") to be searched in the Studio section.

Known Issues
The script uses a hardcoded XPath for locating elements, which may break if the website's DOM structure changes.

There are some hardcoded wait times (Thread.sleep()), which could be improved using dynamic waits for better stability.

The script doesn't always quit the driver after tests (d.quit() is commented out), which might leave Chrome instances running.

Future Enhancements
Add proper exception handling for better robustness.

Replace Thread.sleep() with more stable WebDriverWait conditions to wait for elements to be interactable.

Clean up the code by removing hardcoded XPath values and use more robust element locators like CSS Selectors or ID.

Add functionality for more tests, such as checking for specific items in the cart or verifying the checkout process.

Example README File Structure
markdown
Copy
Edit
# Myntra Automation Testing Suite

## Overview
This project contains automation test scripts for the Myntra e-commerce website using **Selenium WebDriver** and **TestNG**.

## Features
- **Logo Validation**
- **Search and Add Functionality**
- **Login Validation**
- **Studio Search Functionality**

## Prerequisites
- Java 8 or higher
- Selenium WebDriver
- TestNG
- ChromeDriver

## How to Set Up
1. Clone the repository:
   ```bash
   git clone <repository-url>
Install the necessary dependencies via Maven or download required JARs.

Download ChromeDriver and ensure it matches the version of your Chrome browser.

Set up the environment and ensure ChromeDriver is in your PATH.

Running the Tests
To run the tests, execute:

bash
Copy
Edit
mvn test
Or run directly through your IDE.

Test Methods
logo(): Verifies the Myntra logo.

testCase1(): Performs product search and selection.

login(): Tests invalid login with different phone numbers.

studioTest(): Searches products in the Studio section.

Data Providers
loginData: Provides phone numbers for login testing.

dp: Provides brand names for Studio search.

Known Issues
Hardcoded XPath might break if website structure changes.

Some tests may fail due to hardcoded wait times.

Future Enhancements
Improve element locators.

Replace Thread.sleep() with dynamic waits.

Add more tests for cart and checkout functionality.
