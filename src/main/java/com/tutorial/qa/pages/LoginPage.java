package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	
	WebDriver driver;
	
	@FindBy(id="input-email")
    private WebElement emailField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@value='Login']")
	private WebElement loginButtonLoginPage;
	
	@FindBy(xpath="//div[contains(@class, 'alert-dismissible')]")
	private WebElement emailpasswordWarningMessage;
	
	public LoginPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void EnterEmail(String email)
	{
		emailField.sendKeys(email);
	}
	
	public void EnterPassword(String password)
	{
		passwordField.sendKeys(password);
	}
	
	public void ClickonLoginButton()
	{
		loginButtonLoginPage.click();
	}
	
	public String getemailPasswordWarningMessage() {
		String text = emailpasswordWarningMessage.getText();
		return text;
	}
	
	
	
	
}
