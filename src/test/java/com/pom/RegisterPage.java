package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// locators

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_Firstname;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_Lastname;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_Email;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txt_Telephone;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_Password;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txt_ConfimPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkd_Policy;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btn_Continue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msg_Confirmation;

	// action method

	public void setFirstName(String fName) {
		txt_Firstname.sendKeys(fName);
	}

	public void setLastName(String lName) {
		txt_Lastname.sendKeys(lName);
	}

	public void setEmail(String email) {
		txt_Email.sendKeys(email);
	}

	public void setTelephone(String telPhone) {
		txt_Telephone.sendKeys(telPhone);
	}

	public void setPassword(String password) {
		txt_Password.sendKeys(password);
	}

	public void setConfirmPassword(String password) {
		txt_ConfimPassword.sendKeys(password);
	}

	public void checkPrivacyPolicy() {
		chkd_Policy.click();
	}

	public void clickContinue() {
		// sol1
		btn_Continue.click();

		// alternative solutions one of we can use
		// btn_Continue.submit();
		// btn_Continue.sendKeys(org.openqa.selenium.Keys.RETURN);

	}

	public String getConfirmationMsg() {
		try {
			return (msg_Confirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
