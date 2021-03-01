package com.mytest.testpackage;

import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.mytest.config.ConfigClass;
import com.mytest.implementation.TestImplementations;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author raj
 * This test Creates pc id and completes user profile
 * Browser name is defined in src/config.properties file
 * this test can be run as junit test
 */
public class UIAutomationTask extends ConfigClass {
	WebDriver driver;
	TestImplementations smt;
	
	@Before
	public void beforeTest() {
		setReportPath();
		test = extent.startTest(getClass().getName()).assignCategory(readProperty("Browser1"));
		driver = getDriver(readProperty("Browser1"));
		driver.get(readProperty("url"));
		System.out.println("Navigated to url: " + readProperty("url"));
	}

	@Test
	public void completeUserProfile() throws Throwable {
		try {
			smt = new TestImplementations(driver);
			smt.completeUserProfile();
			test.log(LogStatus.PASS, "Complete User Profile test passed");
		} catch (Throwable e) {
			test.log(LogStatus.FAIL, "Complete User Profile test failed");
			throw new Exception(e);
		}
	}	

	@After
	public void afterTest() {
		endReport();
		if(initialized){
			driver.quit();
			initialized = false;
		}
	}

}
