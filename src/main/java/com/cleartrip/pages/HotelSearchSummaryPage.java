package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.testbase.TestBase;
import com.cleartrip.utilities.Utilities;

public class HotelSearchSummaryPage extends TestBase {

	Utilities utils;
	HotelSearchPage searchPage;
	
	@FindBy(xpath="//*[@class='searchSummary']")
	private WebElement searchSummaryTitle;
	
	
	public HotelSearchSummaryPage() {
		PageFactory.initElements(driver, this);
		utils=new Utilities();	
	}
	
	public void verifyHotelSearchResultPage() {
		
		utils.explicitWaitFor(20, searchSummaryTitle);
		searchPage=new HotelSearchPage();
		String searchLocalityTerm=System.getProperty("searchTerm");
		Assert.assertTrue(searchLocalityTerm.toLowerCase().contains(searchSummaryTitle.getText().toLowerCase().substring(0, searchSummaryTitle.getText().indexOf(" "))) || searchLocalityTerm.toLowerCase().contains(searchSummaryTitle.getText().toLowerCase())); 
	}
	
}
