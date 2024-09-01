package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.DropDownPage;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;

public class TC005_DropDownProductTest extends BaseTest{

	@Test(groups = {"sanity","master"})
	public void dropdown_Items() {
		
		logger.info("*** START THE <-- TC005_DropDownProductTest --> TEST ***");
		
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
			
			myaccPage.click_DropDown();
			myaccPage.click_Mac_DropDown();
			
			logger.info(" <-- Drop Down Option --> ");
			DropDownPage ddp = new DropDownPage(driver);
			boolean dropDownDisplayed = ddp.dropDown_Heading();
			
			Assert.assertEquals(dropDownDisplayed, true);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** FINISH THE <-- TC005_DropDownProductTest --> TEST ***");
		
	}	

}
