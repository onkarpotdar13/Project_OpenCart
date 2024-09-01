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

	// search items
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement search_Items;

	// click search button
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement search_Button;
	
	// drop down items
	@FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
	WebElement dropdown_Item;
	
	// drop down for Mac Item
	@FindBy(xpath = "//a[normalize-space()='Mac (1)']")
	WebElement dropDown_MacItem;

	// action methods

	public boolean chk_Heading() {

		try {
			return msg_Heading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void click_Logout() {
		lnk_logout.click();
	}

	// check tablet items
	public void click_Tablet() {
		lnk_Tablet.click();
	}

	// search item
	public void search_Item(String item) {
		search_Items.sendKeys(item);
	}

	// search button
	public void search_Button() {
		search_Button.click();
	}
	
	// drop down items
	public void click_DropDown() {
		dropdown_Item.click();
	}
	
	// drop down mac items
	public void click_Mac_DropDown() {
		dropDown_MacItem.click();
	}

}
