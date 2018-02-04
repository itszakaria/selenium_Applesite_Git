package Utilities;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScanThisPage {
	static WebDriver driver;
	static List<WebElement> clickableLinksWithAnchorTAg = new ArrayList<WebElement>();

	public ScanThisPage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickableLinksCount() {
		List<WebElement> totalLinksWithAnchorTag = driver.findElements(By.tagName("a"));
		// Total A tags in this page
		// System.out.println("Total anchor tags in this page are: " +
		// totalLinksWithAnchorTag.size());

		List<WebElement> totalLinksWithImgTag = driver.findElements(By.tagName("img"));
		// Total img tags in this page
		// System.out.println("Total img tags in this page are: " +
		// totalLinksWithImgTag.size());

		for (WebElement a : totalLinksWithAnchorTag) {
			if (a.getAttribute("href") != null) {
				clickableLinksWithAnchorTAg.add(a);
			}
		}
		// Total clickable links with anchor tag in this page
		int countClickableLinksWithAnchTag = clickableLinksWithAnchorTAg.size();
		System.out.println("Clickable links with anchor tag in this page are: " + countClickableLinksWithAnchTag);

		List<WebElement> clickableLinksWithImgTag = new ArrayList<WebElement>();
		for (WebElement img : totalLinksWithImgTag) {
			if (img.getAttribute("href") != null) {
				clickableLinksWithImgTag.add(img);
				clickableLinksWithAnchorTAg.add(img);
			}
		}
		// Total clickable links with img tag in this page
		int newTotalClickableLinks = clickableLinksWithAnchorTAg.size();
		int countClickableLinksWithImgTag = newTotalClickableLinks - countClickableLinksWithAnchTag;
		System.out.println("Clickable links with img tag in this page are: " + countClickableLinksWithImgTag);

		System.out.println("Total clickable links in this page are: " + newTotalClickableLinks);
		System.out.println();
	}

	public void linksOpenInNewWindow() {
		List<WebElement> linksWIthNewTab = new ArrayList<WebElement>();
		List<WebElement> anotherList = new ArrayList<WebElement>(5000);
		anotherList = driver.findElements(By.tagName("a"));
		anotherList.addAll(driver.findElements(By.tagName("img")));

		for (int i = 0; i <= anotherList.size() - 1; i++) {
			if (anotherList.get(i).getAttribute("target") == "_blank") {
				linksWIthNewTab.add(anotherList.get(i));

				for (WebElement s : linksWIthNewTab) {
					System.out.println(s.getText());
				}
			} else {
				// System.out.println("There is no link on this page that open on new tab!!");
			}
		}
		System.out.println("	Total links that open in new tab are: " + linksWIthNewTab.size());

	}

	public void isFrameExisted() {
		List<WebElement> frameList = driver.findElements(By.tagName("frame"));
		frameList.addAll(driver.findElements(By.tagName("iframe")));

		System.out.println("	Total frame present in this page are : " + frameList.size());
	}

	public void isSelectTagExisted() {
		List<WebElement> selectTags = driver.findElements(By.tagName("select"));

		System.out.println("	Total select tags present in this page are : " + selectTags.size());
	}

	public void showPageScanResult() {
		clickableLinksCount();
		linksOpenInNewWindow();
		isFrameExisted();
		isSelectTagExisted();
		System.out.println();
	}

}
