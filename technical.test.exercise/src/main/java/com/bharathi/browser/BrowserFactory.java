package com.bharathi.browser;

import java.util.HashMap;
import java.util.Map;

import com.bharathi.browser.desktop.DesktopBrowser;

public class BrowserFactory {

	private Map<BrowserType, Browser> browsers = new HashMap<BrowserType, Browser>();
	private Browser currentBrowser;

	private static BrowserFactory browserFactory = null;

	private BrowserFactory() {}

//Creates Singleton instance of browser factory
	public static BrowserFactory getInstance() {

		if (null == browserFactory) {
			browserFactory = new BrowserFactory();
		}

		return browserFactory;
	}

	public Browser getBrowser() {
		return getBrowser("FIREFOX");
	}
	
	public Browser getBrowser(String browserType) {
		System.out.println("BrowserType: " + browserType);
		
		BrowserType browserTypeEnum = BrowserType.FIREFOX;
		
		if (null != browserType) {
			try {
				browserTypeEnum = BrowserType.valueOf(browserType.trim().toUpperCase());
			} catch (IllegalArgumentException e) {
				throw new IllegalArgumentException("Browser '" + browserType + "' is not supported.");
			}
		}
		
		currentBrowser = getBrowser(browserTypeEnum);
		
		return currentBrowser;
	}

	public Browser getCurrentBrowser() {
		return currentBrowser;
	}
	
	
	public Browser getBrowser(BrowserType browserType) {

		if (currentBrowser != null && currentBrowser.getDriver() != null) {
			System.out.println("Returning existing " + browserType + " browser!");
			return currentBrowser;
		}

		System.out.println("Create " + browserType + " browser.");

		System.out.println("Using desktop browser.");
		return new DesktopBrowser(browserType);
	}

	public void registerBrowser(BrowserType browserType, Browser browser) {
		if ((null == browserType) || (null == browser) ) {
			throw new NullPointerException("Browser type or browser cannot be null");
		}

		browsers.put(browserType, browser);
	}
	
	public static enum BrowserType {
		CHROME, SAFARI, FIREFOX, IE
	}
}
