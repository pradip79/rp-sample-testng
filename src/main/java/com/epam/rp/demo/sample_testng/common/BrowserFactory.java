package com.epam.rp.demo.sample_testng.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserFactory {
	static final Logger logger = LogManager.getLogger(BrowserFactory.class);
	
	public static WebDriver createInstance(String browserTypeStr) {
		WebDriver driver = null;			
		boolean enableVNC = false;
		
		String gridHubURL = System.getProperty("gridHubURL");
		enableVNC = Boolean.parseBoolean(System.getProperty("enableVNC"));		
		
		BrowserType browserType = BrowserType.valueOf(browserTypeStr);
		
		switch (browserType) {
			case LOCAL_CHROME:
				System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case LOCAL_IE:
				System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
				driver = new ChromeDriver();
				break;
				
			case GRID_CHROME:				
				ChromeOptions chromeOptions = new ChromeOptions();				
				chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
				chromeOptions.setCapability("enableVNC", enableVNC);
				try {
					driver = new RemoteWebDriver(new URL(gridHubURL), chromeOptions);
				}catch(MalformedURLException mfue) {
					logger.error("GridHub URL is malformed: ", mfue);
				}
				break;		
				
			case GRID_FIREFOX:				
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.setCapability("enableVNC", enableVNC);
				try {
					driver = new RemoteWebDriver(new URL(gridHubURL), firefoxOptions);
				}catch(MalformedURLException mfue) {
					logger.error("GridHub URL is malformed: ", mfue);
				}
				break;		
				
		}
		
		return driver;
		
	}

}
