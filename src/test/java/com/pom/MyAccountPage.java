package com.pom;

import org.openqa.selenium.By;
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

	// for select category only specific name(locator) like -> 'Tablets'
//	@FindBy(xpath = "//ul[@class='nav navbar-nav']//a[contains(text(),'Tablets')]")
//	WebElement lnk_Tablet;

	// for select drop down category only specific name(locator) like -> 'Desktops'
//		@FindBy(xpath = "//a[@class='dropdown-toggle'][normalize-space()='Desktops']")
//		WebElement dropdown_Item;

	// Dynamic locator method to select(items) specific category based on provided category name /
	// also select drop down category based on provided drop down category name
	public WebElement getCategoryElement(String categoryName) {
		return driver
				.findElement(By.xpath("//ul[@class='nav navbar-nav']//a[contains(text(),'" + categoryName + "')]"));
	}

	// select specific drop down for Mac Item
//	@FindBy(xpath = "//a[normalize-space()='Mac (1)']")
//	WebElement dropDown_MacItem;

	// Dynamic locator method to select a sub-category drop down based on provided
	// name
	public WebElement getDropDownSubCategoryElement(String dropDownSubCategoryName) {
		return driver.findElement(By.xpath("//a[normalize-space()='" + dropDownSubCategoryName + "']"));
	}

	// search items
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement search_Items;

	// click search button
	@FindBy(xpath = "//button[@class='btn btn-default btn-lg']")
	WebElement search_Button;

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

//	// specific check product items like -> Tablet items
//	public void click_Tablet() {
//		lnk_Tablet.click();
//	}

	// click on the dynamic category link
	public void click_Category(String categoryName) {
		WebElement categoryElement = getCategoryElement(categoryName);
		categoryElement.click();
	}

	// search item
	public void search_Product(String product) {
		search_Items.sendKeys(product);
	}

	// search button
	public void search_Button() {
		search_Button.click();
	}

	// click on specific drop down category link
//	public void click_DropDown() {
//		dropdown_Item.click();
//	}

	// click on dynamic drop down category link
	public void click_DropDown(String categoryName) {
		WebElement categoryElement = getCategoryElement(categoryName);
		categoryElement.click();
	}

	// click on specific drop down sub-category link
//	public void click_Mac_DropDown() {
//		dropDown_MacItem.click();
//	}

	// click on the dynamic sub-category item
	public void click_SubCategory(String subCategoryName) {
		WebElement subCategoryElement = getDropDownSubCategoryElement(subCategoryName);
		subCategoryElement.click();
	}

}
