package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.testbase.TestBase;
import com.cleartrip.utilities.Utilities;

public class FlightSearchPage extends TestBase {

	Utilities util;	

	@FindBy(id="OneWay")
	private WebElement oneWayRadioButton;

	@FindBy(id="FromTag")
	private WebElement fromTag;

	@FindBy(xpath="//*[@id='ui-id-1']//li")
	private List<WebElement> fromTagDropdown;

	@FindBy(id="ToTag")
	private WebElement toTag;

	@FindBy(xpath="//*[@id='ui-id-2']//li")
	private List<WebElement> toTagDropdown;

	@FindBy(id="SearchBtn")
	private WebElement searchButton;

	@FindBy(xpath="//*[@class='clearFieldAuto icon close fRight']")
	private WebElement loader;

	public FlightSearchPage(){
		PageFactory.initElements(driver, this);
		util=new Utilities();
	}

	public void selectOneWayRadioButton() {
		oneWayRadioButton.click();
	}


	public void selectCityInFromTag(String cityName) {
		fromTag.clear();
		fromTag.sendKeys(cityName);
		util.waitFor(5000);	
		try {
		fromTagDropdown.get(0).click();
		}
		catch(Exception e) {
			
		}
		System.setProperty("fromCityName", cityName);
	}

	public void selectCityInToTag(String cityName) {
		toTag.clear();
		toTag.sendKeys(cityName);
		util.waitFor(5000);
		try {
		toTagDropdown.get(0).click();
		}
		catch(Exception e) {
			
		}
		System.setProperty("toCityName", cityName);
	}

	public void clickSearchButton() {
		util.explicitWaitFor(10, searchButton);
		searchButton.click();
	}

}
