package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class LoginPage extends BaseClass {

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtEmail']")
	WebElement userName;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_txtPassword']")
	WebElement passWord;

	@FindBy(xpath = "//input[@id='ctl00_phBody_SignIn_btnLogin']")
	WebElement clickLogIn;

	public LoginPage() {
		PageFactory.initElements(setDriver(), this);
	}

	public HomePage login(String usrname, String passwrd) {
		Action.type(userName, usrname);
		Action.type(passWord, passwrd);
		Action.click(setDriver(), clickLogIn);
		return new HomePage();
	}
	
	public ShippingAddressPage login1(String usrname, String passwrd) {
		Action.type(userName, usrname);
		Action.type(passWord, passwrd);
		Action.click(setDriver(), clickLogIn);
		return new ShippingAddressPage();
	}
}
