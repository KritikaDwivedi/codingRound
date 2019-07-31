package com.cleartrip.tests;
import org.testng.annotations.Test;

import com.cleartrip.pages.DatePicker;
import com.cleartrip.pages.HotelSearchPage;
import com.cleartrip.pages.HotelSearchSummaryPage;
import com.cleartrip.testbase.TestBase;

public class HotelBookingTest extends TestBase{
	
	HotelSearchPage hotelSearchPage;
	DatePicker datePicker;
	TestBase testBase;
	HotelSearchSummaryPage hotelSearchSummaryPage;
	
    @Test(description="Validate search hotel functionality is working fine")
    public void shouldBeAbleToSearchForHotels() {
    	
    	testBase = new TestBase();
    	hotelSearchPage=new HotelSearchPage();
    	datePicker=new DatePicker();
    	hotelSearchSummaryPage=new HotelSearchSummaryPage();
    	
    	//Open site
    	testBase.openSite();
    	//Click hotels link
    	hotelSearchPage.clickHotelLink();
    	//Select locality
        hotelSearchPage.selectLocality("Indiranagar, Bangalore");
        //Select check-in date
        hotelSearchPage.clickCheckInCalendarIcon();
        datePicker.selectDate("30 August, 2019");
        //Select check-out date
        hotelSearchPage.clickCheckOutCalendarIcon();
        datePicker.selectDate("31 August, 2019");
        //Select travelers option
        hotelSearchPage.selectTravelersOption("1 room, 2 adults");
        //Click search hotel button
        hotelSearchPage.clickSearchHotelButton();
        //Verify the search results are correct
        hotelSearchSummaryPage.verifyHotelSearchResultPage();

    }

}
