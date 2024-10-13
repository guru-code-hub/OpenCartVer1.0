package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountsPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups = {"Sanity", "Master"})
	public void verify_AccountLogin() {
		try {

			logger.info("*** Starting TC002_AccountLoginTest ***");
			HomePage hp = new HomePage(driver);
			hp.clickLogin();

			LoginPage lp = new LoginPage(driver);
			lp.setEmailAddress(p.getProperty("email"));
			lp.setPassWord(p.getProperty("password"));
			lp.clickLoginButton();
			lp.clickLoginButton();

			MyAccountsPage mp = new MyAccountsPage(driver);

			boolean targetPage = mp.isMyAccountPageExists();

			Assert.assertEquals(targetPage, true, "Login Failed");
		}

		catch (Exception e) {
			Assert.fail();
		}
		logger.info("*** Finish TC002_AccountLoginTest ***");
	}
	
}