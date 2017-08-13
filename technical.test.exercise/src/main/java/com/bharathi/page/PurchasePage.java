package com.bharathi.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PurchasePage {

	private WebDriver driver; 

	@FindBy(css = "input[name='passFirst0']")
	private WebElement firstName;
	
	@FindBy(css = "input[name='passLast0']")
	private WebElement lastName;

	@FindBy(css = "input[name='creditnumber']")
	private WebElement creditCardNumber;
	
	@FindBy(css = "input[name='buyFlights']")
	private WebElement buyFlight;
	
	@FindBy(css = "input[type='checkbox']")
	private List<WebElement>  billingAddress;
	
		public PurchasePage(WebDriver driver)
	{
		this.driver = driver;
	}

		public void fillDetails()
	{
			firstName.sendKeys("Bharathi");
			lastName.sendKeys("Chaluvadi");
			creditCardNumber.sendKeys("1234567890");
			billingAddress.get(0).click();			
	}
		public ConfirmationPage purchaseFlight()
	{
		
			ConfirmationPage confirmation = new ConfirmationPage(driver);
			PageFactory.initElements(driver, confirmation);
			buyFlight.click();
			return confirmation;
	}
}
