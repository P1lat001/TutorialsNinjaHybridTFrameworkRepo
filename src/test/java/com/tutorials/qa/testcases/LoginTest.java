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
import com.tutorial.qa.utils.Utils;
import com.tutorials.qa.base.Base;

public class LoginTest extends Base {
	
	LoginPage loginPage;
	AccountPage accountPage;
	
	public LoginTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void setup() 
	{
		
		driver = IntializeBrowserandOpenApplication(prop.getProperty("browserName"));  
		Homepage homePage = new Homepage(driver);
		loginPage = homePage.navigateToLoginpage();
		
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
	public void Verify_login_with_valid_Credentials(String email, String password) 
	{
		
		accountPage=loginPage.login(email, password);
	    Assert.assertTrue(accountPage.VerifyEditYourAccountInformationLink(),
	    		"Edit your account information link is not displayed");	

	}
	
	
	@Test(priority = 2)
	public void Verify_login_with_invalid_Credentials() {
		
		loginPage.login(Utils.generateEmailwithTimestamp(),test_Data_Prop.getProperty("invalidPassword"));
		
		Assert.assertTrue(loginPage.getemailPasswordWarningMessage().contains(test_Data_Prop.getProperty("passwordNomatchWarning")),"Warning message is not displayed");
		
	}
	

	@Test(priority = 3)
	public void verify_login_with_InvalidEmail_and_ValidPassword() {
		
		
		loginPage.login(Utils.generateEmailwithTimestamp(), prop.getProperty("validPassword"));
		Assert.assertTrue(loginPage.getemailPasswordWarningMessage().contains(test_Data_Prop.getProperty("passwordNomatchWarning")),"Warning message is not displayed");
		
				
	}
	
	@Test(priority = 4)
	public void Verify_login_with_validEmail_and_InvalidPassword() 
	{
		loginPage.login(prop.getProperty("validEmail"), test_Data_Prop.getProperty("invalidPassword"));
		Assert.assertTrue(loginPage.getemailPasswordWarningMessage().contains(test_Data_Prop.getProperty("passwordNomatchWarning")),"Warning message is not displayed");
	
				
}
	@Test(priority = 5)
	public void Verify_login_without_providing_Credentials() {

		loginPage.ClickonLoginButton();
		Assert.assertTrue(loginPage.getemailPasswordWarningMessage().contains(test_Data_Prop.getProperty("passwordNomatchWarning")),"Warning message is not displayed");
	
		}
}
	


