package com.epam.rp.demo.sample_testng;

import org.testng.annotations.Test;

import com.epam.rp.demo.sample_testng.common.BrowserFactory;
import com.epam.rp.demo.sample_testng.common.CommonTask;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;

public class BaseTest {  

  protected WebDriver driver;
  static final Logger logger = LogManager.getLogger(BaseTest.class);

  @BeforeSuite  
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }
  
  @BeforeTest	
  @Parameters({"browser", "gridHubURL"})
  public void setUp(String browser, String gridHubURL, ITestContext testContext) {		
	  logger.info("Grid Hub:"+gridHubURL+" , Browser: "+browser);
	  driver = BrowserFactory.createInstance(browser);
	  testContext.setAttribute("driver", driver);
	  CommonTask.launchApplication(driver);
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }
  
  

}
