package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.testbase.TestBase;
import com.cleartrip.utilities.Utilities;

public class FlightSearchSummaryPage extends TestBase{
	Utilities utils;
	FlightSearchPage searchPage;
	
	@FindBy(xpath="//*[@class='searchSummary']")
	private WebElement searchSummaryTitle;
	
	
	public FlightSearchSummaryPage() {
		PageFactory.initElements(driver, this);
		utils=new Utilities();
	}
	
	public void verifySearchSummaryPage() {
		searchPage=new FlightSearchPage();
		String fromCityName=System.getProperty("fromCityName");
		String toCityName=System.getProperty("toCityName");
		Assert.assertTrue(utils.isElementPresent(searchSummaryTitle));
		Assert.assertTrue(searchSummaryTitle.getText().contains(fromCityName) && searchSummaryTitle.getText().contains(toCityName)); 
	}
}
