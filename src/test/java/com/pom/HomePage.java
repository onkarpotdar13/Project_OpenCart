package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnk_Myaccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnk_Register;
	
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement lnk_Login;
	
	
	// action

	public void clik_MyAccount() {
		lnk_Myaccount.click();
	}

	public void clik_Register() {
		lnk_Register.click();
	}
	
	public void click_Login() {
		lnk_Login.click();
	}
	
	

}
