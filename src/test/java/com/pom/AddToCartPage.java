package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class AddToCartPage extends BasePage{

	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	// locators 
	
	@FindBy(xpath = "//h1[normalize-space()='iPhone']")
	WebElement chk_Heading;
	
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement qyt_Clear;
	
	@FindBy(xpath = "//input[@id='input-quantity']")
	WebElement qyt_Enter;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	WebElement btn_AddToCart;
	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alt_SuccessAdd;
	
	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	WebElement lnk_Checkout;
	
	// action methods

	public boolean productHeading() {
		try {
			return chk_Heading.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void clear_Quantity() {
		qyt_Clear.clear();
	}
	
	public void enterQuantity(String quantity) {
		
		qyt_Enter.sendKeys(quantity);
	}
	
	public void click_AddToCart() {
		btn_AddToCart.click();
	}
	
	public boolean alertSuccessAdd() {
		try {
			return alt_SuccessAdd.isDisplayed();
		}catch(Exception e) {
			return false;
		}
	}
	
	public void click_Checkout() {
		lnk_Checkout.click();
	}
	
	
}
