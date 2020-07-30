package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.MusicPage;
import PageClassses.AppleTV_regularPageClass;
import PageClassses.AppleWatchPF;
import PageClassses.HomePageFactory;
import PageClassses.IPhonePagePF;
import PageClassses.MacBookAirPageFacotory;
import PageClassses.MacBookProPF;
import PageClassses.MacLinkPageFactory;

public class TestBase_Cloud {
	protected WebDriver driver;
	protected ExtentReports report;
	protected ExtentTest test;
	// protected SelectDriver sd;
	protected DesiredCapabilities dc;
	protected String baseUrl;
	
	protected Others ot;
	protected LinksStatus ls;
	protected Screenshot ss;
	protected AppleTV_regularPageClass atv;
	

	@BeforeClass
	public void setUp() throws MalformedURLException {
		// sd = new SelectDriver(driver);
		try {
			Properties prop  = new Properties();
			// System.out.println("user.dir is \t: " + System.getProperty("user.dir"));
			
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(fis);
			String browserName = prop.getProperty("cloud01_browserName");
			String browserVersion = prop.getProperty("cloud01_browserVersion");
			
			dc = new DesiredCapabilities(browserName, browserVersion, Platform.WIN10);
			driver = new RemoteWebDriver(new URL("https://itsmoyna:101842fd-7117-4b3a-a1e9-1d2774cfea63@ondemand.saucelabs.com:443/wd/hub"), dc);
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		ot = new Others(driver);
		ls = new LinksStatus(driver);
		atv = new AppleTV_regularPageClass(driver);
		ss = new Screenshot();
		report = ExtentFactory.getInstance("appleTvPageTesting");
		test = report.startTest("TvPage Testing");
				
		test.log(LogStatus.INFO, "Invoked Browser!!");
		baseUrl = "https://www.apple.com/";
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult tResult) throws IOException {
		if (tResult.getStatus() == tResult.SUCCESS) {
			ot.writeResultToPropertiesFile(
					tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Passed!!");
			// Screenshot.takeScreenshot(driver, "PackageClass_" +
			// tResult.getTestClass().getName() + "_MethodName_"+ tResult.getName() +
			// "_PASSED_");
			
		} else if (tResult.getStatus() == tResult.FAILURE) {
			ot.writeResultToPropertiesFile(
				tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Failed, See the screenshot!!");
			Screenshot.takeScreenshot(driver, tResult.getTestClass().getName() + "_MethodName_"
					+ tResult.getName() + "_FAILED_");
			ot.writeTestResult(tResult.getTestClass().getName() + "_Method_" + tResult.getName(), ".txt", tResult.getTestClass().getName() , "Failed, See the screenshot!!");
		}
	}

	@AfterClass
	public void tearDown() {
		report.endTest(test);
		report.flush();
	}

}
