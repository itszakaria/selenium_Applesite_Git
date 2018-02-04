package TestCases;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExtentFactory;
import Utilities.Others;
import Utilities.TestBase;

public class Z_InterviewChecking extends TestBase {

	@Test
	public void pageAuthentication() throws InterruptedException, MalformedURLException, IOException {
		
		Select sel = new Select(driver.findElement(By.name("toppings")));
		
		
	}

	@Test(dependsOnMethods = "pageAuthentication")
	public void someOtherFunctions() throws AWTException, IOException, InterruptedException {

	
	
	}

}
