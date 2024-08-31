package com.testcases;

import org.testng.Assert; 
import org.testng.annotations.Test;

import com.base.BaseTest;
import com.pom.HomePage;
import com.pom.RegisterPage;

public class TC001_AccountRegistrationTest extends BaseTest {

	@Test(groups = {"regression","master"})
	public void verify_account_Registration() {
		
		logger.info("*** START THE <-- TC001_AccountRegistrationTest --> TEST ***");
		
		try {
		HomePage hp = new HomePage(driver);
		logger.info("Click on 'MyAccount' link..");
		hp.clik_MyAccount();
		logger.info("Click on 'Register' link..");
		hp.clik_Register();

		RegisterPage rp = new RegisterPage(driver);

		logger.info("Fill the all user required details here...");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString() + "@gamil.com");
		rp.setTelephone(randomNumeric());

		String password = randomAlphaNumeric();

		rp.setPassword(password);
		rp.setConfirmPassword(password);

		rp.checkPrivacyPolicy();
		rp.clickContinue();

		logger.info("Validate Password here...");
		String confmsg = rp.getConfirmationMsg();
		if(confmsg.equals("Your Account Has Been Created!"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Error logs...");
			logger.debug("Debugs logs...");
			Assert.assertTrue(false);
		}
		
//		Assert.assertEquals(confmsg, "Your Account Has Been Created!"); // validation
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
		logger.info("*** FINISH THE <-- TC001_AccountRegistrationTest --> TEST ***");

	}

}
