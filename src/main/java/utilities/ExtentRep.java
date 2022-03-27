package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentRep {

	public static ExtentHtmlReporter htmlReports;
	public static ExtentReports extentRep;
	public static ExtentTest test;

	public static void getExtent() {

		htmlReports = new ExtentHtmlReporter(System.getProperty("user.dir") + "/ExtentReport/" + "Ex-Report.html");
		htmlReports.loadXMLConfig(System.getProperty("user.dir") + "/extentReport.xml");
		//htmlReports.config().setTheme(Theme.DARK);

		extentRep = new ExtentReports();
		extentRep.attachReporter(htmlReports);

		extentRep.setSystemInfo("HostName", "Ashish");
		extentRep.setSystemInfo("ProjectName:", "Bookswagon.com Project");
		extentRep.setSystemInfo("Tested By:", "Ashish");
		extentRep.setSystemInfo("OS", "Windows 11 Home");
		extentRep.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extentRep.flush();
	}
}