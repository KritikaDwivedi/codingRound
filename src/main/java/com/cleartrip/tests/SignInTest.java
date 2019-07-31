package com.cleartrip.tests;
import org.testng.annotations.Test;

import com.cleartrip.pages.SignInPage;
import com.cleartrip.testbase.TestBase;

public class SignInTest extends TestBase{
	
	TestBase testBase;
	SignInPage signInPage;
	
    @Test(description="Validate the error message for blank credentials")
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

    	testBase = new TestBase();
    	signInPage=new SignInPage(); 
    	
    	//Open site
		testBase.openSite();
		//Click Your trips link
		signInPage.clickYourTripsLink();
		//Click Sign in link
		signInPage.clickSignIn();
		//Switch to iFrame
		driver.switchTo().frame("modal_window");
		//Click Sign in button
		signInPage.clickSignInButton();
		//Verify error messages
		signInPage.verifyErrorMessage();

    }
}
