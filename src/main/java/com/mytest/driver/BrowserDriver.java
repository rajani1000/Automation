package com.mytest.driver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class BrowserDriver {
	
	public static WebDriver createDriver(String browserName){
		if(browserName.toUpperCase().equals("FIREFOX")){
			return firefoxDriver();
		}
		
		if(browserName.toUpperCase().equals("CHROME")){
			return chromeDriver();
		}
		
		if(browserName.toUpperCase().equals("IE")){
			return ieDriver();
		}
		throw new RuntimeException("Invalid browser name");
	}
	
	public static WebDriver ieDriver() {
		WebDriverManager.iedriver().setup();
		InternetExplorerOptions options = new InternetExplorerOptions();
		options.withInitialBrowserUrl("http://www.google.ca");
		return new InternetExplorerDriver(options);	
	}

	public static WebDriver chromeDriver() {
		WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("disable-infobars");
		options.addArguments("--disable-extensions");
		options.addArguments("log-level=OFF");
		return new ChromeDriver(options);
		
	}
	
	public static WebDriver firefoxDriver() {
		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		return driver;		
	}


}
