package com.cleartrip.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cleartrip.testbase.TestBase;

public class Utilities extends TestBase {

	//Method for explicit wait
	public void explicitWaitFor(int durationInSeconds, WebElement el) {
		try {
			WebDriverWait wait=new WebDriverWait(driver, durationInSeconds);
			wait.until(ExpectedConditions.visibilityOf(el));
		} catch (Exception e) {
			e.printStackTrace();  
		}
	}
	
	//Method for static wait
	public void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (Exception e) {
			e.printStackTrace(); 
		}
	}

	//Method to verify if WebElement is present
	public boolean isElementPresent(WebElement ele) {
		try {
			ele.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	//Method to get the dynamic locator
	public WebElement getDynamicElementLocator(WebElement ele, String[] arr) {
		String locator=ele.toString().substring(ele.toString().indexOf("/"), ele.toString().lastIndexOf("'"));
		WebElement element = null;
		int noOfString=arr.length;
		String locatorString = null;
		switch(noOfString) {
		case 1:locatorString=String.format(locator, arr[0]);
		break;
		case 2:locatorString=String.format(locator, arr[0],arr[1]);
		break;
		case 3:locatorString=String.format(locator, arr[0],arr[1],arr[2]);
		break;
		}
		if(ele.toString().contains("xpath")) 
			element= driver.findElement(By.xpath(locatorString));
		else if(ele.toString().contains("css"))
			element= driver.findElement(By.cssSelector(locatorString));
		return element;

	}

}
