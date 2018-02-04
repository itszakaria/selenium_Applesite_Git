package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MacLinkPageFactory {
	WebDriver driver;
	ExtentTest test;
	

	public MacLinkPageFactory(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//nav[@id='ac-globalnav']/div/ul[2]/li[2]/a")
	WebElement mac;

	public void clickMacAtMenubar(ExtentTest test) {
		mac.click();
		test.log(LogStatus.INFO, "Clicked on Mac");
	}
	
	public WebElement macAtMenu(){
		return mac;
	}
	
	// retuen macbook (at menu bar) element;
	@FindBy(xpath = "//nav[@id='chapternav']/div/ul/li[1]/a/span")
	WebElement macbook;
	

	public void clickOnMacabook() {
		macbook.click();
		test.log(LogStatus.INFO, "Clicked on Macbook");
	}


	@FindBy(xpath = "//nav[@id='ac-localnav']/div/div[2]/div/div[2]/div[2]/a")
	WebElement buyLink;

	public void clickOnBuy() {
		buyLink.click();
		test.log(LogStatus.INFO, "Clicked on Buy Link");
	}

	@FindBy(xpath = "//html/body/div[2]/div[6]/div[2]/bundle-selection/div[2]/div/div[2]/div/div[1]/div/bundle-selector/div[2]/fieldset/ul/li[3]/label/span[1]")
	WebElement selectColorGray;

	public void selectColor() {
		selectColorGray.click();
		test.log(LogStatus.INFO, "Selected color");
	}
	
	

	@FindBy(xpath = "html/body/div[2]/div[6]/div[2]/bundle-selection/div[2]/div/div[2]/div/div[1]/div/bundle-selector/div[3]/div[1]/div/div[3]/form/div/span/button")
	WebElement selectCapacity;
	

	
	public void selectCapacity() {
		selectCapacity.click();
		test.log(LogStatus.INFO, "Selected capacity");
	}
	
	

	@FindBy(xpath = "//*[@id='actiontray']/div/div[2]/div/div/div[2]/form/div/span/button/span")
	WebElement selectButton;

	public void clickSelect() {
		selectButton.click();
		test.log(LogStatus.INFO, "Clicked on select button");

	}

	@FindBy(xpath = "//*[@id='option.keyboard_and_documentation_z0sk']")
	WebElement selectionBox;

	public WebElement selectKbDocument() {
		return selectionBox;

	}

	@FindBy(xpath = "//*[@id='actiontray']/div/div[2]/div/div/div[2]/button")
	WebElement addToCart;

	public void clickOnAdd2Cart() {
		addToCart.click();
		test.log(LogStatus.INFO, "Clicked on add to cart button");
	}

	@FindBy(xpath = "//*[@id='summaryheader-form']/div/span/button/span")
	WebElement reviewBag;

	public void clickOnReviewBag() {
		reviewBag.click();
		test.log(LogStatus.INFO, "Clicked on review bag icon");
	}

	@FindBy(xpath = "//li[@id='cart-recommendations-item-0']/div[2]/a")
	WebElement protection;

	public void clickProtectionOpt() {
		protection.click();
		test.log(LogStatus.INFO, "Added protection plan");
	}
	
	
	@FindBy(xpath= "//*[@id=\"configuration-form\"]/div[1]/div[1]/sticky/div/button/span")
	WebElement gallery;
	
	public void clickOnViewGallery() {
		gallery.click();
	}
	
}
