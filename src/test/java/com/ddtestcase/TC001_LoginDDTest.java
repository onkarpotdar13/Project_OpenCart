package com.ddtestcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.HomePage;
import com.pom.LoginPage;
import com.pom.MyAccountPage;
import com.utilities.DataProviders;

public class TC001_LoginDDTest extends BaseTest{
	
	/*Data is valid - login success - test pass - logout	--> positive test
	  Data is valid - login failed  - test fail				--> negative test

      Data is invalid - login success - test fail - logout	--> negative test
	  Data is invalid - login failed  - test pass 			--> positive test
	*/
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = {"datadriven"}) // diff class/ pck data provider so that we can use dataProviderClass
	public void verify_LoginDDT(String email, String password, String remark) {
		
		logger.info("*** START THE <-- TC001_LoginDDTest --> TEST ***");
		
		try
		{
		logger.info(" <-- Home Page Action -->");
		HomePage hp = new HomePage(driver);
		hp.clik_MyAccount();
		hp.click_Login();

		// Login Page
		logger.info(" <-- Login Page Action -->");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clickLogin();

		// MyAccount Heading Validate
		logger.info(" <-- MyAccount Page Action -->");
		MyAccountPage myaccPage = new MyAccountPage(driver);
		boolean chk_Heading = myaccPage.chk_Heading();
		
		// validate here
		
		if(remark.equalsIgnoreCase("valid"))
		{
			if(chk_Heading==true)
			{
				myaccPage.click_Logout();
				Assert.assertTrue(true);
			}
			else {
				Assert.assertTrue(false);
			}
		}
		
		if(remark.equalsIgnoreCase("invalid"))
		{
			if(chk_Heading==true)
			{
				myaccPage.click_Logout();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
		
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		
		logger.info("*** FINISH THE <-- TC001_LoginDDTest --> TEST ***");
		
	}

}
