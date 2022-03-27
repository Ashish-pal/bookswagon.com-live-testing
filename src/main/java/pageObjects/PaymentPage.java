package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class PaymentPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Pay Now')]")
	WebElement PaybyCC;

	@FindBy(xpath = "//a[contains(text(),'Paypal')]")
	WebElement PayPal;

	public PaymentPage() {
		PageFactory.initElements(setDriver(), this);
	}

	public void clickOnPaybyCC() {
		Action.click(setDriver(), PaybyCC);
	}

	public void clickOnPayPal() {
		Action.click(setDriver(), PayPal);
	}
	
	public String getPaymentURL() {
		String getPayURL = setDriver().getCurrentUrl();
		return getPayURL;
	}
}
