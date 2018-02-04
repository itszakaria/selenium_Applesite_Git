package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.Screenshot;
import Utilities.TestBase;

public class AppleWatchTesting extends TestBase {

	@Test
	public static void doTheBdInterviewThings() throws InterruptedException {
		report = ExtentFactory.getInstance("InterviewProject");
		elog = report.startTest("Bllomingdales Project got started.");
		elog.log(LogStatus.INFO, "Opened the Application");
		
		
		driver.get("https://www.bloomingdales.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		bh.writeOnWebElement("mens tie");
		Thread.sleep(2000);
		
		bh.clickOnSearchButton();
		
		bh.clickOnSortbyBox();
		
		Thread.sleep(2000);
		
		bh.selectHighLow();
		Thread.sleep(2000);
		
		bh.clickOnJustAnItem();
		
		Thread.sleep(10000);
	}
	
	@Test(enabled = false)
	public void pageAuthentication() throws AWTException, IOException {
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(AppleWatchTesting.class.getName());
		report = ExtentFactory.getInstance("AppleWatchPage");
		elog = report.startTest("Apple watch Page Testing getting started.");

		driver.get(baseUrl);
		elog.log(LogStatus.INFO, "Opened the Application");

		// Validate page title and add current page title in the report.
		String homePageTitle = driver.getTitle();

		String currentUrl = driver.getCurrentUrl();
		log.info("We are on '" + currentUrl + "' now.");

		try {
			String linksHref = Others.returnHref(aw.returnWatch());
			aw.clickOnWatch();

			String thisPageTitle = driver.getTitle();
			if (homePageTitle != thisPageTitle) {
				elog.log(LogStatus.PASS, "Control is on '" + linksHref + "' page now !!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		ss.takeMultiSSofThisPage(driver, "appleWatch");

		/**	This will provide a basic idea of mechanism we need to take to test this
		 * 	page.
		 */
		stp.showPageScanResult();

		/**	This will show the links status of this page that are NOT OK.
		 */
		// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");
	}

	@Test(enabled = false)
	public void someFuncs() throws AWTException, IOException, InterruptedException {

		Assert.assertTrue(aw.specificClock().isDisplayed());
		if (aw.specificClock() != null) {
			Dimension size = aw.specificClock().getSize();
			System.out.println("Element is present and the size is: " + size);
		}

		/**	After clicking an image, validate the presence of an web element.
		 * */
		ot.elementsExistanceAfterActions(By.xpath("//div[@id=\"main\"]/section[2]/div[2]/div[2]/div/div/p/a[1]"),
				By.xpath("//div[@id=\"main\"]/section[2]/div[2]/div/div[2]/figure"));

		// Step: click on appleWatch interactive gallery
		aw.clickInteractiveGallery();
		Screenshot.takeScreenshot(driver, "watch_interactiveGalleryInteraction01");
		Screenshot.takeScreenshot(driver, "watch_interactiveGalleryInteraction02");
		
		// close the gallery
		aw.closeIntGallery();

		// Scroll down to the bottom of the page
		js.executeScript("window.scrollBy(0,1800);");
		Screenshot.takeScreenshot(driver, "appleWatch_ScrolledBottom");
		log.info("Scrolled down the botton of the page");

		// click on buy
		aw.clickOnBuy();
		log.info("Clicked on Buy link.");

		try {
			Assert.assertTrue(aw.returnWatch01().isDisplayed());
			aw.clickOnWatch01();
			elog.log(LogStatus.INFO, "Clicked on a watch");
		} catch (Exception e) {
			elog.log(LogStatus.INFO, "Wanted to click on a watch, but its not present");
		}

		// Add screenshot to advance report
		Thread.sleep(3000);
		String path = Screenshot.returnScreenshotPathForAdvReport(driver, "appleParticularWatch");
		String imgpath = elog.addScreenCapture(path);
		elog.log(LogStatus.PASS, "Added ss to report", imgpath);

		// go back to previous page
		driver.navigate().back();

		elog.log(LogStatus.PASS, "Navigated to watch MAIN page!!");
 
		Thread.sleep(3000);
		String path01 = Screenshot.returnScreenshotPathForAdvReport(driver, "appleParticularWatch");
		String imgpath01 = elog.addScreenCapture(path01);
		elog.log(LogStatus.PASS, "Added ss to report", imgpath01);

		// click on watch series 2
		driver.navigate().forward();

		aw.clickOnwatchSeries2();
		elog.log(LogStatus.INFO, "Clicked on watch series 2");

		// move to that element
		js.executeScript("arguments[0].scrollIntoView(true);", aw.returnJustElement());

		// add screenshot to report
		ss.addScreenshotToAdvReport(driver, "appleWatchMain", elog);
		elog.log(LogStatus.PASS, "Yay!!! This test has passed");
		log.info("This test has PASSED!! and the report files have been created!!");
	}

}
