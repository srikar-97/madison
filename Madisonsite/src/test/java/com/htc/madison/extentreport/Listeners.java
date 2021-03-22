package com.htc.madison.extentreport;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.htc.madison.BaseTest;
import com.htc.madison.constants.Constants;
import com.htc.madison.utilites.Screenshot;



public class Listeners extends BaseTest implements ITestListener{
	ExtentTestManager etm=new ExtentTestManager();
	public void onStart(ITestContext context) {
		System.out.println("*** Test Suite " + context.getName() + " started ***");
	}

	public void onFinish(ITestContext context) {
		System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
		ExtentTestManager.endTest();
		ExtentManager.getInstance().flush();
	}

	public void onTestStart(ITestResult result) {
		System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
		ExtentTestManager.startTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("*** Executed " + result.getMethod().getMethodName() + " test successfully...");
		ExtentTestManager.getTest().log(Status.PASS, "Test passed");
		 Object testClass = result.getInstance();
		    WebDriver driver = ((BaseTest) testClass).getDriver();
		    try {
				Screenshot.capturescreenShot(driver, Constants.SCREENSHOT_PASS,result.getMethod().getMethodName());
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
		ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
		Object testClass = result.getInstance();
	    WebDriver driver = ((BaseTest) testClass).getDriver();
	    try {
			Screenshot.capturescreenShot(driver, Constants.SCREENSHOT_FAIL,result.getMethod().getMethodName());
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("*** Test " + result.getMethod().getMethodName() + " skipped...");
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("*** Test failed but within percentage % " + result.getMethod().getMethodName());
	}
}
