package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageClassses.MusicPage;
import PageClassses.AppleTV_regularPageClass;

public class TestBase_Grid {
	public static String baseUrl;
	public static String nodeURL01;
	// public static SelectDriver sd;
	public static ExtentReports report;
	public static ExtentTest elog;
	public static Others ot;
	public static LinksStatus ls;
	public static AppleTV_regularPageClass atv;
	public static ScanThisPage stp;
	public static DesiredCapabilities caps01;
	public static Logger log;

	protected WebDriver driver;
	protected MusicPage mp;

	public static String platform;
	public static String browser;
	public static String version;
	public static String url;

	

	public static WebDriver getDriverInstance01() throws MalformedURLException {
		String nodeURL01 = "http://192.168.1.2:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();

		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\itsza\\workspace\\appleWebAppDefault\\src\\test\\resources\\config.properties");
			prop.load(fis);

			platform = "Windows";
			browser = prop.getProperty("grid02_browserName");
			version = prop.getProperty("grid02_browserVersion");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Platforms
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}
		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		// Version
		caps.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeURL01), caps);
		// Maximize the browser's window
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open the Application
		// driver.get(url);
		return driver;
	}
	
	public static WebDriver getDriverInstance02() throws MalformedURLException {
		String nodeURL02 = "http://192.168.56.1:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();

		try {
			Properties prop = new Properties();
			FileInputStream fis = new FileInputStream(
					"C:\\Users\\itsza\\workspace\\appleWebAppDefault\\src\\test\\resources\\config.properties");
			prop.load(fis);

			platform = "Windows";
			browser = prop.getProperty("grid01_browserName");
			version = prop.getProperty("grid01_browserVersion");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// Platforms
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}
		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("edge")) {
			caps = DesiredCapabilities.edge();
		}
		// Version
		caps.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeURL02), caps);
		// Maximize the browser's window
		// driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open the Application
		// driver.get(url);
		return driver;
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
			ot.writeTestResult(tResult.getTestClass().getName() + "_Method_" + tResult.getName(), ".txt",
					tResult.getTestClass().getName(), "Failed, See the screenshot!!");
		}
	}

	@AfterClass
	public void tearDown() {
		report.endTest(elog);
		report.flush();
	}

}
