package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.base.BasePage;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// locators
	@FindBy(xpath = "//h1[normalize-space()='Checkout']")
	WebElement chk_Heading;

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	WebElement txt_Firstname;

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	WebElement txt_Lastname;

	@FindBy(xpath = "//input[@id='input-payment-company']")
	WebElement txt_Company;

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement txt_Address1;

	@FindBy(xpath = "//input[@id='input-payment-address-2']")
	WebElement txt_Address2;

	@FindBy(xpath = "//input[@id='input-payment-city']")
	WebElement txt_City;

	@FindBy(xpath = "//input[@id='input-payment-postcode']")
	WebElement txt_Postcode;

	@FindBy(xpath = "//select[@id='input-payment-country']")
	WebElement txt_Country;

	@FindBy(xpath = "//select[@id='input-payment-zone']")
	WebElement txt_State;

	@FindBy(xpath = "//input[@id='button-payment-address']")
	WebElement btn_payAddress;

	@FindBy(xpath = "//input[@id='button-shipping-address']")
	WebElement btn_shippAddress;

	@FindBy(xpath = "//input[@id='button-shipping-method']")
	WebElement btn_shippMethod;

//	@FindBy(xpath = "//input[@value='cod']")		// not useful
//	WebElement btn_COD;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btn_Agree;

	@FindBy(xpath = "//input[@id='button-payment-method']")
	WebElement btn_payMethod;

	@FindBy(xpath = "//input[@id='button-confirm']")
	WebElement btn_confirmOrder;

	@FindBy(xpath = "//h1[contains(normalize-space(),'Your order has been placed!')]")
	WebElement chk_successOrder;

	// action method

	public boolean checkoutHeading() {

		try {
			return chk_Heading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void setFirstname(String fName) {
		txt_Firstname.sendKeys(fName);
	}

	public void setLastname(String lName) {
		txt_Lastname.sendKeys(lName);
	}

	public void setCompanyname(String compName) {
		txt_Company.sendKeys(compName);
	}

	public void setAddress1(String address1) {
		txt_Address1.sendKeys(address1);
	}

	public void setAddress2(String address2) {
		txt_Address2.sendKeys(address2);
	}

	public void setCity(String city) {
		txt_City.sendKeys(city);
	}

	public void setPostcode(String pin) {
		txt_Postcode.sendKeys(pin);
	}

	public void setCountry(String country) {
		txt_Country.sendKeys(country);
	}

	public void setState(String state) {
		txt_State.sendKeys(state);
	}

	public void click_continueAddress() {
		btn_payAddress.click();
	}

	public void click_continueShippAddress() {
		btn_shippAddress.click();
	}

	public void click_continueShippMethod() {
		btn_shippMethod.click();
	}

//	public void click_continueCOD() {			// not useful
//		btn_COD.click();
//	}

	public void click_continueAgree() {
		btn_Agree.click();
	}

	public void click_continuePayMehtod() {
		btn_payMethod.click();
	}

	public void click_confirmOrder() {
		btn_confirmOrder.click();
	}

	public boolean orderSuccessHeading() {

		try {
			return chk_successOrder.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
