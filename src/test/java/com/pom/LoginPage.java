package com.pom;

import com.base.BasePage;

import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	// locators
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_Password;
	
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btn_Login;
	
	// actions methods
	
	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}
	
	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_Login.click();
	}
}
