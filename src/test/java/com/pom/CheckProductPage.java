package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class CheckProductPage extends BasePage{

	public CheckProductPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//h2[normalize-space()='Tablets']")
	WebElement itm_Heading;
	
	// action method
	
	public boolean itm_Heading()
	{
		
		try {
			return itm_Heading.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
}
