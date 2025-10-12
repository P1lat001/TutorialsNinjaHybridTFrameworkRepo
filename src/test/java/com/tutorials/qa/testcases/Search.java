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

public class Search extends Base {
	
	public Search()
	{
		super();
	}
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		
		driver =IntializeBrowserandOpenApplication(prop.getProperty("browserName"));
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	@Test(priority = 1)
	public void Verify_Search_With_valid_Product() {
		
		Homepage homePage = new Homepage(driver);
		homePage.EnterProductInSearchBox(test_Data_Prop.getProperty("validProduct"));
		
		SearchPage searchPage = new SearchPage(driver);
		
		//div[@id='search']/descendant::button // for search button
		
		Assert.assertTrue(searchPage.ValidProduct(),"HP LP3065 is not displayed");
		
		}
	
	@Test(priority = 2)
	public void Verify_Search_With_invalid_Product() {
		
		Homepage homePage = new Homepage(driver);
		homePage.EnterProductInSearchBox(test_Data_Prop.getProperty("invalidProduct"));
		
		SearchPage searchPage = new SearchPage(driver);
		
	    String actual_SearchMessage = searchPage.InvalidProduct();
	    Assert.assertEquals(actual_SearchMessage,
	    		test_Data_Prop.getProperty("noProductWarning"),"message not displayed");
	    
	}
	
	
	@Test(priority = 3)
	public void Verify_Search_Without_any_Product() {
		
		Homepage homePage = new Homepage(driver);
		homePage.ClickonSearchButton();
		
		SearchPage searchPage = new SearchPage(driver);
		
		String actual_SearchMessageWithoutProduct = searchPage.InvalidProduct();
	    Assert.assertEquals(actual_SearchMessageWithoutProduct,
	    test_Data_Prop.getProperty("noProductWarning"),"message not displayed");
	}
	
	
	
}
