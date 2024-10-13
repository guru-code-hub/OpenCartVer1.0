package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups = {"Regression", "Master"})
	public void verify_account_registration() {
		try {

			logger.info("*** Starting TC001_AccountRegistrationTest ***");
			HomePage hp = new HomePage(driver);
			hp.clickRegister();
			// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
			regpage.setUserName(randomString().toUpperCase());
			regpage.setFirstName(randomString().toUpperCase());
			regpage.setLastname(randomString().toUpperCase());
			regpage.setEmail(randomString() + "@gmail.com");
			String confMsg = regpage.getConfirmationMsg();
			System.out.println(confMsg);
			Assert.assertEquals(confMsg, "");
			logger.info("*** Finished TC001_AccountRegistrationTest ***");

		}

		catch (Exception e) {
			logger.error("Test failed...");
			logger.debug("Debug logs...");
			Assert.fail();
		}
	}
}
