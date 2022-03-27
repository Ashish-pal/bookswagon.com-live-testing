package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.HomePage;
import pageObjects.Index;
import pageObjects.LoginPage;

public class HomepageTest extends BaseClass {
	Index indexpage;
	LoginPage loginPage;
	HomePage homePage;

	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) throws IOException {
		launchBrowser(browser);
	}

	@AfterMethod(groups = {"Smoke","Sanity","Regression"})
	public void tearDown() {
		setDriver().quit();
	}

	@Test(groups = "Smoke")
	public void verifyWishlist() {
		indexpage = new Index();
		loginPage = indexpage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.checkWishlist();
		Assert.assertTrue(result);
	}

	@Test(groups = "Smoke")
	public void verifyOrders() {
		indexpage = new Index();
		loginPage = indexpage.clickOnLogin();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		boolean result = homePage.MyOrders();
		Assert.assertTrue(result);
	}
}
