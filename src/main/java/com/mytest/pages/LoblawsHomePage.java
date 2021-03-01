package com.mytest.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mytest.config.ConfigClass;
import com.mytest.config.DataClass;

/**
 * @author rajani
 * This is the page class for Loblaws application
 * All objects and methods are specified.
 * Extending Base page. all Explicit waits are defined in base page
 * Data is passing from data properties file
 */
@SuppressWarnings("serial")
public class LoblawsHomePage extends BasePage{
	int timeout;
	public LoblawsHomePage(WebDriver driver) {
		super(driver);
		timeout = Integer.parseInt(new ConfigClass().readProperty("timeout"));
	}
	
	private By myShopTab = By.xpath("//a//span[contains(text(), 'My Shop')]");
	private By greenSignIn = By.xpath("(//a//span[text()='Sign In'])[2]");
	private By createApcID = By.xpath("(//a[contains(@href,'create-account')]//span)[1]");
	private By email = By.xpath("//input[@id='email']");
	private By password = By.xpath("//input[@id='newPassword']");
	private By termsChkBx = By.xpath("//input[@id='termsAndConditions']//parent::div");
	private By submitBtn = By.xpath("//button[contains(@class,'submit')]");	
	private By title = By.xpath("//h2[contains(text(),'Complete Your Profile')]");		
	
	public void createUserProfile() throws Throwable {
		
		driver.switchTo().activeElement();
		Thread.sleep(10000);
		driver.findElement(myShopTab).click();
		Thread.sleep(2000);
		WebElement e = driver.findElement(By.xpath("//*[contains(@href,'lists')]"));
		JavascriptExecutor jsx = (JavascriptExecutor)driver;
		jsx.executeScript("window.scrollTo("+e.getLocation().getX()+"," +(e.getLocation().getY()-1/2)+");");
		getElementAndClick(greenSignIn, 40);
		getElementAndClick(createApcID, timeout);
		DataClass dc = new DataClass();
		Thread.sleep(5000);
		//getElementAndEnter(email, timeout, dc.readProperty("email"));
		driver.findElement(email).sendKeys(dc.readProperty("email"));
		driver.findElement(email).click();	
		System.out.println("Entered email: "+email);
		Thread.sleep(5000);
		getElementAndEnter(password, timeout, dc.readProperty("password"));
		driver.findElement(email).click();
		System.out.println("Entered password: "+password);
		Thread.sleep(3000);
		getElementAndClick(termsChkBx, timeout);
		Thread.sleep(10000);
		driver.findElement(email).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(3000);
		WebElement tmpElement = driver.findElement(submitBtn);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", tmpElement);
		//driver.findElement(submitBtn).click();
		Thread.sleep(10000);
		WebElement element = getElementWhenVisible(title, 20);
		if(element.isDisplayed()) {
			System.out.println("Title - Complete Your Profile is displayed ");
		} else {
			System.out.println("Complete your Profile is not displayed, unexpected error occured ");
			throw new Exception("Complete your Profile is not displayed, unexpected error occured");
		}		
	}
	
}
