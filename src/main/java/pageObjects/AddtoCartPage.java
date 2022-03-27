package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;


public class AddtoCartPage extends BaseClass {

	@FindBy(xpath = "//body/div[@id='colorbox']/div[@id='cboxWrapper']/div[2]/div[2]/div[1]/iframe[1]")
	WebElement MyShoppingCart;
	

	@FindBy(xpath = "//input[@id='BookCart_lvCart_imgPayment']")
	WebElement placeOrder;

	public AddtoCartPage() {
		PageFactory.initElements(setDriver(), this);
	}

	public boolean verifyCart() {
		Action.fluentWait(setDriver(), MyShoppingCart, 5);
		return Action.isDisplayed(setDriver(), MyShoppingCart);
	}
	
	public LoginPage clickPlaceOrder() {
		setDriver().get("https://www.bookswagon.com/shoppingcart.aspx?&pid=21258388&vid=3&ptype=1");
		Action.switchToFrameByName(setDriver(), "BookCart$lvCart$imgPayment");
		Action.click(setDriver(), placeOrder);
		Action.switchToDefaultFrame(setDriver());
		return new LoginPage();
	}
}
