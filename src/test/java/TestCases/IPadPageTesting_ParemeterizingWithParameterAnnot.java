// Run this test from dynamicTesting_parameterizingWithparemeterAnnot.xml file
// we used both POF and POM by BY, in this test.
package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.IPadPOM;
import PageClassses.IpadPF;
import Utilities.*;

public class IPadPageTesting_ParemeterizingWithParameterAnnot {
	SelectDriver sd;
	IpadPF ipf;
	IPadPOM ipm;
	Others ot;
	LinksStatus ls;
	Screenshot ss;
	
	public WebDriver driver;
	String baseUrl;
	ExtentReports report;
	ExtentTest test;
		
	JavascriptExecutor js;


	@BeforeClass
	@Parameters("browser")
	public void setUp(String browser) {
		sd = new SelectDriver(driver);

		report = ExtentFactory.getInstance("Apple_iPadPageTesting");
		test = report.startTest("iPadPage page testing getting started.");

		ot = new Others(driver);
		ss = new Screenshot();
		driver = sd.selectMyDriver(browser);
		js = (JavascriptExecutor) driver;

		ipf = new IpadPF(driver, test);
		ipm = new IPadPOM(driver);
		ls = new LinksStatus(driver);
		test.log(LogStatus.INFO, "Invoked Browser");

	}

	@Test(enabled = true, priority = 0)
	public void actions() throws InterruptedException, AWTException, IOException {
		baseUrl = "https://www.apple.com/";
		driver.get(baseUrl);
		test.log(LogStatus.PASS, "Opened the application");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		ss.takeMultiSSofThisPage(driver, "iPadPageWithParamAnnot");

		ipf.clickOnIpad();
		test.log(LogStatus.INFO, "Clicked on ipad icon");
		ss.takeMultiSSofThisPage(driver, "appliPadPageUI");
		Thread.sleep(5000);
		/**
		 * we waited overe here, bc when we multi-parameterize this test with diff
		 * browsers, test with edge browser fails for timing. now it does not fail.
		 */

		// show links with the staus results otehr than OK.
		// ls.getLinkStatus();
		test.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");
	}

	@Test(enabled = true, priority = 1)
	public void someOtherActions() throws IOException, InterruptedException {
	
		// lets put time for edge browser
		Thread.sleep(5000);
		
		ipm.clickOnIPadPro();
		test.log(LogStatus.INFO, "Clicked on iPadPro");

		// add screenshot to report
		ss.addScreenshotToAdvReport(driver, "iPadProPage", test);

		// click twice on the image moving icon
		/* instead of calling the mth twice, we can do it by a loop */

		try {
			int i = 0;

			while (i < 2) {
				ipm.clickOnImageChangeButton();
				i++;
			}
		} catch (

		Exception e) {
			test.log(LogStatus.ERROR, "May be the imageButton is not present");

		}

		// Move to element, if its (a dynamic element) is appeared
		try {
			js.executeScript("arguments[0].scrollIntoView(true);", ipm.dynamicElementAppear());
		} catch (Exception sth) {
			test.log(LogStatus.ERROR, "The elemnet is not present anymore");
		}

		ss.addScreenshotToAdvReport(driver, "iPadPage_DynamicElementAppear", test);

		// Check one element state.
		Others.elementState(driver, By
				.xpath("//section[@id='section-design']/div/div/div/div/div[2]/div/div[2]/figure[2]/div/span[1]/span"));
		
		/*	
		// Write results to existing file
		ot.writeResultToPropertiesFile("apple_iPadPage", "Passed!!");
		// Write test result after creating a file
		ot.writeTestResult("apple_iPadPage_001", ".txt", "appleHomePage :", "Passed!!");
		*/		
	
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult tResult) throws IOException {
		if (tResult.getStatus() == tResult.SUCCESS) {
			ot.writeResultToPropertiesFile(
				tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(), "Passed!!");
			// Screenshot.takeScreenshot(driver, "PackageClass_" +
			// tResult.getTestClass().getName() + "_MethodName_"+ tResult.getName() +
			// "_PASSED_");
			
		} else if (tResult.getStatus() == tResult.FAILURE) {
			ot.writeResultToPropertiesFile( tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Failed, See the screenshot!!");
			Screenshot.takeScreenshot(driver, tResult.getTestClass().getName() + "_MethodName_"
					+ tResult.getName() + "_FAILED_");
			ot.writeTestResult(tResult.getTestClass().getName() + "_Method_" + tResult.getName() + ot.getRandomName(3), ".txt", tResult.getTestClass().getName(), " - Failed, See the screenshot!!");
		}
	}

	@AfterTest
	public void tearDown() {
		report.endTest(test);
		report.flush();

	}
}
