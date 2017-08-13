package com.bharathi.page;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

	
	private WebDriver driver; 

	@FindBy(css = "tr:nth-child(3) font:nth-child(2)")
	private WebElement successmessage;
	

	public ConfirmationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void validateSuccess()
	{ 
		String successmess = successmessage.getAttribute("innerHTML");
		System.out.println("You are in Cofirmation page");
		Assert.assertEquals("Your are on Flight Confirmation page",successmess.contains("itinerary has been booked!"),true);
	}
}
