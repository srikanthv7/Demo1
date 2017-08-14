package com.bharathi.test;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.bharathi.browser.Browser;
import com.bharathi.browser.BrowserFactory;
import com.bharathi.page.LoginPage;
import com.bharathi.page.PurchasePage;
import com.bharathi.page.ConfirmationPage;
import com.bharathi.page.FlightSelectPage;
import com.bharathi.page.ReservationPage;

@RunWith(JUnit4.class)
public class MercureTourTripTest {

	@BeforeClass
	public static void setUp() {
		BrowserFactory.getInstance().getBrowser("CHROME");
		System.out.println("hello srikanth");
	}

	@AfterClass
	public static void tearDown() {
		BrowserFactory.getInstance().getCurrentBrowser().close();
	}

	@Test
	public void mercuryTourTest() throws InterruptedException {

		Browser browser = BrowserFactory.getInstance().getCurrentBrowser();
		LoginPage loginpage = new LoginPage(browser.getDriver());
		loginpage.nagivate();

		ReservationPage reservationPage = loginpage.login();
		FlightSelectPage flightSelectionPage = reservationPage.selectReservation();

		PurchasePage purchasePage = new PurchasePage(browser.getDriver());
		
		purchasePage = flightSelectionPage.continueWithDefaultSelection();
		purchasePage.fillDetails();
		
		ConfirmationPage confirmation= purchasePage.purchaseFlight();
		confirmation.validateSuccess();
		
	}
}
