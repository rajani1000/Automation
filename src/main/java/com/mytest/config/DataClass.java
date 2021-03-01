package com.mytest.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;

import com.mytest.driver.BrowserDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DataClass {

	protected static WebDriver wdriver;
	protected static boolean initialized = false;
	public static ExtentReports extent;
	public static ExtentTest test;
	Properties p = new Properties();

	public DataClass() {
		loadDataProperties();
	}

	public void loadDataProperties() {
		try {
			p.load(new FileInputStream("src/data.properties"));

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}	

	public Set getProperties() {
		return p.entrySet();
	}

	public String readProperty(String key) {
		return p.getProperty(key);
	}
	
	protected WebDriver getDriver(String str) {
		if (!(initialized)) {
			wdriver = BrowserDriver.createDriver(str);
			initialized = true;
		}
		return wdriver;
	}

	public WebDriver getDriver() {
		return wdriver;
	}
	
	public void setReportPath() {
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-report/SmokeTest-Report.html",false);
	}
	
	public void endReport() {
		/*if(result == "failed") {
			test.log(LogStatus.FAIL, "TEST FAILED");
		}else if(result == "passed"){
			test.log(LogStatus.PASS, "TEST PASSED");
		}*/
		
		extent.endTest(test);
		extent.flush();
	}
		
}
