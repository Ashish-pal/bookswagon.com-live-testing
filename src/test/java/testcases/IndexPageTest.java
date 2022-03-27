package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.Index;

public class IndexPageTest extends BaseClass {
	Index indexpage;

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
	public void verifyLogo() {
		indexpage = new Index();
		indexpage.showLogo();
		boolean result = indexpage.showLogo();
		Assert.assertTrue(result);
	}

	@Test(groups = "Smoke")
	public void verifyTitle() {
		String title = indexpage.getUrlTitle();
		Assert.assertEquals(title, "Online Bookstore | Buy Books Online | Read Books Online");
	}
}
