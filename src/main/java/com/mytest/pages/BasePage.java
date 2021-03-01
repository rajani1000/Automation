package com.mytest.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author raj
 * This is the base page for all pages
 * All selenium possible methods with explicit wait conditions are defined here *  
 * Every page class should inherit this class 
 *
 */
public class BasePage extends Exception {
	
	WebDriver driver; BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void getElementAndClick(By locator, int timeout)throws Throwable {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void getElementAndEnter(By locator,int timeout, String text) throws Throwable {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);
	}	
	
	public WebElement getElementWhenVisible(By locator,int timeout) throws Throwable {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public List<WebElement> getElementsWhenVisible(By locator, int timeout) throws Throwable {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public WebElement getElementWhenPresent(By locator, int timeout)throws Throwable {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean isTextVisible(By locator, int timeout, String text)throws Throwable {
		return new WebDriverWait(driver, timeout).until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
	}
	
	public void scrollDown() {
		Actions actions  = new Actions(driver);
		actions.keyDown(Keys.PAGE_DOWN).perform();		
	}

}
