package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePageFactory {
	WebDriver driver;
	ExtentTest test;

	public HomePageFactory(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	// returning Mac at Menubar
	@FindBy(xpath = "//*[@id='ac-globalnav']/div/ul[2]/li[2]/a")
	WebElement mac;

	public WebElement macAtMenu() {
		return mac;
	}
	
	@FindBy(xpath = "//button[@id=\"enhanced-gallery-hero-gallery-previous-trigger\"]")
	WebElement galleryLedtButton;

	public void clickOnGalleryLeftButton() {
		galleryLedtButton.click();
	}

	public WebElement galleryLeftButton() {
		return galleryLedtButton;

	}
	
	@FindBy(css = "[id=ac-gn-firstfocus][class^='ac-gn-link']")
	WebElement appleIcon;
	
	public WebElement appleIcon() {
		return appleIcon;
	}
	
	
	@FindBy(css = ".ac-gf-content")
	WebElement footer;
	
	public WebElement footerSection() {
		return footer;
	}
	
}
