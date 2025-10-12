package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement PrivacyPolicyCheckbox;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement ContinueButton;
	
	@FindBy(name="newsletter")
	private WebElement newsletterCheckbox;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement existingEmailWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
    private WebElement PrivacyPolicywarning;
	
	@FindBy(xpath="//input[@name='firstname']/following-sibling::div")
	private WebElement FirstNameWarning;
	
	
	@FindBy(xpath="//input[@name='lastname']/following-sibling::div")
	private WebElement LastNameWarning;
	
	@FindBy(xpath="//input[@name='email']/following-sibling::div")
	private WebElement EmailWarning;
	
	@FindBy(xpath="//input[@name='telephone']/following-sibling::div")
	private WebElement TelephoneWarning;
	
	@FindBy(xpath="//input[@name='password']/following-sibling::div")
	private WebElement PasswordWarning;
	
	public String PrivacyPolicywarning() 
	{
		String text = PrivacyPolicywarning.getText();
		return text;
	}
	
	public String FirstNameWarning() 
	{
		String text = FirstNameWarning.getText();
		return text;
	}
	
	public String LastNameWarning() 
	{
		String text = LastNameWarning.getText();
		return text;
	}
	
	public String EmailWarning() 
	{
		String text = EmailWarning.getText();
		return text;
	}
	
	public String TelephoneWarning() 
	{
		String text = TelephoneWarning.getText();
		return text;
	}
	
	public String PasswordWarning() 
	{
		String text = PasswordWarning.getText();
		return text;
	}
	
	
	
	public RegisterPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void EnterFirstName(String firstName) 
	{
		firstNameField.sendKeys(firstName);
	}
	
	public void EnterLastName(String lastName) 
	{
		lastNameField.sendKeys(lastName);
	}
	
	public void EnterEmail(String email) 
	{
		emailField.sendKeys(email);
	}
	
	public void EnterTelephone(String telephone) 
	{
		telephoneField.sendKeys(telephone);
	}
	
	public void EnterPassword(String password) 
	{
		passwordField.sendKeys(password);
	}
	
	public void EnterConfirmPassword(String confirmPassword) 
	{
		confirmPasswordField.sendKeys(confirmPassword);
	}
	
	public void ClickOnPrivacyPolicyCheckbox() 
	{
		PrivacyPolicyCheckbox.click();
	}
	
	public void ClickOnContinueButton() 
	{
		ContinueButton.click();
	}
	
	public void ClickOnNewsletterCheckbox() 
	{
		newsletterCheckbox.click();
	}
	
	public String VerifyExistingEmailWarning() 
	{
		String text = existingEmailWarning.getText();
		return text;
	}

}
