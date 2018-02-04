package TestCases;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.MusicPage;
import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.ScanThisPage;
import Utilities.TestBase_Grid;

public class MusicPageTesting_GridTesting extends TestBase_Grid{
	
	@Test
	public void pageAuthenticationWithLocalGrid() throws Exception {
		driver = getDriverInstance01();
		mp = PageFactory.initElements(driver, MusicPage.class);

		stp = new ScanThisPage(driver);
		mp = new MusicPage(driver);
		ot = new Others(driver);
		
		
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(MusicPageTesting_GridTesting.class.getName());
		report = ExtentFactory.getInstance("AppleMusicPageTesting");
		elog = report.startTest("Apple watch Page Testing");

		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		mp.clickOnMusicLink();

		stp.showPageScanResult();

		// ot.returnCurrenetPageHrefs(driver);

		// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Test executed on remote node with chrome");
		
	}
	
	@Test
	public void pageAuthenticationWithRemoteGrid() throws Exception {
		driver = getDriverInstance02();
		mp = PageFactory.initElements(driver, MusicPage.class);

		stp = new ScanThisPage(driver);
		mp = new MusicPage(driver);
		ot = new Others(driver);
		
		
		baseUrl = "http://www.apple.com/";
		log = LogManager.getLogger(MusicPageTesting_GridTesting.class.getName());
		report = ExtentFactory.getInstance("AppleMusicPageTesting");
		elog = report.startTest("Apple watch Page Testing");

		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		mp.clickOnMusicLink();

		stp.showPageScanResult();

		ot.returnCurrenetPageHrefs(driver);

		// ls.getLinkStatus();
		elog.log(LogStatus.PASS, "Test executed on local node with edge");
		
	}


}
