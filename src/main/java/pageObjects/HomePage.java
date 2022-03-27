package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class HomePage extends BaseClass {

	@FindBy(linkText = "My Wishlist")
	WebElement myWishlist;
	
	@FindBy(linkText = "My Orders")
	WebElement myOrders;
	
	public HomePage() {
		PageFactory.initElements(setDriver(), this);
	}

	public boolean checkWishlist() {
		return Action.isDisplayed(setDriver(), myWishlist);
	}
	
	public boolean MyOrders() {
		return Action.isDisplayed(setDriver(), myOrders);
	}
	
	public String getCurrentURL() {
		String homePageURL = setDriver().getCurrentUrl();
		return homePageURL;
	}
}
