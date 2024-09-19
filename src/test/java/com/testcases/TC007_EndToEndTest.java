package com.testcases;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseTest;
import com.pom.AddToCartPage;
import com.pom.CheckoutPage;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;
import com.pom.RegisterPage;
import com.pom.SearchProductPage;
import com.pom.ShoppingCart;

import jdk.internal.org.jline.utils.Log;

public class TC007_EndToEndTest extends BaseTest{
	
	@Test(groups = {"master"})
	public void end_to_end_Test() throws InterruptedException
	{
		logger.info("@---***** TEST START BEGIN *****---@");
		
		// soft assertion
		SoftAssert myassert = new SoftAssert();
		
		// Home Page Registration
		logger.info("@---<< OPEN THE PAGE >>---@");
		HomePage hp = new HomePage(driver);
		hp.clik_MyAccount();
		hp.clik_Register();
		
		logger.info("@---<< REGISTRATION USER >>---@");
		RegisterPage rp = new RegisterPage(driver);
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		
		String email = randomString() + "@gamil.com";
		
		rp.setEmail(email);
		System.out.println("EMAIL : " + email);
		
		rp.setTelephone(randomNumeric());

		String password = randomAlphaNumeric();
		
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		System.out.println("PASSWORD : " + password);
		
		rp.checkPrivacyPolicy();
		rp.clickContinue();
		
		Thread.sleep(2000);
		
		String isDiplayedMsg = rp.getConfirmationMsg();
		System.out.println("MY-ACCOUNT-TITLE : " + isDiplayedMsg);
		
//		if(isDiplayedMsg.equals("Your Account Has Been Created!"))
		if(isDiplayedMsg.equals("Account"))
		{
			myassert.assertTrue(true);
		}else{
			logger.error("Error logs...");
			logger.debug("Debugs logs...");
			myassert.assertTrue(false);
		}
		
		MyAccountPage myacc = new MyAccountPage(driver);
		myacc.click_Logout();
		
		// back to home page and login
		hp.clik_MyAccount();
		logger.info("@---<< LOGOUT THE PAGE >>---@");
		hp.click_Login();
		
		logger.info("@---<< LOGIN THE PAGE >>---@");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		Thread.sleep(1000);
		lp.setPassword(password);
		Thread.sleep(1000);
		lp.clickLogin();
		
		Thread.sleep(2000);
		boolean existsAccount = myacc.chk_Heading();
		myassert.assertEquals(existsAccount, true);
		
		System.out.println("CHECKOUT TITLE : " + existsAccount);
		
		// search product
		logger.info("@---<< SEARCH PRODUCT >>---@");
		myacc.search_Product(properties.getProperty("searchItem"));
		myacc.search_Button();
		
		// verify & click product 
		logger.info("@---<< VERIFY PRODUCT >>---@");
		SearchProductPage searchItem = new SearchProductPage(driver);
		boolean existsProduct = searchItem.search_Product();
		
		myassert.assertEquals(existsProduct, true);
		
		System.out.println("PRODUCT : " + existsProduct);
		
		// click on product name 
		searchItem.click_Product();
		// navigate add to cart -> verify product page -> clear quantity -> enter quantity -> click Add to Cart button -> verify success alert message
		logger.info("@---<< NAVIGATE ADD TO CART & ADD PRODUCTS >>---@");
		AddToCartPage addPage = new AddToCartPage(driver);
		boolean productHeading = addPage.productHeading();
		
		myassert.assertEquals(productHeading, true);
		
		System.out.println("PRODUCT TITLE : " + productHeading);
		
		addPage.clear_Quantity();
		addPage.enterQuantity(properties.getProperty("enterQuantity"));
		addPage.click_AddToCart();
		
		myassert.assertEquals(addPage.alertSuccessAdd(), true);
		
		addPage.click_Shoppingcart(); 
		
		// navigate shopping cart -> verify total price
		logger.info("@---<< NAVIGATE TO SHOPPING CART PAGE VERIFY TOTAL CART PRICE >>---@");
		ShoppingCart sc = new ShoppingCart(driver);
		Thread.sleep(1000);
		String cartTotalPrice = sc.getCartTotalPrice();
		System.out.println("SHOPPING-CART-TOTAL-PRICE : $" + cartTotalPrice);
		myassert.assertEquals(cartTotalPrice, "$404.00");
		
		Thread.sleep(1000);
		sc.click_Checkout();
		
		// navigate checkout -> verify page
		logger.info("@---<< NAVIGATE TO CHECKOUT PAGE FILL ALL INFORNATION >>---@");
		CheckoutPage cp = new CheckoutPage(driver);
		
		Thread.sleep(2000);
		boolean checkoutHeading = cp.checkoutHeading();
		myassert.assertEquals(checkoutHeading, true);
		
		System.out.println("CHECKOUT TITLE : " + checkoutHeading);
		
		cp.setFirstname(randomString().toUpperCase());
		Thread.sleep(1000);
		cp.setLastname(randomString().toUpperCase());
		Thread.sleep(1000);
		cp.setCompanyname("OHP.Pvt.Ltd");
		Thread.sleep(1000);
		cp.setAddress1("Address1");
		Thread.sleep(1000);
		cp.setAddress2("Address2");
		Thread.sleep(1000);
		cp.setCity("Mumbai");
		Thread.sleep(1000);
		cp.setPostcode("401402");
		Thread.sleep(1000);
		cp.setCountry("United Kingdom");
		Thread.sleep(1000);
		cp.setState("Angus");	
		Thread.sleep(1000);
		cp.click_continueAddress();
		Thread.sleep(1000);
		cp.click_continueShippAddress();
		Thread.sleep(1000);
		cp.setCommentOrder("THANKS FOR CONFIRM MY ORDER...!");
		Thread.sleep(1000);
		cp.click_continueShippMethod();
//		cp.click_continueCOD();			// not useful
		Thread.sleep(1000);
		cp.click_continueAgree();
		Thread.sleep(1000);
		cp.click_continuePayMehtod();
		
		logger.info("@---<< SHOPPING CART VERIFY TOTAL CART PRICE >>---@");
		Thread.sleep(1000);
		String checkoutTotalPrice = cp.getCheckoutTotalPrice();
		System.out.println("CHECKOUT-TOTAL-PRICE : $" + checkoutTotalPrice);
		myassert.assertEquals(cartTotalPrice, "$409.00");
		
		Thread.sleep(1000);
		cp.click_confirmOrder();
		
		Thread.sleep(2000);
		boolean orderedSuccess = cp.orderSuccessHeading();
		Thread.sleep(1000);
		myassert.assertEquals(orderedSuccess, true);
		
		System.out.println("ORDER SUCCESS : " + orderedSuccess);
		
		logger.info("@---***** TEST PASS SUCCESSFULLY *****---@");
	}
	
	
}
