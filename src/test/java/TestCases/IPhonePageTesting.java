package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.Screenshot;
import Utilities.TestBase;

public class IPhonePageTesting extends TestBase {

	@Test
	public void pageAuthentication() throws InterruptedException, MalformedURLException, IOException {
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(IPhonePageTesting.class.getName());
		report = ExtentFactory.getInstance("Apple_iPhonePage");
		elog = report.startTest("Apple iPhone Page Testing");

		driver.get(baseUrl);
		elog.log(LogStatus.INFO, "Opened the Application");

		String title = driver.getTitle();
		System.out.println("Title of this page is: " + title);
		System.out.println();

		// Click on Iphone link
		ippf.clickOnIPhone();
		elog.log(LogStatus.INFO, "Clicked on iPhone link");

		// getting link count and values.
		// Others.returnCurrenetPageHrefs(driver);
		elog.log(LogStatus.PASS, "Got the active href values.");

		// Show the scan report
		/**
		 * This will provide a basic idea of mechanism we need to take to test this
		 * page.
		 */
		stp.showPageScanResult();

		// show links with the staus results otehr than OK.
		// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");
	}

	@Test
	public void someOtherFunctions() throws AWTException, IOException, InterruptedException {

		ss.takeMultiSSofThisPage(driver, "AppleIphonePage");

		Others.elementState(driver, By.xpath("//div[@id='homepage-gallery']/nav[1]/ul/li[1]/button"));

		elog.log(LogStatus.INFO, "We chacked one particular webElements presence, display and enable status!!");

		ss.addScreenshotToAdvReport(driver, "AppleIphonePage", elog);

		elog.log(LogStatus.PASS, "This stest is PASSED!!");

	
	}

}
