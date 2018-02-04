package TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.MacBookAirPageFacotory;
import PageClassses.MacBookProPF;
import PageClassses.MacLinkPageFactory;
import Utilities.*;
import junit.framework.Assert;

public class MacBookProPageTesting extends TestBase{

	@Test(groups = {"macBook"})
	public void pageAuthentication() throws InterruptedException, IOException {
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(MacBookProPageTesting.class.getName());
		report = ExtentFactory.getInstance("AppleMacBookProPageTesting");
		elog = report.startTest("Apple macBook Pro Page Testing getting started.");
		
		
		
		driver.get(baseUrl);
		elog.log(LogStatus.INFO, "Opened the Application");
		
		mpf.clickMacAtMenubar(elog);
		String homePageTitle = driver.getTitle();

		String currentUrl = driver.getCurrentUrl();
		elog.log(LogStatus.INFO, "We are on '" + currentUrl + "' now.");

		try {
			String linksHref = Others.returnHref(MacBookProPF.retMacBookPro());
			// click on macbook air link
			mbpf.clickOnmacBookPro();

			String thisPageTitle = driver.getTitle();

			if (homePageTitle != thisPageTitle) {
				elog.log(LogStatus.PASS, "control is on '" + linksHref + "' page now !!");

				// another way:
				String currentPageUrl = driver.getCurrentUrl();
				elog.log(LogStatus.PASS, "control is on '" + currentPageUrl + "' page now !!");
			}
		} catch (Exception e) {
			e.getMessage();
		}
		
		
		// Show the scan report
		/** This will provide a basic idea of mechanism we need to take 
		 * 	to test this page.
		 * */
		stp.showPageScanResult();
				

		// show links with the staus results otehr than OK.
// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");

	}

	@Test(enabled = true, priority = 1)
	public void someOtherFunctions() throws IOException, InterruptedException, AWTException {

		// click on video link : Watch the design film
		mbpf.clickOnVideoLink();
		elog.log(LogStatus.INFO, "Clicked on video link");

		// add ss to report
		String path = Screenshot.returnScreenshotPathForAdvReport(driver, "ApplemacBookProVideoPlay");
		String imagePAth = elog.addScreenCapture(path);
		elog.log(LogStatus.INFO, "Clicked on video link", imagePAth);
		elog.log(LogStatus.INFO, "Image attached, Video is palying");

		// click on pause button
		Thread.sleep(5000);
		try {

			mbpf.clickOnPauseButton();
			elog.log(LogStatus.INFO, "Clicked on video pause button!!");
		} catch (Exception e) {
			mbpf.clickOnCloseButton();
			elog.log(LogStatus.INFO, "Clicked on video close button!!");

		}

		// click on slider button
		try {
			Actions act = new Actions(driver);
			act.dragAndDropBy(mbpf.retSlider(), 175, 0).perform();
			elog.log(LogStatus.PASS, "Moved progress bar on the video player.");
		} catch (Exception e) {
			// System.out.println(e.getMessage());
		}

		try {
			WebElement thirteenInch = driver.findElement(By.xpath("//*[@id='gallery-item-1-trigger']/p"));
			Assert.assertNotNull(thirteenInch);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// scroll into element
		try {
		WebElement macBookProCompare = driver
				.findElement(By.xpath("//*[@id='main']/section[4]/section/div[1]/div[5]/div[2]/div[3]/figure[1]/h5"));
		js.executeScript("arguments[0].scrollIntoView(true);", macBookProCompare);
		}catch(Exception e) {
		// sometimes above statement does not work
		js.executeScript("window.scrollBy(0,1800);");
		}

		elog.log(LogStatus.INFO, "We are at the bottom of the page");

		// take ss and add to report
		String path03 = Screenshot.returnScreenshotPathForAdvReport(driver, "Apple_macBookProAtBottom");
		String imagePath03 = elog.addScreenCapture(path03);
		elog.log(LogStatus.INFO, "Clicked on video link", imagePath03);
		elog.log(LogStatus.INFO, "Image attached, We are at bottom of this page");

	}

	@Test(enabled = true, priority = 3)
	public void takeMultiScreenshots() throws AWTException, IOException, InterruptedException {

		// go to top of the page and take multi sreenshots
		Robot rob = new Robot();

		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_HOME);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_HOME);
		elog.log(LogStatus.INFO, "Moved to the top of the page by ROBOT class");
		Thread.sleep(2000);

		ss.takeMultiSSofThisPage(driver, "macBookPro");

		elog.log(LogStatus.PASS, "This test has PASSED!!");
		
	}

}
