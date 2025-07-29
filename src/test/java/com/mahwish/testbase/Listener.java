package com.mahwish.testbase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.mahwish.utils.CommonMethods;

public class Listener implements ITestListener{

	
	public void onStart(ITestContext context)
	{
		System.out.println("Functionality test started!");
	}
	
	public void onFinish(ITestContext context)
	{
		System.out.println("Functionality test finished!");
	}
	
	
	public void onTestStart(ITestResult result)
	{
		//prints to the console
		System.out.println(result.getName() + " test is starting!");
		
		//create a test report just before the @Test starts
		BaseClass.test = BaseClass.report.createTest(result.getName());
		
	}
	
	
	public void onTestSuccess(ITestResult result)
	{
		//print on the console
		System.out.println(result.getName() + " test just passed!");
		
		//print the test pass on the report
		BaseClass.test.pass("Test Passed: " + result.getName());
		
		//take a screenshot and add it to the report
		String successImage = CommonMethods.takeScreenShot("passed/"+result.getName());
		BaseClass.test.addScreenCaptureFromPath(successImage);
	}
	
	
	public void onTestFailure(ITestResult result)
	{
		//printing on console
		System.out.println(result.getName()  + " test just failed!");
		
		
		//print the test failure on the report
		BaseClass.test.fail("Test Failed: " + result.getName());
		
		//take a screenshot and add it to the report
		String failImage = CommonMethods.takeScreenShot("failed/"+result.getName());
		BaseClass.test.addScreenCaptureFromPath(failImage);
		
	}
	
}
