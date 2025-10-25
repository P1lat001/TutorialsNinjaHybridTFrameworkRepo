package com.tutorial.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {

	public static ExtentReports generateExtentReport() {
		
		
		ExtentReports extent = new ExtentReports();
		File reportFile = new File(System.getProperty("user.dir") + "\\test-output\\ExtentReports\\ExtentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("TutorialsNinja Test Automation Report");
		sparkReporter.config().setReportName("TutorialsNinja Functional Testing");
		sparkReporter.config().setTimeStampFormat("dd-MM-yyyy HH:mm:ss");
	
		extent.attachReporter(sparkReporter);
		Properties configProp = new Properties();
		File configPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorials\\qa\\config\\config.properties");
		try {
		FileInputStream fileConfigProp = new FileInputStream(configPropFile);
		configProp.load(fileConfigProp);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		extent.setSystemInfo("Appication URL", configProp.getProperty("url"));
		extent.setSystemInfo("BrowserName", configProp.getProperty("browserName"));
		extent.setSystemInfo("Operating System",System.getProperty("os.name"));
		extent.setSystemInfo("username",System.getProperty("user.name"));
		extent.setSystemInfo("Java Version",System.getProperty("java.version"));
		return extent;
		
	}

	
}
