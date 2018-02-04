package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.TestBase;

public class Homepage extends TestBase {

	@Test
	public void pageAuthentication() throws InterruptedException, MalformedURLException, IOException {

		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(Homepage.class.getName());
		report = ExtentFactory.getInstance("AppleHomePage");
		elog = report.startTest("Apple Home Page Testing getting started.");

		driver.get(baseUrl);
		elog.log(LogStatus.INFO, "Opened the Application");

		
		// Step: take the landing UI screen shot.
		ss.takeScreenshot(driver, "Homepage_landingUI");
		
		
		// Step: Scan the page
		stp.showPageScanResult();

		
		// Step: Put some validation
		boolean flag = false;
		flag = hpf.appleIcon().isDisplayed();
		if (flag != true) {
			String title = driver.getTitle();
			System.out.println("Title of this page is: " + title);
		}else {
			System.out.println("WebElemenet is not displayed");
		}

		// Step: Show all the active links
		ot.returnCurrenetPageHrefs(driver);
		elog.log(LogStatus.PASS, "Got the active href values.");

		// Step: show links with the status results other than OK.
		// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");
	}

	@Test(dependsOnMethods = "pageAuthentication")
	public void someOtherFunctions() throws AWTException, IOException, InterruptedException {

		// check if some element is present and display the state of the element.
		Others.elementState(driver, By.xpath("//div[@id='homepage-gallery']/nav[1]/ul/li[1]/button"));
		elog.log(LogStatus.INFO, "We chacked one particular webElements presence, display and enable status!!");

		
		// Step: Change image by clicking right button
		try {
			ss.addScreenshotToAdvReport(driver, "Homepage_LandingLook", elog);
			hpf.clickOnGalleryLeftButton();
			elog.log(LogStatus.INFO, "Clicked on left button of gallery.");
			ss.addScreenshotToAdvReport(driver, "Homepage_AfterScrollingGallery", elog);
		} catch (Exception e) {
			if (!hpf.galleryLeftButton().isDisplayed()) {
				elog.log(LogStatus.ERROR, "May be the object is not present any more.");
				log.info("May be the object is not present any more.");
			}
		}

		
		
		// Count the links in the footer section, and make sure '' link is present.
		List<WebElement> footerLinks = hpf.footerSection().findElements(By.tagName("a"));
		System.out.println("Totals links in the footer section are: " + footerLinks.size());
		String expectedLink = "Financing";
		for (WebElement link : footerLinks) {
			if (link.getText().equals(expectedLink)) {
				System.out.println(expectedLink + " link is present!!");
			}
			System.out.println();
			break;
		}

		
		
		ss.takeMultiSSofThisPage(driver, "AppleHomePage");
		elog.log(LogStatus.PASS, "This test has passed!!");

	}

}
