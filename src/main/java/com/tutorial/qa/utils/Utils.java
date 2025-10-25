package com.tutorial.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.PublicKey;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {

	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 10;
	
	public static String generateEmailwithTimestamp() {
	     Date date = new Date();
	    String Timestamp = date.toString().replace(":", "_").replace(" ", "_");
	    return "abdullahms218"+Timestamp+"@gmail.com";
	    }
	
	public static Object[][] getDatafromExcel(String sheetName)
	{
		XSSFWorkbook workbook = null;
		File excelFile = new File(System.getProperty("user.dir")+
				"\\src\\main\\java\\com\\tutorial\\qa\\testdata\\TutorialsNinjaProject.xlsx");
		try {
			
		FileInputStream fisExcel= new FileInputStream(excelFile);
		workbook= new XSSFWorkbook(fisExcel);
		} catch (Throwable e) 
		{
		    e.printStackTrace();
		}
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int row = sheet.getLastRowNum(); // 2 rows - last contain data rows
		int column = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[row][column];
		for (int i = 1; i <= row; i++) {
			XSSFRow row_DataExcel = sheet.getRow(i);
			for (int j = 0; j < column; j++) {
				XSSFCell cell = row_DataExcel.getCell(j);
				CellType cellType = cell.getCellType();
				
				switch (cellType) {
				case STRING:
					data[i-1][j]= cell.getStringCellValue();
					break;
					
				case NUMERIC:
					data[i-1][j]= Integer.toString((int)cell.getNumericCellValue());
					break;
					
					case BOOLEAN: 
						data[i-1][j]= cell.getBooleanCellValue();
						break;
				}
				
			}
			
		}
		return data;
	}
	
	public static String CaptureScreeenshot(WebDriver driver, String testName)
	{
		
		File srcScreenshot=((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"\\Screenshot\\"+testName+".png";
		
		try {
			FileHandler.copy(srcScreenshot, new File(destinationPath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return destinationPath;
	}
}
