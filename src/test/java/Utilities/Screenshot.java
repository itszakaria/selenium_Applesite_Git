package Utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.glass.events.KeyEvent;

public class Screenshot {

	// to take ss
	public static void takeScreenshot(WebDriver driver, String fileName) throws IOException {
		String path = "C:\\Users\\itszakaria\\workspace\\appleWebAppDefault\\src\\test\\documentation\\Screenshot\\";
		//String path = "screenshot//";
		String fName = fileName + "_" + Others.getRandomName(3) + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(path + fName));
	}
	
	// to return filepath of ss
	public static String returnScreenshotPathForAdvReport(WebDriver driver, String testName) throws IOException {
		String destination = null;

		String path = "C:\\users\\itszakaria\\workspace\\appleWebAppDefault\\src\\\\test\\documentation\\Screenshot\\";
		//String path = "screenshot//";
		String fName = testName + "_" + Others.getRandomName(5) + ".png";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(path + fName));
		
		destination = path + fName;
		return destination;
	}

	public void takeMultiSSofThisPage(WebDriver driver, String giveNameForSShot) throws AWTException, IOException {
		Robot rob = new Robot();

		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);

		takeScreenshot(driver, giveNameForSShot);

		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);

		takeScreenshot(driver, giveNameForSShot);

		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);

		takeScreenshot(driver, giveNameForSShot);

		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);

		takeScreenshot(driver, giveNameForSShot);

		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);
		rob.keyPress(KeyEvent.VK_PAGE_DOWN);
		rob.keyRelease(KeyEvent.VK_PAGE_DOWN);

		takeScreenshot(driver, giveNameForSShot);

	}
	
	
	public void addScreenshotToAdvReport(WebDriver driver, String imgName, ExtentTest test) throws IOException, InterruptedException{
		Thread.sleep(3000);
		String path = Screenshot.returnScreenshotPathForAdvReport(driver, imgName);
		String imgPath = test.addScreenCapture(path);
		test.log(LogStatus.PASS, "added ss to report", imgPath);
		test.log(LogStatus.INFO, "added ss to report");
	}

}
