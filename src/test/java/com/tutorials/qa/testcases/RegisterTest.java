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


public class RegisterTest extends Base {
	
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	
	public RegisterTest()
	{
		super();
	}
	
	public WebDriver driver ;
	
	
	@BeforeMethod
	public void setup() {
		
		 driver = IntializeBrowserandOpenApplication(prop.getProperty("browserName"));
		 Homepage homePage = new Homepage(driver);
		 registerPage =homePage.navigateToRegisterPage();
		 
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	@Test(priority = 1)
	public void Verify_Register_AnAccount_With_mandatory_fields() {
		
		
		accountSuccessPage=registerPage.register(test_Data_Prop.getProperty("firstName"),
				test_Data_Prop.getProperty("lastName"),
				Utils.generateEmailwithTimestamp(),
				test_Data_Prop.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
		Assert.assertEquals
		(accountSuccessPage.VerifyAccountSuccessHeading(),
				test_Data_Prop.getProperty("accountSuccessfulHeading"),
				"Account not created Successfully");
	
	}
	
	
    @Test(priority = 2)
	public void Verify_Register_AnAccount_With_All_fields() 
	{
		
		accountSuccessPage = registerPage.registerWithAllFields(test_Data_Prop.getProperty("firstName"),
				test_Data_Prop.getProperty("lastName"),
				Utils.generateEmailwithTimestamp(),
				test_Data_Prop.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
		
	    Assert.assertEquals
	    (accountSuccessPage.VerifyAccountSuccessHeading(), test_Data_Prop.getProperty("accountSuccessfulHeading"),"Account not created Successfully");
	
	}

    @Test(priority = 3)
    public void Verify_Register_AnAccount_With_Existing_Email() 
    {
		
	            registerPage.registerWithAllFields(test_Data_Prop.getProperty("firstName"),
				test_Data_Prop.getProperty("lastName"),
				prop.getProperty("validEmail"),
				test_Data_Prop.getProperty("telephone"),
				prop.getProperty("validPassword"), prop.getProperty("validPassword"));
    	
			
    	Assert.assertTrue(registerPage.VerifyExistingEmailWarning()
    			.contains(test_Data_Prop.getProperty("duplicateHeadingWarning")),"Warning message not displayed");
   	
 
    }
    
    @Test(priority = 4)
    public void Verify_Register_AnAccount_Without_filling_any_details() 
	{
    	
    	registerPage.ClickOnContinueButton();
		
	Assert.assertTrue(registerPage.displayStatusOfWarningmessages(test_Data_Prop.getProperty("privacyPolicyWarning"),
			test_Data_Prop.getProperty("firstNameWarning"),
			test_Data_Prop.getProperty("lastNameWarning"),
			test_Data_Prop.getProperty("emailWarning"),
			test_Data_Prop.getProperty("telephoneWarning"),
			test_Data_Prop.getProperty("passwordWarning")), "Warning messages are not displayed");
		
}
}
