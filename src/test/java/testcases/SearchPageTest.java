package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.BaseClass;
import pageObjects.Index;
import pageObjects.ShowSearchPage;

public class SearchPageTest extends BaseClass {
	Index indexpage;
	ShowSearchPage searchpage;

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
	public void showBookSearch() throws InterruptedException {
		indexpage = new Index();
		searchpage = indexpage.searchBooks("Rich Dad Poor Dad");
		boolean result = searchpage.bookAvailable();
		Thread.sleep(3000);
		Assert.assertTrue(result);
	}
}
