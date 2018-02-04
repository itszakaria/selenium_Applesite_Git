package Utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LinkStatus_separateReport {
	private WebDriver driver;
	private String baseUrl;

	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C://users//rahana//downloads//chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "http://www.google.com/";

		driver.get(baseUrl);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}

	@Test
	public void linkStatus() {
		
		
		List<WebElement> linksList = clickableLinks(driver);
		List<String> listWithNotOKStatus = new ArrayList<String>();
		List<String> listWithOKStatus = new ArrayList<String>();
		
		for (WebElement link : linksList) {
			String href = link.getAttribute("href");
			try {
				if (!linkStatus(new URL(href)).equals("OK")) {
					// This list will have URLs with status other than OK
					listWithNotOKStatus.add(href);
					System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
				} /*else {
					// This list will have URLs with status OK
					listWithOKStatus.add(href);
					System.out.println("URL " + href + " returned " + linkStatus(new URL(href)));
				}*/
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linksToClick = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));
		
		for (WebElement e : elements) {
			if (e.getAttribute("href") != null) {
				linksToClick.add(e);
			}
		}
		return linksToClick;
	}
	
	public static String linkStatus(URL url) {
		// http://download.java.net/jdk7/archive/b123/docs/api/java/net/HttpURLConnection.html#getResponseMessage%28%29
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			String responseMessage = http.getResponseMessage();
			http.disconnect();
			return responseMessage;
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public static int linkCode(URL url) {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			int responseCode = http.getResponseCode();
			http.disconnect();
			return responseCode;
		}
		catch (Exception e) {
			return 404;
		}
	}
	
	@AfterClass
	public void tearDown() throws Exception {
	}

}
