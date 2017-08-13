package com.bharathi.browser.desktop;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import com.bharathi.browser.Browser;
import com.bharathi.browser.BrowserFactory.BrowserType;

public class DesktopBrowser extends Browser {

	public DesktopBrowser(BrowserType browserType) {
		super(browserType);

		try {
			intializeDriver();
		} catch (Exception e) {
			e.printStackTrace();
		}

		actions = new Actions(driver);
	}

	private void intializeDriver() throws Exception {
		System.out.println("Browser type: " + getBrowserType());
		switch (getBrowserType()) {
			case CHROME:
				setChromeDriver();
				driver = new ChromeDriver();
				break;
	
			case SAFARI:
				System.setProperty("webdriver.safari.noinstall", "true");
				driver = new SafariDriver();
				break;

			case FIREFOX:
				driver = new FirefoxDriver();
				break;

			case IE:
				System.setProperty("webdriver.ie.driver","src/test/java/IEDriverServer.exe");
	            driver = new InternetExplorerDriver();
				break;

			default:
				break;
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	private void setChromeDriver() {
		String os = System.getProperty("os.name");
		if (os.contains("Mac OS")) {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chrome/driver/mac/chromedriver");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/main/java/chrome/driver/windows/chromedriver.exe");
		}
	}

	@Override
	public void doClick(WebElement element) {
		if (BrowserType.CHROME == getBrowserType()) {
			actions.click(element).build().perform();
		} else {
			super.doClick(element);
		}
	}

	@Override
	public String getElementText(WebElement element) {
		if (BrowserType.FIREFOX == getBrowserType()) {
			return element.getAttribute("textContent").trim();
		}

		return super.getElementText(element);
	}

	@Override
	public boolean isDisplayed(WebElement element) {
		if (BrowserType.SAFARI == getBrowserType()) {
			return element.getCssValue("visibility").equals("visible");
		}

		return super.isDisplayed(element);
	}
}
