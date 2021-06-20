package com.seleniumeasy.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumeasy.qa.base.TestBase;
import com.seleniumeasy.qa.util.TestUtil;

public class CheckBoxDemo extends TestBase {
	
	//Page Factory
	@FindBy(xpath="//*[@id=\\\"easycont\\\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")
	WebElement option1CheckBox;	
	
	@FindBy(xpath="//*[@id=\\\"easycont\\\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
	WebElement option2CheckBox;	
	
	@FindBy(xpath="//*[@id=\\\"easycont\\\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")
	WebElement option3CheckBox;	
	
	@FindBy(xpath="//*[@id=\\\"easycont\\\"]/div/div[2]/div[2]/div[2]/div[4]/label/input")
	WebElement option4CheckBox;	
	
	@FindBy(xpath="//*[@id=\"check1\"]")
	WebElement selectAllButton;
	
	@FindBy(xpath="//*[@id=\"treemenu\"]/li/ul/li[1]/a")
	WebElement inputFormPicker;
	
	@FindBy(xpath="//*[@id=\"treemenu\"]/li/ul/li[1]/ul/li[3]/a")
	WebElement radioButtonPicker;
	
	
	public CheckBoxDemo() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean clickOnOption1() {
		TestUtil.scrollPageDown(driver);
		option1CheckBox.click();
		boolean b = option1CheckBox.isSelected();
		
		return b;
	}
	
	public boolean voidCheckAll() {
		TestUtil.scrollPageDown(driver);
		selectAllButton.click();
		
		if(option1CheckBox.isSelected()==true && option2CheckBox.isSelected()==true && option3CheckBox.isSelected()==true && option4CheckBox.isSelected()==true) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public RadioButtonDemo clickOnRadioButtonPage() {
		inputFormPicker.click();
		radioButtonPicker.click();
		
		return new RadioButtonDemo();
	}
	

}
