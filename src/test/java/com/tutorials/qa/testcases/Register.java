package com.tutorials.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorial.qa.pages.AccountSuccessPage;
import com.tutorial.qa.pages.Homepage;
import com.tutorial.qa.pages.RegisterPage;
import com.tutorial.qa.utils.Utils;
import com.tutorials.qa.base.Base;

public class Register extends Base {
	
	public Register()
	{
		super();
	}
	
	WebDriver driver ;
	
	
	@BeforeMethod
	public void setup() {
		
		 driver = IntializeBrowserandOpenApplication(prop.getProperty("browserName"));
		 Homepage homePage = new Homepage(driver);
		 homePage.ClickonMyAccountDropMenu();
		 homePage.SelectRegisterOption();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test(priority = 1)
	public void Verify_Register_AnAccount_With_mandatory_fields() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(test_Data_Prop.getProperty("firstName"));
		registerPage.EnterLastName(test_Data_Prop.getProperty("lastName"));
		registerPage.EnterEmail(Utils.generateEmailwithTimestamp());
		registerPage.EnterTelephone(test_Data_Prop.getProperty("telephone"));
		registerPage.EnterPassword(prop.getProperty("validPassword"));
		registerPage.EnterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.ClickOnPrivacyPolicyCheckbox();
		registerPage.ClickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
		accountSuccessPage.VerifyAccountSuccessHeading();
		String actual_SuccessText = accountSuccessPage.VerifyAccountSuccessHeading();
		Assert.assertEquals
		(actual_SuccessText, test_Data_Prop.getProperty("accountSuccessfulHeading"),"Account not created Successfully");
	
	}
	
	
    @Test(priority = 2)
	public void Verify_Register_AnAccount_With_All_fields() 
	{
    	RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(test_Data_Prop.getProperty("firstName"));
		registerPage.EnterLastName(test_Data_Prop.getProperty("lastName"));
		registerPage.EnterEmail(Utils.generateEmailwithTimestamp());
		registerPage.EnterTelephone(test_Data_Prop.getProperty("telephone"));
		registerPage.EnterPassword(prop.getProperty("validPassword"));
		registerPage.EnterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.ClickOnNewsletterCheckbox();
		registerPage.ClickOnPrivacyPolicyCheckbox();
		registerPage.ClickOnContinueButton();
		
		AccountSuccessPage accountSuccessPage = new AccountSuccessPage(driver);
        String actual_SuccessText = accountSuccessPage.VerifyAccountSuccessHeading();
	    Assert.assertEquals
	    (actual_SuccessText, test_Data_Prop.getProperty("accountSuccessfulHeading"),"Account not created Successfully");
	
	}

    @Test(priority = 3)
    public void Verify_Register_AnAccount_With_Existing_Email() 
    {
    	
    	RegisterPage registerPage = new RegisterPage(driver);
		registerPage.EnterFirstName(test_Data_Prop.getProperty("firstName"));
		registerPage.EnterLastName(test_Data_Prop.getProperty("lastName"));
		registerPage.EnterEmail(prop.getProperty("validEmail"));
		registerPage.EnterTelephone(test_Data_Prop.getProperty("telephone"));
		registerPage.EnterPassword(prop.getProperty("validPassword"));
		registerPage.EnterConfirmPassword(prop.getProperty("validPassword"));
		registerPage.ClickOnNewsletterCheckbox();
		registerPage.ClickOnPrivacyPolicyCheckbox();
		registerPage.ClickOnContinueButton();
    	
		String actual_warning = registerPage.VerifyExistingEmailWarning(); 	
    	Assert.assertTrue(actual_warning.contains(test_Data_Prop.getProperty("duplicateHeadingWarning")),"Warning message not displayed");
   	
 
    }
    
    @Test(priority = 4)
    public void Verify_Register_AnAccount_Without_filling_any_details() 
	{
    	RegisterPage registerPage = new RegisterPage(driver);
    	registerPage.ClickOnContinueButton();
		
	
		String actual_PrivacyPolicywarning = registerPage.PrivacyPolicywarning();
        Assert.assertTrue(actual_PrivacyPolicywarning.
  		contains(test_Data_Prop.getProperty("privacyPolicyWarning")),
  		"Privacy policy Warning message not displayed");
        
        String actual_FirstNameWarning = registerPage.FirstNameWarning();
        Assert.assertEquals(actual_FirstNameWarning, 
        test_Data_Prop.getProperty("firstNameWarning"),
        "First name warning message not displayed");
        
        String actual_LastNameWarning = registerPage.LastNameWarning();
        Assert.assertEquals(actual_LastNameWarning, 
        test_Data_Prop.getProperty("lastNameWarning"),
        "Last name warning message not displayed");
        
        String actual_EmailWarning = registerPage.EmailWarning();
        Assert.assertEquals(actual_EmailWarning, 
        test_Data_Prop.getProperty("emailWarning"),
        "Email warning message not displayed");

        String actual_TelephoneWarning = registerPage.TelephoneWarning();
        Assert.assertEquals(actual_TelephoneWarning, 
        test_Data_Prop.getProperty("telephoneWarning"),
        "Telephone warning message not displayed");
        
        String actual_PasswordWarning = registerPage.PasswordWarning();
        Assert.assertEquals(actual_PasswordWarning, 
        test_Data_Prop.getProperty("passwordWarning"),
        "Password warning message not displayed");
        
       
}
}
