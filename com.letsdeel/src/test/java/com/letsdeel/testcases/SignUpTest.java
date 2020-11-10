package com.letsdeel.testcases;

import org.testng.annotations.Test;
import com.letsdeel.testcases.BaseClass;
import org.openqa.selenium.support.PageFactory;

import com.letsdeel.pages.ConfirmationPage;
import com.letsdeel.pages.SignUpPage;
import com.letsdeel.utility.ExcelDataProvider;
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
		
		signUpPage.insertDetails("Test User", "AutoTest"+Helper.getSaltString()+"@gmail.com", "123abc", "123abc"); //All the testing emails will begin with "AutoTest"
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"03_Details");
		
		signUpPage.submit();
				
		ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
		
		confirmationPage.asserConfirmEmail();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"04_Complete");
		
		driver.navigate().back();
	}
	
	@Test(priority=1) //Outsourced Details
	public void FileSignUpApp() throws InterruptedException
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
		
		String data[] = Helper.excelString(excel, "Details", 1, 4); //The Excel file is located in the TestData folder under Data.xlsx
		
		signUpPage.insertDetails(data[0], "AutoTest"+Helper.getSaltString()+"@gmail.com", data[2], data[3]);
				
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"03_Details");
	
		signUpPage.submit();
				
		ConfirmationPage confirmationPage = PageFactory.initElements(driver, ConfirmationPage.class);
		
		confirmationPage.asserConfirmEmail();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"04_Complete");
		
		driver.navigate().back();
	}
	
	@Test(priority=2) //Outsourced Details - Negative testing: passwords mismatch
	public void MisMatchPasswordsApp() throws InterruptedException
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
		
		String data[] = Helper.excelString(excel, "Details", 2, 4); //The Excel file is located in the TestData folder under Data.xlsx
		
		signUpPage.insertDetails(data[0], data[1], data[2], data[3]);
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"03_Details");
		
		signUpPage.submit();
		
		signUpPage.assertMisMatchPasswords();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"04_Complete");
		
		signUpPage.goBack();
	}
	
	@Test(priority=3) //Outsourced Details - Negative testing: Invalid email address
	public void InvalidEmailApp() throws InterruptedException
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
		
		String data[] = Helper.excelString(excel, "Details", 3, 4); //The Excel file is located in the TestData folder under Data.xlsx
		
		signUpPage.insertDetails(data[0], data[1], data[2], data[3]);
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"03_Details");
		
		signUpPage.submit();
		
		signUpPage.assertInvalidEmail();
		
		Thread.sleep(1000);
		Helper.captureScreenshot(driver,testName,"04_Complete");
	}
}
