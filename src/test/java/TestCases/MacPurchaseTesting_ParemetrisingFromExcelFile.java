package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import PageClassses.HomePageFactory;
import PageClassses.MacLinkPageFactory;
import Utilities.*;;



public class MacPurchaseTesting_ParemetrisingFromExcelFile {

	WebDriver driver = null;
	static XSSFWorkbook wb = null;
	static XSSFSheet sheet = null;
	public XSSFRow row;
	public static XSSFCell cell = null;

	FileInputStream fis;
	SelectDriver sd;
	HomePageFactory hpf;
	MacLinkPageFactory mpf;
	String baseUrl;
	ExtentReports report;
	ExtentTest test;
	ScanThisPage stp;
	Others ot;
	JavascriptExecutor js;
	String projectLocation = System.getProperty("user.dir");
	
	@BeforeClass
	public void setUp() throws IOException {
		fis = new FileInputStream( projectLocation + 
				"\\src\\test\\resources\\parameterizingFromExternalSource.xlsx");
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("browsersList");

		baseUrl = "http://www.apple.com/";
		sd = new SelectDriver(driver);

		report = ExtentFactory.getInstance("apple_macPurchaseTesting");
		test = report.startTest("Macbook purchase steps Testing");

	}

	@DataProvider
	public Object[][] getData() {
		int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum() + 1;
		int colCount = sheet.getRow(0).getLastCellNum();

		Object testData[][] = new Object[rowCount - 1][colCount];

		for (int r = 2; r <= rowCount; r++) {
			for (int c = 0; c < colCount; c++) {
				testData[r - 2][c] = getCellData("credential", r, c);
				System.out.print(getCellData("credential", r, c) + " ");
			}
			System.out.println();
		}
		System.out.println();
		return testData;

	}

	@Test(dataProvider = "getData")
	public void dataParameterPOI(String browser) throws InterruptedException, IOException {

		driver = sd.selectMyDriver(browser);
		js = (JavascriptExecutor) driver;

		stp = new ScanThisPage(driver);
		hpf = new HomePageFactory(driver, test);
		mpf = new MacLinkPageFactory(driver, test);
		ot = new Others(driver);
		test.log(LogStatus.INFO, "Browser started");

		driver.manage().window().maximize();
		driver.get(baseUrl);
		test.log(LogStatus.INFO, "Opened the Application");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String homePageTitle = driver.getTitle();

		String currentUrl = driver.getCurrentUrl();
		test.log(LogStatus.INFO, "We are on homepage '" + currentUrl + "' now.");

		String linksHref = null;
		try {
			linksHref = Others.returnHref(hpf.macAtMenu());

			// click on mac link
			mpf.clickMacAtMenubar(test);

			String thisPageTitle = driver.getTitle();

			if (homePageTitle != thisPageTitle) {
				test.log(LogStatus.PASS, "Control is on '" + linksHref + "' page now !!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		Thread.sleep(3000);
		mpf.clickOnMacabook();

		mpf.clickOnBuy();

		try {
			// Select the capacity
			Thread.sleep(7000);
			mpf.selectCapacity();

			// click on View Gallery
			mpf.clickOnViewGallery();
			test.log(LogStatus.INFO, "Clicked on View Galley");
			test.log(LogStatus.PASS, "Counted the links, clickable links, and assessed the status");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult tResult) throws IOException {
		if (tResult.getStatus() == tResult.SUCCESS) {
			ot.writeResultToPropertiesFile(
					tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Passed!!");
			// Screenshot.takeScreenshot(driver, "PackageClass_" +
			// tResult.getTestClass().getName() + "_MethodName_"+ tResult.getName() +
			// "_PASSED_");
			
		} else if (tResult.getStatus() == tResult.FAILURE) {
			ot.writeResultToPropertiesFile(
					tResult.getTestClass().getName() + "_MethodName-" + tResult.getName(),
					"Failed, See the screenshot!!");
			Screenshot.takeScreenshot(driver, tResult.getTestClass().getName() + "_MethodName_"
					+ tResult.getName() + "_FAILED_");
			ot.writeTestResult(tResult.getTestClass().getName() + "_Method_" + tResult.getName() + "_" + ot.getRandomName(3), ".txt", tResult.getTestClass().getName() , "Failed, See the screenshot!!");
		}
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() {

		report.endTest(test);
		report.flush();
	}

	@SuppressWarnings("deprecation")
	public String getCellData(String sheetName, int rNum, int cNum) {

		row = sheet.getRow(rNum - 1);
		cell = row.getCell(cNum);

		if (cell.getCellType() == Cell.CELL_TYPE_STRING)

			return cell.getStringCellValue();
		else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {

			String cellText = String.valueOf(cell.getNumericCellValue());

			return cellText;
		} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
			return "There is no value in password field ";

		else
			return String.valueOf(cell.getBooleanCellValue());

	}

}
