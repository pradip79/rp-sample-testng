package com.epam.rp.demo.sample_testng.common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class Screenshot {
	static final Logger logger = LogManager.getLogger(Screenshot.class);

	private String PROJECT_ROOT_PATH = System.getProperty("user.dir");
	
	public final static String getDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		return df.format(new Date());
	}

	public final static String getDateTime() {
		DateFormat dtf = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss.SSS");
		return dtf.format(new Date());
	}

	public void captureScreenshot(ITestResult result) {
		String methodName = result.getName().toString().trim();
		String currentDir = PROJECT_ROOT_PATH + "/target/" + new File("Screenshots");
		String folderNameWithTimeStamp = getDate();
		String screenshotNameWithTimeStamp = getDateTime();
		String finalPath = currentDir + "\\" + folderNameWithTimeStamp;
		File file = new File(finalPath);
		file.mkdir();

		WebDriver driver = (WebDriver) result.getTestContext().getAttribute("driver");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = file + "\\"  + methodName + "_" + screenshotNameWithTimeStamp + ".jpeg";

		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath));
		} catch (IOException ioe) {			
			logger.error("Error saving screenshot: "+ioe);
		}
	}
}