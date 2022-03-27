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
import pageObjects.ShowSearchPage;

public class AddtoCartTest extends BaseClass {
	Index indexpage;
	ShowSearchPage searchpage;
	AddtoCartPage addCartPage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		launchBrowser(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		setDriver().quit();
	}

	@Test(groups = {"Sanity","Regression"})
	public void addCartTest() throws InterruptedException {
		indexpage = new Index();
		searchpage = indexpage.searchBooks("Rich Dad Poor Dad");
		addCartPage = searchpage.clickonBuyNow();
		boolean result = addCartPage.verifyCart();
		Assert.assertTrue(result);
		Thread.sleep(3000);
		addCartPage.clickPlaceOrder();
		Thread.sleep(3000);
	}
}
