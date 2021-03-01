# Automation-POC-Project

Framework Configurations:

Project:  Selenium, Java and Junit Framework
Design:   Page Object pattern
Dependency management:  Maven(POM)
Reports: Extent reports(Reports are generated for each execution and stores in test-report folder)
Driver utility: WebDriverManager utility
DataProvider:  Data properties file

Project Structure:

1. com.mytest.config package :
	Defined all required configurations for the project,
	Ex: Webdriver access, Report generation, and Load properties from property file
	
2. com.mytest.driver package:
	Web drivers(Chrome,Firefox and IE) utility class - using web driver manager dependency to create drivers
	
3. com.mytest.implementation:
	Java code for Smoke test automation scripts
	
4. com.mytest.pages:(Page object model)
	Developed Base page with all possible selenium commands with explicit wait conditions. Every page should inherit this 	page as this is the wrapper class for all selenium commands.
	All pages will be implemented in this package using page object model pattern -  page objects and access methods 
	
5. 	com.mytest.testpackage:
	Test scripts were developed using junit. Passing data using data provider properties file
	
6.  Config.Properties file -(src/config.properties)
	Defined required properties for test scripts. Ex: url, browser, timeout..
	Loading these properties in ConfigClass under config package

7.  Reports: 
	Test Reports are saved under test-report folder. Using Extent reports dependency to generate dashboard reports
	Configurations are developed in ConfigClass
	
Test Execution:

To run the test using junit:
1. Right click on the testpackage script and Run as junit test (individual script execution)
 	

Test Package:
1. APITaskGet.java
2. APITaskPost.java
3.UIAutomationTask.java

 

 	
 	  	

	
	
			
			
		


 

