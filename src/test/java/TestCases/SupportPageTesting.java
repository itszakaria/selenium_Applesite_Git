package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.SupportPF;
import Utilities.*;

public class SupportPageTesting extends TestBase{
	
	@Test
	public void pageStatus() throws IOException, InterruptedException{
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(SupportPageTesting.class.getName());
		report = ExtentFactory.getInstance("AppleSupportPage");
		elog = report.startTest("Apple Support Page Testing");
		
		
		//open the application and go to exact page
		driver.get(baseUrl);
		elog.log(LogStatus.INFO, "Opened the application and maximised the windows");
		
		// click on support icon
		spf.clickOnSupport();
		elog.log(LogStatus.INFO, "Clicked on support icon");
		
		// get the page status 1
		String currentPage = Others.returnHref(spf.retContactSupport());
		System.out.println("we are on '" + currentPage + "' page now !!");
		System.out.println();
		
		// add a ss
		ss.addScreenshotToAdvReport(driver, "supportPage", elog);
		
		// get the page status 2
		ot.returnCurrenetPageHrefs(driver);
		
		// get page links status
		//ls.getLinkStatus();
		
		// go to select "apple Watch" for watch support
		js.executeScript("arguments[0].scrollIntoView(true);", spf.returnAppleWatch());
		ss.addScreenshotToAdvReport(driver, "suuportPage_particularProductSupport", elog);
		
		
		elog.log(LogStatus.PASS, "This test has PASSED!!");
	}
	
	

}
