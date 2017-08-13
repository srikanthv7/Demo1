package com.bharathi.page;

import java.util.List;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.bharathi.browser.Browser;
import com.bharathi.browser.BrowserFactory;

public class ReservationPage {

	private static final String PAGE_URL = "http://newtours.demoaut.com/mercurywelcome.php";

	private WebDriver driver; 

	@FindBy(css ="input[value='oneway']")
	private WebElement tripType;
	
	@FindBy(css ="select[name='fromPort']")
	private WebElement selectTripFrom;

	@FindBy(css ="select[name='toPort']")
	private WebElement selectTo;
		
	@FindBy(css = "input[type='radio']:nth-child(4)")
	private WebElement serviceClass ;
	
	@FindBy(css ="input[type='image']")
	private WebElement continueButton ;
	
	public ReservationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void nagivate() {
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}

	public String getPageUrl() {
		return PAGE_URL;
	}

	public FlightSelectPage selectReservation() throws InterruptedException {
		tripType.click();
		Browser.selectDropDown(selectTripFrom, "Sydney");
		//BrowserFactory.getInstance().getBrowser().selectDropDown(selectTo, "London");
		Browser.selectDropDown(selectTo, "London");
			
		serviceClass.click();
		continueButton.click();
		FlightSelectPage flightSelectionPage = new FlightSelectPage(driver);
		PageFactory.initElements(driver,flightSelectionPage);
		return flightSelectionPage;
	}
	
	
	
}
