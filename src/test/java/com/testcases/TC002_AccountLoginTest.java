package com.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;

public class TC002_AccountLoginTest extends BaseTest {

	@Test(groups = {"sanity","master"})
	public void varify_account_Login() {

		logger.info("*** START THE <-- TC002_AccountLoginTest --> TEST ***");

		try {
			// Home Page
			logger.info(" <-- Home Page Action -->");
			HomePage hp = new HomePage(driver);
			hp.clik_MyAccount();
			hp.click_Login();

			// Login Page
			logger.info(" <-- Login Page Action -->");
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(properties.getProperty("email"));
			lp.setPassword(properties.getProperty("password"));
			lp.clickLogin();

			// MyAccount Heading Validate
			logger.info(" <-- MyAccount Page Action -->");
			MyAccountPage myaccPage = new MyAccountPage(driver);
			boolean chk_Heading = myaccPage.chk_Heading();
			Assert.assertTrue(chk_Heading);
			
		} catch (Exception e) {
			Assert.fail();
		}
		
		logger.info("*** FINISH THE <-- TC002_AccountLoginTest --> TEST ***");
	}
}
