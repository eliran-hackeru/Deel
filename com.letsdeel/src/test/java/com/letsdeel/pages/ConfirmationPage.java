package com.letsdeel.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ConfirmationPage
{
	WebDriver driver;
	
	public ConfirmationPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(className = "confirmation-signup-content") WebElement confirmationH2;
	
	public void asserConfirmaEmail()
	{
		Assert.assertEquals(confirmationH2.getText(), "We’ve sent you a confirmation email");
		System.out.println("Assert Confirm Email passed");
	}

}
