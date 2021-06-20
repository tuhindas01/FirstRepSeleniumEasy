package com.seleniumeasy.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.seleniumeasy.qa.base.TestBase;
import com.seleniumeasy.qa.pages.HomePage;
import com.seleniumeasy.qa.pages.SimpleFormDemo;

public class HomePageTest extends TestBase {
	
	HomePage home;
	SimpleFormDemo simpleFormObj;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {	
		initialization();
		home = new HomePage();
	}
	
	@Test(priority=1)
	public void HomePageTitleTest() {
		String title = home.validateHomePageTitle();
		Assert.assertEquals(title, "Selenium Easy - Best Demo website to practice Selenium Webdriver Online");
	}
	
	@Test(priority=2)
	public void SeleniumEasyLogoTest() {
		boolean logo = home.validateHomePageLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority=3)
	public void stratTest() throws InterruptedException {
		home.start();
	}
	
	@Test(priority=4)
	public void navigateSimpleFormToHome() throws InterruptedException {
		home.start();
		simpleFormObj = home.navigateSimpleForm();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
