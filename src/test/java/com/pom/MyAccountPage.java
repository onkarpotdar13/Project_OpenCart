package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(xpath = "//h2[normalize-space()='My Account']")
	WebElement msg_Heading;
	
	@FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement lnk_logout;
	
	// check tablet items
	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]")
	WebElement lnk_Tablet;


	// action methods

	public boolean chk_Heading() 
	{

		try {
			return msg_Heading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	public void click_Logout() 
	{
		lnk_logout.click();
	}
	
	// check tablet items
	public void click_Tablet() {
		lnk_Tablet.click();
	}

}
