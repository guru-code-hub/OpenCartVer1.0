package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement txtEmailAddress;

	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement txtPassWord;

	@FindBy(xpath = "//*[@id=\"account-login\"]/div[2]/div/div[1]/form/div[3]/div[1]/button[1]")
	WebElement btnLogin;

	public void setEmailAddress(String email) {
		txtEmailAddress.sendKeys(email);
	}
	
	public void setPassWord(String password) {
		txtPassWord.sendKeys(password);
	}
	
	public void clickLoginButton() {
		btnLogin.click();
	}
}
