package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class SearchProductPage extends BasePage{

	public SearchProductPage(WebDriver driver) {
		super(driver);
	}
	
	// locators
	
	// check search_Heading
	@FindBy(xpath = "//h1[contains(normalize-space(),'Search - ')]")
	WebElement search_Heading;
	
	// add to cart click product
	@FindBy(xpath = "//div[@class='caption']//a[contains(text(),'iPhone')]")
	WebElement click_Product;
	
	
	// action
	
	// check search_Heading
	public boolean search_Product() {
		
		try {
			return search_Heading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	// add to cart click product
	public void click_Product() {
		click_Product.click();
	}

}
