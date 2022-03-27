package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class ShippingAddressPage extends BaseClass{

	@FindBy(xpath = "//input[@id='ctl00_cpBody_lvCustomerAdd_ctrl0_btnUseAddress']")
	WebElement deliverToAddress;
	
	public ShippingAddressPage() {
		PageFactory.initElements(setDriver(), this);
	}
	
	public ReviewOrderPage clickOnDeliverToAddress() {
		Action.click(setDriver(), deliverToAddress);
		return new ReviewOrderPage();
	}
}
