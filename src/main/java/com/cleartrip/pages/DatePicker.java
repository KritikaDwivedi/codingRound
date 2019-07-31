package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cleartrip.testbase.TestBase;
import com.cleartrip.utilities.Utilities;

public class DatePicker extends TestBase{
	Utilities util;
	
	@FindBy(xpath="//*[text()='%s']//following-sibling::span[text()='%s']//ancestor::div[@class='header']//following-sibling::table[@class='calendar']//tbody//a[text()='%s']")
	private WebElement date;

	@FindBy(xpath="//*[contains(@class,'nextMonth')]")
	private WebElement nextMonthButton;
	
	public DatePicker() {
		PageFactory.initElements(driver, this);
		util=new Utilities();
	}
	
	public void selectDate(String dateToBeSelected) {
		
		String dateArray[]=dateToBeSelected.replace(",", "").split(" ");
		String dateArray2[]=new String[dateArray.length];
		dateArray2[0]=dateArray[1];
		dateArray2[1]=dateArray[2];
		dateArray2[2]=dateArray[0];
		WebElement dateExpected=util.getDynamicElementLocator(date,dateArray2);
		while(true) {
			if(dateExpected.isDisplayed())
			{
				dateExpected.click();
				break;
			}
			else {
				nextMonthButton.click();
			}
		}
	}
	
	
}
