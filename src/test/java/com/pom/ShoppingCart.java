package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class ShoppingCart extends BasePage{ 

	public ShoppingCart(WebDriver driver) {
		super(driver);
	}

	
	// locators
	
	// for total price element in the cart
//    @FindBy(xpath = "//td[contains(@class, 'text-right')][last()]") 
	@FindBy(xpath = "//tbody//tr//td[6]")
    WebElement totalPrice;
	
	@FindBy(xpath = "//span[normalize-space()='Checkout']")
	WebElement lnk_Checkout;
	
	// action methods
	
	// to retrieve the total price from the cart
    public String getCartTotalPrice() {
        return totalPrice.getText().replace("$", "").trim();
    }
	
	public void click_Checkout() {
		lnk_Checkout.click();
	}
	
	
}
