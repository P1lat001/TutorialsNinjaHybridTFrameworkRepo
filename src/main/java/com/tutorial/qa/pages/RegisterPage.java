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
	
	public AccountSuccessPage ClickOnContinueButton() 
	{
		ContinueButton.click();
		return new AccountSuccessPage(driver);
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
	
	public AccountSuccessPage register(String firstName,String lastName, String email,
			String telephone,String password,String confirmPassword)

	{
		
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		PrivacyPolicyCheckbox.click();
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}

	
	public AccountSuccessPage registerWithAllFields(String firstName,String lastName, String email,
			String telephone,String password,String confirmPassword)

	{
		
		firstNameField.sendKeys(firstName);
		lastNameField.sendKeys(lastName);
		emailField.sendKeys(email);
		telephoneField.sendKeys(telephone);
		passwordField.sendKeys(password);
		confirmPasswordField.sendKeys(confirmPassword);
		newsletterCheckbox.click();
		PrivacyPolicyCheckbox.click();
		ContinueButton.click();
		return new AccountSuccessPage(driver);
	}
	
	public boolean displayStatusOfWarningmessages(String expectedPrivacyPolicywarning, 
			String expectedFirstNameWarning,
			String expectedLastNameWarning,
			String expectedEmailWarning,
			String expectedTelephoneWarning,
			String expectedPasswordWarning )
	{
		
		boolean privacyPolicyWarningStatus = PrivacyPolicywarning.getText().contains(expectedPrivacyPolicywarning);
		
		
		boolean firstNameWarningStatus = FirstNameWarning.getText().equals(expectedFirstNameWarning);
		
		
		boolean LastNameWarningStatus = LastNameWarning.getText().equals(expectedLastNameWarning);
		
		
		boolean EmailWarningStatus = EmailWarning.getText().equals(expectedEmailWarning);
		
	
		boolean TelephoneWarningStatus = TelephoneWarning.getText().equals(expectedTelephoneWarning);
		
		
		boolean PasswordWarningStatus = PasswordWarning.getText().equals(expectedPasswordWarning);
		
		return privacyPolicyWarningStatus && firstNameWarningStatus && LastNameWarningStatus
				&& EmailWarningStatus && TelephoneWarningStatus && PasswordWarningStatus;
		
		
	}
	
}
