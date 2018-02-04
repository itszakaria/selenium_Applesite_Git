package Utilities;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

public class LinksStatus {

	WebElement element;
	static WebDriver driver;

	public LinksStatus(WebDriver driver) {
		this.driver = driver;
	}

	// to get the LIST of links and clickable links counts
	public static List<WebElement> clickableLinks(WebDriver driver) {
		List<WebElement> linkToList = new ArrayList<WebElement>();
		List<WebElement> elements = driver.findElements(By.tagName("a"));
		elements.addAll(driver.findElements(By.tagName("img")));

		int totalLinks = elements.size();
		System.out.println("Total link on this page are: " + totalLinks);

		for (WebElement element : elements) {
			if (element.getAttribute("href") != null)
				linkToList.add(element);
		}

		int totalClickableLinks = linkToList.size();
		System.out.println("Total clickable link on this page are: " + totalClickableLinks);
		System.out.println("");

		return linkToList;
	}

	// to get the URL response
	public static String linkStatus(URL url) throws IOException {
		String responseMsg = null;

		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.connect();
			responseMsg = http.getResponseMessage();
			return responseMsg;
		} catch (Exception E) {
			return E.getMessage();
		}

	}

	// To get the customised link status report

	public void getLinkStatus() {

		List<WebElement> linksList = LinksStatus.clickableLinks(driver);
		List<String> listWithNotOKStatus = new ArrayList<String>();
		List<String> listWithOKStatus = new ArrayList<String>();

		for (WebElement link : linksList) {
			String href = link.getAttribute("href");
			try {
				if (!LinksStatus.linkStatus(new URL(href)).equals("OK")) {
					// This list will have URLs with status other than OK
					listWithNotOKStatus.add(href);
					System.out.println("URL " + href + " returned " + LinksStatus.linkStatus(new URL(href)));
				} 
				
				
					 else { // This list will have URLs with status OK
					 listWithOKStatus.add(href); 
					 System.out.println("URL " + href + " returned " + linkStatus(new URL(href))); }
					 
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		// test.log(LogStatus.PASS, "counted the links, clickable links, and assessed the status");
	}

}
