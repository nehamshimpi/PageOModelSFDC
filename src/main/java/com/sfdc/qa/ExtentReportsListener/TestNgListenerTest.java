package com.sfdc.qa.ExtentReportsListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNgListenerTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Testcases Started and details are :" + result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Testcases Success and details are :" + result.getName());
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("Testcases Failed and details are :" + result.getName());
	}

	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Testcases Skipped and details are :" + result.getName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		
		
	}
	
	
	 
}


