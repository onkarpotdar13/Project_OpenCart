package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;
import com.pom.SearchProductPage;

public class TC004_SearchProductTest extends BaseTest{
	
	
	@Test(groups = {"sanity","master"})
	public void search_Item() {
		
		logger.info("*** START THE <-- TC004_SearchItemTest --> TEST ***");
		
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
			
			
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** FINISH THE <-- TC004_SearchItemTest --> TEST ***");
	}

}
