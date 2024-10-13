package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	/*
	 * Data is valid - login success - test pass - logout Data is valid - login
	 * failed - test fail
	 * 
	 * Data is invalid - login success - test fail - logout Data is invalid - login
	 * failed - test pass
	 */
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups = "Datadriven")
	public void verify_AccountLoginDDT(String email, String pwd, String exp) {
		try {

			logger.info("*** Starting TC003_LoginTest DDT ***");
			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(email);
			lp.setPassWord(pwd);
			lp.clickLoginButton();

			MyAccountsPage mp = new MyAccountsPage(driver);

			boolean targetPage = mp.isMyAccountPageExists();

			// Assert.assertEquals(targetPage, true, "Login Failed");
			if (exp.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					mp.clickLogoutButton();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			if (exp.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					mp.clickLogoutButton();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finish TC003_LoginTest DDT ***");
	}
}