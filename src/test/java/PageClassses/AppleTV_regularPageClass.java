package PageClassses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AppleTV_regularPageClass {
	WebDriver driver;
	static WebElement element;

	public AppleTV_regularPageClass(WebDriver driver) {
		this.driver = driver;
	}

	public static WebElement tvIcon(WebDriver driver) {
		element = driver.findElement(By.xpath("//nav[@id='ac-globalnav']/div/ul[2]/li[6]/a"));
		return element;
	}

	public void clickOnTvIcon() {
		tvIcon(driver).click();
	}

}
