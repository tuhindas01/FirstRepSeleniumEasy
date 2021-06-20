package com.seleniumeasy.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.seleniumeasy.qa.base.TestBase;
import com.seleniumeasy.qa.pages.CheckBoxDemo;
import com.seleniumeasy.qa.pages.HomePage;
import com.seleniumeasy.qa.pages.SimpleFormDemo;
import com.seleniumeasy.qa.util.TestUtil;

public class SimpleFormDemoTest extends TestBase{
	
	HomePage home; 
	SimpleFormDemo simpleFormObj;
	CheckBoxDemo checkBoxObj;
	
	String sheetName = "SimpleForm";
	
	public SimpleFormDemoTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		
		home = new HomePage();
		home.start();
		simpleFormObj = home.navigateSimpleForm();
	}
	
	@Test(priority=1)
	public void validateSimpleFormDemoTitleTest() {
		String simpleFormDemoTitle = simpleFormObj.validateSimpleFormTitle();
		
		Assert.assertEquals(simpleFormDemoTitle, "Selenium Easy Demo - Simple Form to Automate using Selenium", "Title Not Matched");
	}
	
	@Test(priority=2)
	public void msgTest() {
		String outputMsg = simpleFormObj.validateMsg();
		
		Assert.assertEquals(outputMsg, "Hello", "Massege is not matching");
	}
	
	@DataProvider
	public Object[][] getSimpleFormTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=3, dataProvider="getSimpleFormTestData")
	public void sumTest(String sumA, String sumB) {
		String outputSum = simpleFormObj.validateAddition(sumA,sumB);
		
		Assert.assertEquals(outputSum, "30", "Addition is not displaying correct");
	}
	
	@Test(priority=4)
	public void navigateToCheckBoxDemoTest() {
		checkBoxObj = simpleFormObj.clickOnCheckBoxPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
