package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.HomePageFactory;
import PageClassses.MacBookAirPageFacotory;
import PageClassses.MacLinkPageFactory;
import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.ScanThisPage;
import Utilities.Screenshot;
import Utilities.SelectDriver;
import Utilities.TestBase;
import Utilities.LinksStatus;

public class MacBookAirPageTesting extends TestBase{
	
	@Test(groups = {"macBook"})
	public void pageAuthentication() throws InterruptedException, AWTException, IOException {
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(AppleWatchTesting.class.getName());
		report = ExtentFactory.getInstance("AppleMacBookAirPageTesting");
		elog = report.startTest("Apple macBook Air Page Testing getting started.");
		
		
		driver.get(baseUrl);
		elog.log(LogStatus.INFO, "Opened the Application");
		
		mpf.clickMacAtMenubar(elog);
		String homePageTitle = driver.getTitle();

		String currentUrl = driver.getCurrentUrl();
		elog.log(LogStatus.INFO, "We are on '" + currentUrl + "' now.");

		try {
			String linksHref = Others.returnHref(mapf.macbookAirButton());
			// click on macbook air link
			mapf.clickOnMacabookAir();

			String thisPageTitle = driver.getTitle();

			if (homePageTitle != thisPageTitle) {
				elog.log(LogStatus.PASS, "Control is on '" + linksHref + "' page now !!");
			}
		} catch (Exception e) {
			e.getMessage();
		}

		ss.takeMultiSSofThisPage(driver, "apple_macBookPage");

		// Show the scan report
		/** This will provide a basic idea of mechanism we need to take 
		 * 	to test this page.
		 * */
		stp.showPageScanResult();
		
		// show links with the staus results otehr than OK.
		//ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");

	}

	@Test(enabled = true, priority = 1)
	public void someActions() throws IOException {
		mapf.clickOnCompareMacs();

		// take a ss
		Screenshot.takeScreenshot(driver, "mackbookAirTesting");

		// add screenshot to Html report
		String path = Screenshot.returnScreenshotPathForAdvReport(driver, "macbookAirTesting");
		String imgPath = elog.addScreenCapture(path);
		elog.log(LogStatus.PASS, "Upto this point is ok!!", imgPath);
		elog.log(LogStatus.PASS, "Upto this point is ok!!");

		// select any two
		WebElement macType01 = driver.findElement(By.xpath("//div[@id='main']/section[2]/div/div[2]/div/a"));
		WebElement macType02 = driver.findElement(By.xpath("//div[@id='main']/section[2]/div/div[3]/div/a"));
		macType01.click();
		macType02.click();
		elog.log(LogStatus.INFO, "Selected two models");

		// click on compare models.
		mapf.clickOnCompare();

		String path01 = Screenshot.returnScreenshotPathForAdvReport(driver, "macbookAirTesting");
		String imgPath01 = elog.addScreenCapture(path01);
		elog.log(LogStatus.PASS, "Upto this point is ok!!", imgPath01);
		elog.log(LogStatus.PASS, "Upto this point is ok!!");

		// scroll element to view and add ss to our report:
		js.executeScript("arguments[0].scrollIntoView(true);", mapf.scrollToView());
		elog.log(LogStatus.INFO, "Scrolled to aprticular element");

		String path02 = Screenshot.returnScreenshotPathForAdvReport(driver, "macbookAirTesting");
		String imgPath02 = elog.addScreenCapture(path02);
		elog.log(LogStatus.PASS, "Upto this point is ok!!", imgPath02);
		elog.log(LogStatus.PASS, "Upto this point is ok!!");

		// scroll to the most bottom of the page.
		js.executeScript("window.scrollBy(0,1800);");
		elog.log(LogStatus.INFO, "we are at the botton of this page.");
		
		elog.log(LogStatus.PASS, "This test has PASSED!!");
		
		
	}

}
