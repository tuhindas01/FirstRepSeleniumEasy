package com.seleniumeasy.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumeasy.qa.base.TestBase;
import com.seleniumeasy.qa.pages.CheckBoxDemo;
import com.seleniumeasy.qa.pages.HomePage;
import com.seleniumeasy.qa.pages.RadioButtonDemo;
import com.seleniumeasy.qa.pages.SimpleFormDemo;

public class CheckBoxDemoTest extends TestBase {
	
	HomePage home; 
	SimpleFormDemo simpleFormObj;
	CheckBoxDemo checkBoxObj;
	RadioButtonDemo radioButtonObj;
	
	public CheckBoxDemoTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		
		home = new HomePage();
		home.start();
		simpleFormObj = home.navigateSimpleForm();
		checkBoxObj = simpleFormObj.clickOnCheckBoxPage();
	}
	
	@Test(priority=1)
	public void selectSingleCheckBoxTest() {
		boolean checkBox1value = checkBoxObj.clickOnOption1();
		
		Assert.assertTrue(checkBox1value);
	}
	
	@Test(priority=2)
	public void selectAllCheckBoxTest() {
		boolean slectAllValue = checkBoxObj.voidCheckAll();
		
		Assert.assertTrue(slectAllValue);
	}
	
	@Test(priority=3)
	public void navigateToRAdioButtonDemoTest() {
		radioButtonObj = checkBoxObj.clickOnRadioButtonPage();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
