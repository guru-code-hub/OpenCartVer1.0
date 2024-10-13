package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountsPage extends BasePage {

	public MyAccountsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"account-account\"]/div[1]/div/p")
	WebElement msgHeading;
	
	@FindBy(xpath = "//*[@id=\"navbar-collapse-header\"]/div/a[2]")
	WebElement btnLogout;
	
	public void clickLogoutButton() {
		btnLogout.click();
	}

	public boolean isMyAccountPageExists() {

		try {
			return (msgHeading.isDisplayed());
		}

		catch (Exception e) {
			return false;
		}
	}

}
