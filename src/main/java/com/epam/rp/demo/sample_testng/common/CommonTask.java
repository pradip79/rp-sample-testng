package com.epam.rp.demo.sample_testng.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class CommonTask {
	static final Logger logger = LogManager.getLogger(CommonTask.class);
	public static Properties getProperties(String fileName) {
		String propFile = "config/"+fileName;
		Properties props = new Properties();
		InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(propFile);
		
		try {
			logger.info("File name:"+propFile);
			props.load(inputStream);
		}catch(IOException ie) {
			logger.error("Error loading properties file: ",ie);
		}
		
		return props;
	}
	
	public static void launchApplication(WebDriver driver) {
		Properties props = getProperties("test.properties");
		String appURL = props.getProperty("appURL");
		driver.get(appURL);
		
		if(!driver.getTitle().contains("Wikipedia")) {
			logger.error("Error launching application");
			throw new AppLaunchException ("Error launching application");
		}
		
	}

}
