package Utilities;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {

	public static ExtentReports getInstance(String testName) {
		ExtentReports extent;
		String proPath = System.getProperty("user.dir");
		String path = proPath+ "\\src\\test\\documentation\\" + testName + ".html";
		extent = new ExtentReports(path, false);
		
		extent 
			.addSystemInfo("Selenium Version", "3.11.0")
			.addSystemInfo("Platrm", "WINDOWS");
 
		return extent;
	}
}
