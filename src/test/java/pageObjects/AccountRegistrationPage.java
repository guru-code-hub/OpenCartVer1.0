package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//*[@id=\"input-username\"]")
	WebElement regUserName;

	@FindBy(xpath = "//*[@id=\"input-firstname\"]")
	WebElement regFirstName;

	@FindBy(xpath = "//*[@id=\"input-lastname\"]")
	WebElement regLastName;

	@FindBy(xpath = "//*[@id=\"input-email\"]")
	WebElement regEmail;

	@FindBy(xpath = "//*[@id=\"input-country\"]")
	WebElement regCountry;

	@FindBy(xpath = "//*[@id=\"input-password\"]")
	WebElement regPassword;

	@FindBy(xpath = "")
	WebElement msgConfirmation;

	public void setUserName(String usrname) {
		regUserName.sendKeys(usrname);
	}

	public void setFirstName(String fname) {
		regFirstName.sendKeys(fname);
	}

	public void setLastname(String lname) {
		regLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		regEmail.sendKeys(email);
	}

	public void setCountry() {
		regCountry.sendKeys("");
	}

	public void setPassword() {
		regPassword.sendKeys("");
	}

	public String getConfirmationMsg() {

		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
