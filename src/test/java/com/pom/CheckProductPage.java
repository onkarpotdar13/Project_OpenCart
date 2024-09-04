package com.pom;

import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class CheckProductPage extends BasePage {

	public CheckProductPage(WebDriver driver) {
		super(driver);
	}

	// locators for check specific product heading
//	@FindBy(xpath = "//h2[normalize-space()='Tablets']")
//	WebElement itm_Heading;
	
	// specific action method
	
//		public boolean itm_Heading()
//		{
//			
//			try {
//				return itm_Heading.isDisplayed();
//			}
//			catch(Exception e) {
//				return false;
//			}
//		}
	

	// Dynamic locator method to select category based on provided category name
	public WebElement getCategoryElement(String categoryName) {
		return driver.findElement(By.xpath("//h2[normalize-space()='" + categoryName + "']"));
	}

	// action method

	public boolean select_Category(String categoryName) {

		try {
			WebElement categoryElement = getCategoryElement(categoryName);
			categoryElement.click();
			return categoryElement.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
}
