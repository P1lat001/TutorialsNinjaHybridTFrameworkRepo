package com.tutorials.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorial.qa.utils.Utils;

public class Base {

	public WebDriver driver;
    public Properties prop;
    public Properties test_Data_Prop;
    
	public Base() 
	{
		
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorials\\qa\\config\\config.properties");
		
		test_Data_Prop = new Properties();
		File testDatafile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorial\\qa\\testdata\\testdata.properties");
		try {
		FileInputStream datafis = new FileInputStream(testDatafile);
		test_Data_Prop.load(datafis);
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		
		
		try {
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis); 
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
	}
	public WebDriver IntializeBrowserandOpenApplication(String browserName) {
		
	
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
		  driver = new FirefoxDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utils.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utils.PAGE_LOAD_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
