package com.tutorial.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(xpath ="//input[@value='Login']")
    private	WebElement myAccountDropMenu;
	
	@FindBy(linkText ="Login")
	private WebElement loginOption;
	
	@FindBy(linkText ="Register")
	private WebElement registerOption;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement clickSearchButton;
	
	public void ClickonSearchButton()
	{
		clickSearchButton.click();
	}
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void ClickonMyAccountDropMenu()
	{
		myAccountDropMenu.click();
	}
	
	public void SelectLoginOption()
	{
		loginOption.click();
	}
	
	public void SelectRegisterOption()
	{
		registerOption.click();
	}
	
	public void EnterProductInSearchBox(String productName)
	{
		searchBox.sendKeys(productName+ Keys.ENTER);
		
	}
	

}
