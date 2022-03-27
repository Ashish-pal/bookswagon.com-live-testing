package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class Index extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement logIn;

	@FindBy(xpath = "//img[@id='ctl00_imglogo']")
	WebElement wagonLogo;

	@FindBy(id = "ctl00_TopSearch1_txtSearch")
	WebElement searchId;

	@FindBy(xpath = "//input[@id='ctl00_TopSearch1_Button1']")
	WebElement clickSearch;

	public Index() {
		PageFactory.initElements(setDriver(), this);
	}

	public LoginPage clickOnLogin() {
		Action.click(setDriver(), logIn);
		return new LoginPage();
	}

	public boolean showLogo() {
		return Action.isDisplayed(setDriver(), wagonLogo);
	}

	public String getUrlTitle() {
		String title = setDriver().getTitle();
		return title;
	}

	public ShowSearchPage searchBooks(String bookName) {
		Action.type(searchId, bookName);
		Action.click(setDriver(), clickSearch);
		return new ShowSearchPage();
	}
}
