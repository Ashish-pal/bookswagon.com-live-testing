package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import dataprovider.DatasProvider;
import pageObjects.HomePage;
import pageObjects.Index;
import pageObjects.LoginPage;
import utilities.Log4j;

public class LoginTest extends BaseClass {
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

	@Test(dataProvider = "credentialData", dataProviderClass = DatasProvider.class, groups = {"Sanity","Smoke"})
	public void loginTest(String uName, String pWord) throws InterruptedException {
		Log4j.startTestCase("LoginTest");
		indexpage = new Index();
		loginPage = indexpage.clickOnLogin();
		Log4j.info("user clicked on login");
		Thread.sleep(1000);
		//homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.login(uName, pWord);
		Log4j.info("user entered username and password");
		Thread.sleep(1000);
		String gettingURL = homePage.getCurrentURL();
		String expectedURL = "https://www.bookswagon.com/myaccount.aspx";
		Assert.assertEquals(gettingURL, expectedURL);
		Log4j.info("Login success done.");
		Log4j.endTestCase("loginTest");
	}
}
