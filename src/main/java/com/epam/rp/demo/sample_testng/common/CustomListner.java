package com.epam.rp.demo.sample_testng.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.epam.rp.demo.sample_testng.BaseTest;

public class CustomListner implements ITestListener {
	static final Logger logger = LogManager.getLogger(CustomListner.class);

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestFailure(ITestResult result) {
		new Screenshot().captureScreenshot(result);
		logger.info("Captured screenshot for failed test: "+result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
	}

}
