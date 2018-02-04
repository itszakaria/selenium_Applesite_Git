package PageClassses;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class MacBookProPF {

	WebDriver driver;
	ExtentTest et;

	public MacBookProPF(WebDriver driver, ExtentTest et) {
		this.driver = driver;
		this.et = et;

		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//nav[@id='chapternav']/div/ul/li[3]/a/span[1]")
	static WebElement macBookPro;
	
	public static WebElement retMacBookPro(){
		return macBookPro;
	}
	
	public void clickOnmacBookPro(){
		macBookPro.click();
	}

	
	@FindBy(partialLinkText = "Watch the design fil")
	WebElement videLink;
	
	public void clickOnVideoLink(){
		videLink.click();
	}
	
	@FindBy(xpath="//body[@id='overview']/div[9]/div/div/div[2]/div[2]/button")
	WebElement pauseButton;
	
	public void clickOnPauseButton(){
		pauseButton.click();
	}
	
	@FindBy(xpath="//body[@id=\"overview\"]/div[8]/button")
	WebElement closeButton;
	
	public void clickOnCloseButton() {
		closeButton.click();
	}
	
	@FindBy(xpath="//body[@id='overview']/div[9]/div/div/div[2]/div[5]/div[2]/div/div/div/div[1]")
	WebElement slider;
	
	public WebElement retSlider(){
		return slider;
	}
	
	
	@FindBy(xpath="//body[@id='overview']/div[9]/button")
	WebElement videoCloseButton;
	
	public void closeVideo(){
		//videoCloseButton.click();
		videoCloseButton.sendKeys(Keys.ESCAPE);
	}
	
	
	@FindBy(xpath="//div[@id='main']/section[4]/div[2]/button/span[3]")
	WebElement plusButton;
	
	public void clickOnExpand(){
		plusButton.click();
	}
	
}
