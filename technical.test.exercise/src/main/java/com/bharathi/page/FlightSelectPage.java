package com.bharathi.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightSelectPage {

	private WebDriver driver; 

	@FindBy(css = "input[name='reserveFlights']")
	private WebElement continueWithSelection;

	public FlightSelectPage(WebDriver driver) {
		this.driver = driver;
	}

		public PurchasePage continueWithDefaultSelection()
	{
		continueWithSelection.click();
		PurchasePage purchasePage = new PurchasePage(driver);
		//initialize Purchase page
		PageFactory.initElements(driver, purchasePage);
		return purchasePage;
	}
}
