package Utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Others {
	WebDriver driver;

	public Others(WebDriver driver) {
		this.driver = driver;
	}

	public static String returnHref(WebElement element) {
		// href = null;
		// WebElement getElement = element;
		String href = element.getAttribute("href");
		return href;
	}

	public static String getRandomName(int length) {
		StringBuilder sb = new StringBuilder();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		for (int i = 0; i < length; i++) {
			// to get random character and getting the index of that character
			int index = (int) (Math.random() * characters.length());
			// appending character to our sb object
			sb.append(characters.charAt(index));
		}

		return sb.toString();

	}

	public void returnCurrenetPageHrefs(WebDriver driver) {
		List<WebElement> links = new ArrayList<WebElement>();

		List<WebElement> allAlinks = driver.findElements(By.tagName("a"));
		List<WebElement> allImgLinks = driver.findElements(By.tagName("img"));

		for (WebElement linklist : allAlinks) {
			if (linklist.getAttribute("href") != null) {
				links.add(linklist);
			}
		}

		for (WebElement linklist : allImgLinks) {
			if (linklist.getAttribute("href") != null) {
				links.add(linklist);
			}
		}

		System.out.println("Clickable Links in the pages are: " + links.size() + ", and their links are following:");

		for (WebElement link : links) {
			String linkText = link.getText();
			String href = link.getAttribute("href");

			System.out.printf("   %s's \t\t href value is: %s \n", linkText.trim(), href.trim());
		}
		System.out.println();

	}

	public static void elementState(WebDriver driver, By locator) {

		int elementSize = driver.findElements(locator).size();
		if (elementSize > 0) {
			System.out.println();
			System.out.println("The WebElement is present.");

			WebElement element = driver.findElement(locator);

			boolean isElementVisible = element.isDisplayed();
			if (isElementVisible == true) {
				System.out.println("The WebElement is visible.");
			} else if (isElementVisible == false) {
				System.out.println("The WebElement is NOT visible.");
			}

			boolean isElementEnabled = element.isEnabled();
			if (isElementEnabled == true) {
				System.out.println("The WebElement is enabled.");
				System.out.println();
			} else if (isElementEnabled == false) {
				System.out.println("The WebElement is NOT enabled.");
				System.out.println();
			}

		}

		System.out.println("The WebElement is NOT present.");
	}

	public void elementsExistanceAfterActions(By locator, By newLocator) throws InterruptedException {
		driver.findElement(locator).click();
		Thread.sleep(3000L);
		if (driver.findElement(newLocator).isDisplayed()) {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(newLocator)));

			System.out.println("Element with locator '" + newLocator + "' is present!!");
			driver.navigate().back();
		} else {
			driver.navigate().back();
		}

	}

	public void writeTestResult(String filename, String dotFormat, String testName, String testResult) {

		Formatter f = null;
		
		// Check the file's existence
		File x = new File(
				System.getProperty("user.dir")+"\\src\\test\\documentation\\" + filename + dotFormat);

		if (x.exists()) {
			System.out.println(x.getName() + " > : exist!!, sorry Give another name and try again");
			
		} else {
			//System.out.println(x.getName() + " > : does not exist!");

			try {
				f = new Formatter(
						System.getProperty("user.dir")+"\\src\\test\\documentation\\" + filename + dotFormat);
				System.out.println("We created a file named : " + filename + dotFormat);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("we got an error");
			}

			f.format("%s %s \n", testName, testResult);
			f.close();

		}

	}

	public void writeResultToPropertiesFile(String testName, String testResult) throws IOException {
		Properties prop = new Properties();
		OutputStream fos = new FileOutputStream(
				System.getProperty("user.dir")+"\\src\\test\\documentation\\testResult.properties", true);

		prop.setProperty(testName, testResult);
		prop.store(fos, null);
	}

}
