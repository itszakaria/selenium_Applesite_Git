package Utilities;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import PageClassses.AppleWatchPF;
import PageClassses.HomePageFactory;
import PageClassses.IPhonePagePF;
import PageClassses.MacBookAirPageFacotory;
import PageClassses.MacBookProPF;
import PageClassses.MacLinkPageFactory;
import PageClassses.SupportPF;

public class TestBase {
	public static WebDriver driver;
	public static SelectDriver sd;
	public static Screenshot ss;
	public static AppleWatchPF aw;
	public static LinksStatus ls;
	public static ScanThisPage stp;
	public static Others ot;
	public static String baseUrl;
	public static HomePageFactory hpf;
	public static IPhonePagePF ippf;
	public static MacLinkPageFactory mpf;
	public static MacBookAirPageFacotory mapf;
	public static MacBookProPF mbpf;
	public static SupportPF spf;

	public static Logger log;
	public static JavascriptExecutor js;

	public static ExtentReports report;
	public static ExtentTest elog;

	public static BlommingdalesHomepage bh;

	@BeforeClass(alwaysRun = true, groups = { "macBook" })
	public static void setUp() {
		sd = new SelectDriver(driver);
		driver = sd.invokeBrowser();
		// driver = sd.selectMyDriver("chrome");

		js = (JavascriptExecutor) driver;

		ss = new Screenshot();
		ls = new LinksStatus(driver);
		stp = new ScanThisPage(driver);
		ot = new Others(driver);
		aw = new AppleWatchPF(driver, elog);
		hpf = new HomePageFactory(driver, elog);
		ippf = new IPhonePagePF(driver, elog);
		mpf = new MacLinkPageFactory(driver, elog);
		mapf = new MacBookAirPageFacotory(driver, elog);
		mbpf = new MacBookProPF(driver, elog);
		spf = new SupportPF(driver, elog);
		bh = new BlommingdalesHomepage(driver);

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult tResult) throws IOException {
		if (tResult.getStatus() == tResult.SUCCESS) {
			ot.writeResultToPropertiesFile(tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Passed!!");
			// Screenshot.takeScreenshot(driver, "PackageClass_" +
			// tResult.getTestClass().getName() + "_MethodName_"+ tResult.getName() +
			// "_PASSED_");

		} else if (tResult.getStatus() == tResult.FAILURE) {
			ot.writeResultToPropertiesFile(tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Failed, See the screenshot!!");
			Screenshot.takeScreenshot(driver,
					tResult.getTestClass().getName() + "_MethodName_" + tResult.getName() + "_FAILED_");
			ot.writeTestResult(
					tResult.getTestClass().getName() + "_Method_" + tResult.getName() + "_" + ot.getRandomName(3),
					".txt", tResult.getTestClass().getName(), " - Failed, See the screenshot!!");
		}
	}

	@AfterClass(alwaysRun = true)
	public static void tearDown() {
		report.endTest(elog);
		report.flush();
	}

}
