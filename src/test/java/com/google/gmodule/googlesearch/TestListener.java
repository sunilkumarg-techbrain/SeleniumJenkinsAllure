package com.google.gmodule.googlesearch;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener extends GoogleSearchBaseTest implements ITestListener {

	protected WebDriver driver;

	@Override
	public void onTestFailure(ITestResult result) {
		log("<" + result.getName() + "> Finished with status " + getResultStatusName(result.getStatus()));
		driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		log("Capturing screenshot of failure.");
		captureScreenshot(driver, result.getMethod().getMethodName());
		log("Captured screenshot of failure and embedded in allure report.");
	}

	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		log("<" + result.getName() + "> Finished with status " + getResultStatusName(result.getStatus()));
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log("<" + result.getName() + "> Finished with status " + getResultStatusName(result.getStatus()));
		driver = (WebDriver) result.getTestContext().getAttribute("WebDriver");
		log("Capturing screenshot of failure.");
		captureScreenshot(driver, result.getMethod().getMethodName());
		log("Captured screenshot of failure and embedded in allure report.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}

	public String getResultStatusName(int status) {
		switch (status) {
		case 1:
			return "SUCCESS";
		case 2:
			return "FAILURE";
		case 3:
			return "SKIP";
		default:
			return null;
		}
	}
}