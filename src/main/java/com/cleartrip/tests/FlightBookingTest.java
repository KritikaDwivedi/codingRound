package com.cleartrip.tests;
import org.testng.annotations.Test;

import com.cleartrip.pages.DatePicker;
import com.cleartrip.pages.FlightSearchPage;
import com.cleartrip.pages.FlightSearchSummaryPage;
import com.cleartrip.testbase.TestBase;

public class FlightBookingTest extends TestBase{

	TestBase testBase;
	FlightSearchPage searchPage;
	FlightSearchSummaryPage searchSummaryPage;
	DatePicker datePicker;

	@Test(description="Validate the results are valid for one way journey")
	public void testThatResultsAppearForAOneWayJourney() throws Exception {

		testBase = new TestBase();
		searchPage=new FlightSearchPage();
		datePicker=new DatePicker();
		searchSummaryPage=new FlightSearchSummaryPage();
		
		//Open site
		testBase.openSite();
		//Select one way radio button
		searchPage.selectOneWayRadioButton();
		//Select From Tag
		searchPage.selectCityInFromTag("Bangalore"); 
		//Select To Tag
		searchPage.selectCityInToTag("Delhi"); 
		//Select Date
		datePicker.selectDate("30 August, 2019");
		//Click search button
		searchPage.clickSearchButton();
		//verify that result appears for the provided journey search
		searchSummaryPage.verifySearchSummaryPage();

	}

}
