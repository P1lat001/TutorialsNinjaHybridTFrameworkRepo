package com.tutorial.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	
	WebDriver driver;
	
	@FindBy(linkText ="HP LP3065")
	private WebElement ValidHPProduct;
	
	@FindBy(xpath="//div[@id='content']/h2/following-sibling::p")
	private WebElement inValidProduct;
	
	public SearchPage(WebDriver driver)
	{
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public boolean ValidProduct()
	{
		boolean productHp = ValidHPProduct.isDisplayed();
		return productHp;
	}
	
	public String InvalidProduct()
	{
		return inValidProduct.getText();
	}
}
