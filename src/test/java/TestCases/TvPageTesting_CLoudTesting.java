package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.AppleTV_regularPageClass;
import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.Screenshot;
import Utilities.SelectDriver;
import Utilities.TestBase_Cloud;
import Utilities.LinksStatus;

public class TvPageTesting_CLoudTesting extends TestBase_Cloud{
	
	
	@Test
	public void actionOnTvPage() throws InterruptedException, IOException{
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Opened the application");
				
		// click on TV Icon.
		atv.clickOnTvIcon();
		Thread.sleep(5000);
		
		ss.addScreenshotToAdvReport(driver, "TvPage_addSStoAdvReport", test);
				
		/*// to get the link status thats not expected
		Thread.sleep(4000);
		ls.getLinkStatus(); */
		
	
		test.log(LogStatus.PASS, "This test has PASSED!!");
		
		}


}
