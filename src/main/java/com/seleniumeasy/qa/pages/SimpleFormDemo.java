package com.seleniumeasy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumeasy.qa.base.TestBase;

public class SimpleFormDemo extends TestBase {
	
	//Page Factory
	@FindBy(id="user-message")
	WebElement enterMsg;
	
	@FindBy(xpath="//*[@id=\"get-input\"]/button")
	WebElement showMsg;
	
	@FindBy(id="display")
	WebElement displayMsg;
	
	@FindBy(xpath="//*[@id=\"sum1\"]")
	WebElement sumA;
	
	@FindBy(xpath="//*[@id=\"sum2\"]")
	WebElement sumB;
	
	@FindBy(xpath="//*[@id=\"gettotal\"]/button")
	WebElement getTotal;
	
	@FindBy(id="displayvalue")
	WebElement sumTotal;
	
	@FindBy(xpath="//*[@id=\"treemenu\"]/li/ul/li[1]/a")
	WebElement inputFormPicker;
	
	@FindBy(xpath="//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[2]/a")
	WebElement inputCheckBoxPicker;	
	
	
	//Initializing Page object
	public SimpleFormDemo() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateSimpleFormTitle() {
		return driver.getTitle();
	}
	
	public String validateMsg() {
		enterMsg.sendKeys("Hi");
		showMsg.click();
		
		return displayMsg.getText();
	}
	
	public String validateAddition(String a, String b) {
		sumA.sendKeys(a);
		sumB.sendKeys(b);
		getTotal.click();
		
		return sumTotal.getText();
	}
	
	public CheckBoxDemo clickOnCheckBoxPage() {
		inputFormPicker.click();
		inputCheckBoxPicker.click();
		
		return new CheckBoxDemo();
	}

}
