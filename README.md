API RestAssured Testing
This project demonstrates API testing using RestAssured in Java with Maven. It includes tests for various CRUD operations and provides instructions on how to execute the tests using Maven and TestNG.
GITHUB Project  Repository URL : https://github.com/akshaykoulgi/Poppulo_API_Project.git 

Prerequisites
●	Java 8 or higher
●	Maven 3.6.0 or higher
●	Git 


Installing Maven
1.	Download Maven:
2.	Go to the Apache Maven download page and download the latest binary zip file.

3.	Extract Maven:
4.	Extract the downloaded zip file to a convenient location on your computer, such as C:\apache-maven-3.8.1.

5. Set Environment Variables:
6. Open the System Properties dialog (Win + Pause), click on Advanced system settings, and then click on Environment Variables.
7.	Under System variables, click New and add MAVEN_HOME with the path to your Maven directory (e.g., C:\apache-maven-3.8.1).
8.	Find the Path variable, click Edit, and add %MAVEN_HOME%\bin.
9.	Click OK to save changes.

	Verify Installation:
Open a new command prompt and run:
mvn -version

Make sure Git and Java is also installed. 

Project Setup 

Go the the location where you would like to Clone the Repository
1.	Clone the Repository:
git clone https://github.com/akshaykoulgi/Poppulo_API_Project.git 

Change to the Cloned Repository Directory:
cd your-repo-location

Install Dependencies:
mvn clean install

This will install all the dependencies mentioned in pom.xml file 

Running Tests with Maven
To execute the API tests using Maven, run the following command:
mvn test

This will compile the test classes and execute all the tests defined in the src/test/java directory.
OR
Running Tests Manually with TestNG

Once after cloning the Repository and Importing the Project into your IDE

Installing TestNG in Your IDE
For a better development experience, it’s recommended to install TestNG in your IDE. Here’s how to do it:
In IntelliJ IDEA:
1.	Go to File > Settings > Plugins.
2.	Search for TestNG.
3.	Click Install.
4.	Restart IntelliJ IDEA if prompted.
In Eclipse:
1.	Go to Help > Eclipse Marketplace.
2.	Search for TestNG.
3.	Click Go and then Install.
4.	Follow the installation prompts.

To run the tests manually using TestNG:
1.	Open your IDE: Open your preferred IDE (e.g., IntelliJ IDEA, Eclipse) and import the Maven project.
2.	Locate Test Classes: Navigate to the src/test/java directory and locate the test classes.
3.	Run Tests: Right-click on the test class file and select Run or Run As > TestNG Test. This will execute the tests in the selected class.


Project Structure
 

Contact
For any questions or issues, please contact akshay.koulgi@gmail.com
Mobile : 9686639940 

