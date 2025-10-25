package com.tutorials.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorial.qa.pages.Homepage;
import com.tutorial.qa.pages.SearchPage;
import com.tutorials.qa.base.Base;
// updated comment
public class SearchTest extends Base {
	
	SearchPage searchPage;
	Homepage homePage;
	
	public SearchTest()
	{
		super();
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver =IntializeBrowserandOpenApplication(prop.getProperty("browserName"));
		homePage = new Homepage(driver);
		
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void Verify_Search_With_valid_Product() {
		
		
		searchPage = homePage.EnterProductInSearchBox(test_Data_Prop.getProperty("validProduct"));
		//div[@id='search']/descendant::button // for search button
	    Assert.assertTrue(searchPage.ValidProduct(),"HP LP3065 is not displayed");
		
		}
	
	@Test(priority = 2)
	public void Verify_Search_With_invalid_Product() {
		
	    
	    searchPage = homePage.EnterProductInSearchBox(test_Data_Prop.getProperty("invalidProduct"));
	    Assert.assertEquals(searchPage.InvalidProduct(),
	    		"abcd","message not displayed");
	    
	}
	
	
	@Test(priority = 3,dependsOnMethods = {"Verify_Search_With_valid_Product",
			"Verify_Search_With_invalid_Product"})
	public void Verify_Search_Without_any_Product() {
		
		
		searchPage = homePage.ClickonSearchButton();
	    Assert.assertEquals(searchPage.InvalidProduct(),
	    test_Data_Prop.getProperty("noProductWarning"),"message not displayed");
	}
	
	
	
}
