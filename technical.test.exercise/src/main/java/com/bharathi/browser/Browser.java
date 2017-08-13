package com.bharathi.browser;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bharathi.browser.BrowserFactory.BrowserType;

public abstract class Browser {

	protected DesiredCapabilities capabilities = new DesiredCapabilities();
	protected WebDriver driver;
	protected Actions actions;
	protected BrowserType browserType;

	public Browser(BrowserType browserType) {
		this.browserType = browserType;
	}

	public DesiredCapabilities getDefaultCapabilities() {
		return capabilities;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public static void selectDropDown(WebElement element ,String value)
	{
		Select dropDown = new  Select(element);
		dropDown.selectByValue(value);
	}
	public void doClick(WebElement element) {
		element.click();
	}

	public String getElementText(WebElement element) {
		return element.getAttribute("innerText").trim();
	}

	public boolean isDisplayed(WebElement element) {
		return element.isDisplayed();
	}

	public void waitUntilVisible(WebElement webElement) {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(webElement));
	}

	public void navigateBack() {
		((JavascriptExecutor) driver).executeScript("history.go(-1)");
	}

	public void doWait(long sleepTimeInMillis) {
		try {
			Thread.sleep(sleepTimeInMillis);
		} catch (InterruptedException e) {
		}
	}

	public BrowserType getBrowserType() {
		return browserType;
	}

	public Actions getActions() {
		return actions;
	}

	public void waits(WebElement element)
	{	
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waits(List<WebElement> elements)
	{
		(new WebDriverWait(driver, 30)).until(ExpectedConditions .visibilityOfAllElements(elements));
	}
	
	public void waits(By by)
	{
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public void waitUntilVisible(By by)
	{
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void close() {
		if (driver != null) {
			driver.close();
			driver.quit();
			driver = null;
		}
	}
}
