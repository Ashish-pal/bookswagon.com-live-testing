package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.AddtoCartPage;
import pageObjects.Index;
import pageObjects.LoginPage;
import pageObjects.PaymentPage;
import pageObjects.ReviewOrderPage;
import pageObjects.ShippingAddressPage;
import pageObjects.ShowSearchPage;

public class CompleteTest extends BaseClass {
	Index indexpage;
	ShowSearchPage searchpage;
	AddtoCartPage addCartPage;
	LoginPage loginpage;
	ShippingAddressPage saddressPage;
	ReviewOrderPage reviewOrder;
	PaymentPage paytm;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		launchBrowser(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		setDriver().quit();
	}

	@Test(groups = "Regression")
	public void endtoEnd() throws InterruptedException {
		indexpage = new Index();
		searchpage = indexpage.searchBooks("Rich Dad Poor Dad");
		addCartPage = searchpage.clickonBuyNow();
		boolean result = addCartPage.verifyCart();
		// Assert.assertTrue(result);
		Thread.sleep(2000);
		loginpage = addCartPage.clickPlaceOrder();
		Thread.sleep(2000);
		saddressPage = loginpage.login1(prop.getProperty("username"), prop.getProperty("password"));
		reviewOrder = saddressPage.clickOnDeliverToAddress();
		paytm = reviewOrder.clickSaveOrder();
		paytm.clickOnPaybyCC();
		Thread.sleep(2000);
		paytm.clickOnPayPal();
		Thread.sleep(2000);
		String gettinURL = paytm.getPaymentURL();
		String expecteURL = "https://www.bookswagon.com/checkout.aspx";
		Assert.assertEquals(gettinURL, expecteURL);
	}
}