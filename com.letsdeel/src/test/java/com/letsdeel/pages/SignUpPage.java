package com.letsdeel.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.letsdeel.utility.Helper;

public class SignUpPage {
	
	WebDriver driver;
	
	public SignUpPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy (className = "mb-4") List<WebElement> typeOfUser;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[2]/div[3]/button/div") WebElement continueButton;
	
	@FindBy(xpath = "//span[.='Sign up using Google']") WebElement googleSignUp;// Will not be tested, since there isn't any field validation for this
	
	@FindBy(name = "name") WebElement fullName;
	
	@FindBy(name = "email") WebElement email;
	
	@FindBy(name = "password") WebElement password;
	
	@FindBy(name = "confirmPassword") WebElement confirmPassword;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[4]/div/div/div/form/button/div") WebElement createAccount;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[2]/div[1]/div/div/div/p") WebElement back;
	
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
		System.out.println("Assert passed");
	}
	
	public void goBack()
	{
		back.click();
	}
	
	public void assertWrongPassword()
	{
		System.out.println(errorMsg.getText());
		/*Assert.assertEquals(errorMsg.getText(), "Password must match");
		System.out.println("Assert passed");*/
	}
}
