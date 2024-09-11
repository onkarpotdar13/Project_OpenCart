package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.AddToCartPage;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;
import com.pom.SearchProductPage;

public class TC006_AddToCartTest extends BaseTest{
	
	@Test(groups = {"sanity","master"})
	public void add_to_cart_Products() 
	{
		
		logger.info("*** START THE <-- TC006_AddToCartTest --> TEST ***");
		
		try
		{
			logger.info(" <-- Home Page --> ");
			// step 1 : open application (Home Page)
			HomePage hp = new HomePage(driver);
			hp.clik_MyAccount();
			hp.click_Login();
			
			logger.info(" <-- Login Page --> ");
			// step 2 : login user (Login Page)
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(properties.getProperty("email"));
			lp.setPassword(properties.getProperty("password"));
			lp.clickLogin();
			
			logger.info(" <-- Search Item Option --> ");
			//step 3 : verify login page & click on tablet option
			MyAccountPage myaccPage = new MyAccountPage(driver);
			boolean chk_Heading = myaccPage.chk_Heading();
			Assert.assertTrue(chk_Heading);
			
			myaccPage.search_Product(properties.getProperty("searchItem"));
			myaccPage.search_Button();
			
			logger.info(" <-- Check Search Item --> ");
			// step 4 : verify search item
			SearchProductPage searchItem = new SearchProductPage(driver);
			boolean check_product = searchItem.search_Product();
			
			Thread.sleep(5000);
			Assert.assertEquals(check_product, true);
			
			searchItem.click_Product();
			logger.info(" <-- Add To Cart Process --> ");
			// step 5 : click on product name -> verify product page -> enter quantity -> click Add to Cart button -> verify success alert message
			AddToCartPage addPage = new AddToCartPage(driver);
			Thread.sleep(1000);
			boolean productHeading = addPage.productHeading();
			
			Thread.sleep(1000);
			Assert.assertTrue(productHeading);
			
			addPage.clear_Quantity();
			addPage.enterQuantity(properties.getProperty("enterQuantity"));
			Thread.sleep(1000);
			addPage.click_AddToCart();
			
			Thread.sleep(1000);
			boolean alert_heading = addPage.alertSuccessAdd();
			
			Assert.assertEquals(alert_heading, true);
		}
		catch(Exception e) {
			
			Assert.fail();
		}
	}

}
