package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.CheckProductPage;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;

public class TC003_SelectProductTest extends BaseTest {

	@Test(groups = { "sanity", "master" })
	public void check_Tablet_Items() {
		logger.info("*** START THE <-- TC003_CheckTabletItemsTest --> TEST ***");

		try {

			logger.info(" <-- Home Page --> ");
			// step 1 : open application(Home Page)
			HomePage hp = new HomePage(driver);
			hp.clik_MyAccount();
			hp.click_Login();

			logger.info(" <-- Login Page --> ");
			// step 2 : login user (Login Page)
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(properties.getProperty("email"));
			lp.setPassword(properties.getProperty("password"));
			lp.clickLogin();

			logger.info(" <-- Click Tablet Option --> ");
			// step 3 : verify login page & click on tablet option
			MyAccountPage myaccPage = new MyAccountPage(driver);
			boolean chk_Heading = myaccPage.chk_Heading();
			Assert.assertTrue(chk_Heading);

			myaccPage.click_Tablet();

			logger.info(" <-- Check Tablet Items --> ");
			// step 4 : check the tablet items
			CheckProductPage chkProduct = new CheckProductPage(driver);
			boolean itm_Heading = chkProduct.itm_Heading();

			Assert.assertTrue(itm_Heading);

		} catch (Exception e) {

			Assert.fail();
		}

		logger.info("*** FINICH THE <-- TC003_CheckTabletItemsTest --> TEST ***");
	}

}
