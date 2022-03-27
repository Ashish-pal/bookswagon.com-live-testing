package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actionClass.Action;
import base.BaseClass;

public class ShowSearchPage extends BaseClass {

	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[2]/div[3]/div[2]/div[1]/div[3]/div[1]/a[1]")
	WebElement searchResult;
	
	@FindBy(xpath = "//body/form[@id='aspnetForm']/div[@id='site-wrapper']/div[2]/div[3]/div[2]/div[1]/div[4]/div[5]/a[1]/input[1]")
	WebElement clickFirstSearch;

	public ShowSearchPage() {
		PageFactory.initElements(setDriver(), this);
	}
	
	public boolean bookAvailable() {
		return Action.isDisplayed(setDriver(), searchResult);
	}
	
	public AddtoCartPage clickonBuyNow() {
		Action.click(setDriver(), clickFirstSearch);
		return new AddtoCartPage();
	}
}
