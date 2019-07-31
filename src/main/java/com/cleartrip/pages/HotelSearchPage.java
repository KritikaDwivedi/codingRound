package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.cleartrip.testbase.TestBase;
import com.cleartrip.utilities.Utilities;

public class HotelSearchPage extends TestBase {
	Utilities util;	
	public String searchTerm;
		
	@FindBy(linkText = "Hotels")
    private WebElement hotelLink;
	
	@FindBy(xpath="(//*[@class='calendarIcon datePicker'])[1]")
	private WebElement checkInCalendarIcon;
	
	@FindBy(xpath="(//*[@class='calendarIcon datePicker'])[2]")
	private WebElement checkOutCalendarIcon;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    @FindBy(xpath="//*[@id='ui-id-1']//li")
	private List<WebElement> localityDropdown;
    
    public HotelSearchPage(){
    	PageFactory.initElements(driver, this);
    	util=new Utilities();
    }
    
    public void clickHotelLink() {
    	hotelLink.click();
    }
    
    public void selectLocality(String locality) {
    	localityTextBox.clear();
    	localityTextBox.sendKeys(locality);
    	 System.setProperty("searchTerm",locality);
    	 util.waitFor(10000);	
    	 //util.explicitWaitFor(10, localityDropdown.get(0));
    	 System.out.println(localityDropdown.get(1).getText());
    	 localityDropdown.get(1).click();
    }
    
    public void clickCheckInCalendarIcon() {
    	checkInCalendarIcon.click();
    }
    
    public void clickCheckOutCalendarIcon() {
    	checkOutCalendarIcon.click();
    }
    
    public Select getSelectOptions() {
        return new Select(travellerSelection);
      }
    
    public void selectTravelersOption(String option)
    {
      getSelectOptions().selectByVisibleText(option);;
    }
    
    public void clickSearchHotelButton() {
    	util.explicitWaitFor(10, searchButton);
    	searchButton.click();
    }
    
   
}
