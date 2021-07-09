package com.seleniumeasy.qa.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumeasy.qa.base.TestBase;
import com.seleniumeasy.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	//Page Factory - OR (Object Repository)
	@FindBy(xpath="//*[@id=\"btn_basic_example\"]")
	WebElement startButton;
	
	@FindBy(xpath="//*[@id=\"basic\"]/div/a[1]")
	WebElement simpleFormDem;
	
	@FindBy(xpath="//*[@id=\"basic\"]/div/a[2]")
	WebElement checkBoxDem;
	
	@FindBy(xpath="//*[@id=\"basic\"]/div/a[3]")
	WebElement radioButtonDem;
	
	@FindBy(xpath="//*[@id=\"basic\"]/div/a[4]")
	WebElement selectDropDownDem;
	
	@FindBy(xpath="//*[@id=\"basic\"]/div/a[5]")
	WebElement jsAlertsDem;
	
	@FindBy(xpath="//*[@id=\"site-name\"]/a")
	WebElement seleniumEasyLogo;
	
	@FindBy(id="at-cv-lightbox-close")
	WebElement addPopUpClose;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateHomePageLogo() {
		return seleniumEasyLogo.isDisplayed();
	}
	
	public void start() throws InterruptedException {
		
		addPopUpClose.click();
		Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> it = handler.iterator();
		String parentWindowId = it.next();
		driver.switchTo().window(parentWindowId);

		TestUtil.scrollPageDown(driver);
		startButton.click();
	}
	
	public SimpleFormDemo navigateSimpleForm() {
		simpleFormDem.click();
		return new SimpleFormDemo();
	}
	
	public CheckBoxDemo navigateCheckBox() {
		checkBoxDem.click();
		return new CheckBoxDemo();
	}
	
	public RadioButtonDemo navigateRadioButton() {
		radioButtonDem.click();
		return new RadioButtonDemo();
	}
	
	public SelectDropDownDemo navigateSelectDropDown() {
		selectDropDownDem.click();
		return new SelectDropDownDemo();
	}
	
	public JavaScriptsAlertsDemo navigateJsAlerts() {
		jsAlertsDem.click();
		return new JavaScriptsAlertsDemo();
	}
	
}
