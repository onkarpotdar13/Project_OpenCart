package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class DropDownPage extends BasePage{

	public DropDownPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	@FindBy(xpath = "//h2[normalize-space()='Mac']")
	WebElement dropDown;
	
	// action method
	
	public boolean dropDown_Heading() {
		
		try {
			return dropDown.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}

}
