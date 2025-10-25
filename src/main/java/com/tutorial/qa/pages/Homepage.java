package com.tutorial.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	
	WebDriver driver;
	
	@FindBy(linkText = "My Account")
    private	WebElement myAccountDropMenu;
	
	@FindBy(linkText ="Login")
	private WebElement loginOption;
	
	@FindBy(linkText ="Register")
	private WebElement registerOption;
	
	@FindBy(xpath ="//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//div[@id='search']/descendant::button")
	private WebElement clickSearchButton;
	
	public SearchPage ClickonSearchButton()
	{
		clickSearchButton.click();
		return new SearchPage(driver);
	}
	
	public Homepage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	public LoginPage navigateToLoginpage()
	{
		myAccountDropMenu.click();
		loginOption.click();
		return new LoginPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage()
	{
		myAccountDropMenu.click();
		registerOption.click();
		return new RegisterPage(driver);
	}
	
	public SearchPage EnterProductInSearchBox(String productName)
	{
		searchBox.sendKeys(productName+ Keys.ENTER);
		return new SearchPage(driver);
	}
	

}
