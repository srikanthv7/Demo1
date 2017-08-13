package com.bharathi.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	private static final String PAGE_URL = "http://newtours.demoaut.com/mercurywelcome.php";

	private WebDriver driver; 

	@FindBy(css = "input[name='userName']")
	private WebElement userName;
	@FindBy(css = "input[name='password']")
	private WebElement password;
	@FindBy(css = "input[name='login']")
	private WebElement login;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void nagivate() {
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}
	public ReservationPage login()
	{
		userName.sendKeys("mercury");
		password.sendKeys("mercury");
		login.click();
		ReservationPage reservationPage = new ReservationPage(driver);
		PageFactory.initElements(driver, reservationPage);
		return reservationPage;
			
	}
}
