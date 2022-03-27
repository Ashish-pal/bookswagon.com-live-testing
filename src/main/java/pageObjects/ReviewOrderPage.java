package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class ReviewOrderPage extends BaseClass{

	@FindBy(xpath = "//input[@id='ctl00_cpBody_ShoppingCart_lvCart_savecontinue']")
	WebElement saveAndContinue;
	
	public ReviewOrderPage() {
		PageFactory.initElements(setDriver(), this);
	}

	public PaymentPage clickSaveOrder() {
		Action.click(setDriver(), saveAndContinue);
		return new PaymentPage();
	}
}
