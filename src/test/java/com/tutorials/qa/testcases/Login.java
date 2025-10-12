package com.tutorials.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorial.qa.pages.AccountPage;
import com.tutorial.qa.pages.Homepage;
import com.tutorial.qa.pages.LoginPage;
import com.tutorial.qa.pages.Homepage;
import com.tutorial.qa.utils.Utils;
import com.tutorials.qa.base.Base;

public class Login extends Base {
	
	public Login()
	{
		super();
	}
	
	WebDriver driver;
	
	
	@BeforeMethod
	public void setup() 
	{
		
		driver = IntializeBrowserandOpenApplication(prop.getProperty("browserName"));  
		Homepage homePage = new Homepage(driver);
		homePage.ClickonMyAccountDropMenu();
		homePage.SelectLoginOption();
		
		
	}
	
	//Precondition
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@DataProvider(name="ValidCredentialsSupplier")
	public Object[][] SupplyTestData()
	{
		Object[][] data =Utils.getDatafromExcel("Login");
		return data; 
				
	}
	
	
	@Test(priority = 1, dataProvider = "ValidCredentialsSupplier")
	public void Verify_login_with_valid_Credentials(String email, String password) {
		
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.EnterEmail(email);
		loginPage.EnterPassword(password);
		loginPage.ClickonLoginButton();
		AccountPage accountPage = new AccountPage(driver);
	    Assert.assertTrue(accountPage.VerifyEditYourAccountInformationLink(),"Edit your account information link is not displayed");	
		
		
	}
	
	
	@Test(priority = 2)
	public void Verify_login_with_invalid_Credentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.EnterEmail(Utils.generateEmailwithTimestamp());
		loginPage.EnterPassword(test_Data_Prop.getProperty("invalidPassword"));
		loginPage.ClickonLoginButton();
		
		
		String actualWarningMessage = loginPage.getemailPasswordWarningMessage();
		
		String ExpectedWarningMessage = test_Data_Prop.getProperty("passwordNomatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Warning message is not displayed");
		
	}
	

	@Test(priority = 3)
	public void verigy_login_with_InvalidEmail_and_ValidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.EnterEmail(Utils.generateEmailwithTimestamp());
		loginPage.EnterPassword(test_Data_Prop.getProperty("validPassword"));
		loginPage.ClickonLoginButton();
		
	
		String actualWarningMessage = loginPage.getemailPasswordWarningMessage();
		String ExpectedWarningMessage = test_Data_Prop.getProperty("passwordNomatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Warning message is not displayed");
		
				
	}
	
	@Test(priority = 4)
	public void Verify_login_with_validEmail_and_InvalidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.EnterEmail(prop.getProperty("validEmail"));
		loginPage.EnterPassword(test_Data_Prop.getProperty("invalidPassword"));
		loginPage.ClickonLoginButton();
		
		String actualWarningMessage = loginPage.getemailPasswordWarningMessage();
		String ExpectedWarningMessage = test_Data_Prop.getProperty("passwordNomatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Warning message is not displayed");
	
				
}
	@Test(priority = 5)
	public void Verify_login_without_providing_Credentials() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.ClickonLoginButton();
		
		String actualWarningMessage = loginPage.getemailPasswordWarningMessage();
		String ExpectedWarningMessage = test_Data_Prop.getProperty("passwordNomatchWarning");
		Assert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage),"Warning message is not displayed");
	
		}
}
	


