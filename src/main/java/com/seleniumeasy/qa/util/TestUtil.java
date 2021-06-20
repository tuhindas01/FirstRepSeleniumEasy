package com.seleniumeasy.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class TestUtil {
	
	public static String Test_Data_Sheet_Path = "C:\\Users\\dastu\\eclipse-workspace\\MyTestProject\\src\\main\\java\\com\\seleniumeasy\\qa\\testdata\\SeleniumEasyTestData.xlsx";
	public static Workbook book;
	public static Sheet sheet;
	
	public static long Page_Load_Timeout = 30;
	public static long Implicit_Wait = 20;
	
	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor)driver);
		//js.executeScript("window.scrollTo(0,document.body.scrollHight)");
		js.executeScript("window.scrollBy(0,350)", "");
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			 file = new FileInputStream(Test_Data_Sheet_Path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
		e.printStackTrace();
	}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0; i<sheet.getLastRowNum(); i++)
		{
			for (int k=0; k<sheet.getRow(0).getFirstCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
	}


}
