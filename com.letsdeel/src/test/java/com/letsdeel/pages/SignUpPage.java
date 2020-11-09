package com.letsdeel.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy (className = "mb-4") List<WebElement> typeOfUser;
	
	@FindBy(xpath = "//*[contains(text(), 'CONTINUE')]") WebElement continueButton;
		
	@FindBy(name = "name") WebElement fullName;
	
	@FindBy(name = "email") WebElement email;
	
	@FindBy(name = "password") WebElement password;
	
	@FindBy(name = "confirmPassword") WebElement confirmPassword;
	
	@FindBy(xpath = "//*[contains(text(), 'CREATE YOUR DEEL ACCOUNT')]") WebElement createAccount;
	
	@FindBy(className = "input-container-error") WebElement errorMsg;
	
	public void selectUserType() //As a client
	{
		typeOfUser.get(0).click();
		continueButton.click();
	}
	
	public void insertDetails(String uFullName, String uEmail, String uPassword, String uConfirmPassword)
	{
		fullName.sendKeys(uFullName);
		email.sendKeys(uEmail);
		password.sendKeys(uPassword);
		confirmPassword.sendKeys(uConfirmPassword);
	}
	
	public void submit()
	{
		createAccount.click();
	}
	
	public void assertTitle()
	{
		Assert.assertEquals(driver.getTitle(), "Deel - Payroll for remote teams");
		System.out.println("Assert Title passed");
	}
	
	public void assertMisMatchPasswords()
	{
		Assert.assertEquals(errorMsg.getText(), "Password must match");
		System.out.println("Assert MisMatchPasswords passed");
	}
}
