package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.testbase.TestBase;
import com.cleartrip.utilities.Utilities;

public class SignInPage extends TestBase {
	Utilities util;	

	@FindBy(linkText="Your trips")
	private WebElement yourTripsLink;
	
	@FindBy(id="SignIn")
	private WebElement signIn;
	
	@FindBy(id="signInButton")
	private WebElement signInButton;
	
	@FindBy(id="errors1")
	private WebElement errorMessage;
	
	public SignInPage(){
		PageFactory.initElements(driver, this);
		util=new Utilities();
	}
	
	public void clickYourTripsLink() {
		yourTripsLink.click();
	}
	
	public void clickSignIn() {
		signIn.click();
	}
	
	public void clickSignInButton() {
		util.explicitWaitFor(20, signInButton);
		signInButton.click();
	}
	
	public void verifyErrorMessage() {
		String errors1 = errorMessage.getText();
        Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}
}
