package Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance(String testName) {
		ExtentReports extent;
		String path = "C:\\Users\\itszakaria\\workspace\\appleWebAppDefault\\src\\test\\documentation\\" + testName + ".html";
		extent = new ExtentReports(path, false);
		
		extent 
			.addSystemInfo("Selenium Version", "3.5.3")
			.addSystemInfo("Platrm", "WINDOWS");
 
		return extent;
	}
}
