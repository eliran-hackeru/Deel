package com.letsdeel.testcases;

import org.testng.annotations.Test;
import com.letsdeel.testcases.BaseClass;
import org.openqa.selenium.support.PageFactory;
import com.letsdeel.pages.SignUpPage;
import com.letsdeel.utility.Helper;

public class SignUpTest extends BaseClass
{
	@Test(priority=0) //Sanity - Hard Coded
	public void SignUpApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName); //The report file is located in the test-output folder under myReport.html
		
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		
		signUpPage.assertTitle();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"01_BrowserStarted");
		
		signUpPage.selectUserType();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"02_BlankForm");
		
		signUpPage.insertDetails("Eliran Duveen", "eduveen@gmail.com", "123abc", "123abc");
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"03_Details");
		
		
		signUpPage.submit();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"04_Complete");
		
		signUpPage.goBack();
	}
	
	@Test(priority=1) //Outsourced Details
	public void FileSignUpApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName); //The report file is located in the test-output folder under myReport.html
		
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		
		signUpPage.assertTitle();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"11_BrowserStarted");
		
		signUpPage.selectUserType();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"12_BlankForm");
		
		signUpPage.insertDetails(excel.getStringData("Details", 1, 0), excel.getStringData("Details", 1, 1),excel.getStringData("Details", 1, 2), excel.getStringData("Details", 1,3)); //The Excel file is located in the TestData folder under Data.xlsx
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"13_Details");
		
		
		signUpPage.submit();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"14_Complete");
		
		signUpPage.goBack();
	}
	
	@Test(priority=2) //Outsourced Details - Negative testing: passwords mismatch
	public void NegativeFileSignUpApp() throws InterruptedException
	{
		String testName = new Throwable().getStackTrace()[0].getMethodName();
		
		extentTest = extent.createTest(testName); //The report file is located in the test-output folder under myReport.html
		
		SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		
		signUpPage.assertTitle();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"11_BrowserStarted");
		
		signUpPage.selectUserType();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"12_BlankForm");
		
		signUpPage.insertDetails(excel.getStringData("Details", 2, 0), excel.getStringData("Details", 2, 1),excel.getStringData("Details", 2, 2), excel.getStringData("Details", 2,3)); //The Excel file is located in the TestData folder under Data.xlsx
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"13_Details");
		
		
		signUpPage.submit();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"14_Complete");
	}
}
