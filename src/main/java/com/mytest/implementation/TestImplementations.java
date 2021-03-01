package com.mytest.implementation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.mytest.config.ConfigClass;
import com.mytest.pages.LoblawsHomePage;
import com.relevantcodes.extentreports.LogStatus;

/**
 * @author rajani
 * This class has java code for all scripts, extending configclass for driver, properties and report configurations
 *
 */
public class TestImplementations extends ConfigClass {
	WebDriver driver;
	
	public TestImplementations(WebDriver driver){
		this.driver = driver;
		driver = getDriver(readProperty("Browser"));
	}	
	
	public void completeUserProfile() throws Throwable {
		LoblawsHomePage lhp = new LoblawsHomePage(driver);		
		lhp.createUserProfile();
	}	
}
