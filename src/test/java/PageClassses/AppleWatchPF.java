package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class AppleWatchPF {
	
	WebDriver driver;
	ExtentTest ar;
	
	public AppleWatchPF(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.ar = test;
		PageFactory.initElements(driver, this);
		}
	
	
	@FindBy(xpath="//nav[@id='ac-globalnav']/div/ul[2]/li[5]/a")
	WebElement watch;
		
	
	public void clickOnWatch(){
		watch.click();
	}
	
	
	@FindBy(xpath="//div[@id='main']/section[1]/div/p/a[2]")
	WebElement buy;
	
	
	public void clickOnBuy(){
		buy.click();
	}
	
	
	@FindBy(xpath="//div[@id='page']/div[6]/div[3]/div/div[2]/div/div/div[3]/store-provider/grid-page/wuip-grid/ul/li[10]/div/div[1]/img")
	WebElement watch01;
	
	
	public WebElement returnWatch01(){
		return watch01;
	}
	
	
	public void clickOnWatch01(){
		watch01.click();
	}
	
	
	@FindBy(xpath="//div[@class='localnav-header']/h1/a")
	WebElement watchSeries2;
	
	public void clickOnwatchSeries2(){
		watchSeries2.click();
	}
	
	
	@FindBy(xpath="//main[@id=\'main\']/section[6]/div/div/div/div[3]/div/a/figure")
	WebElement justElement;
	
	
	public WebElement returnJustElement(){
		return justElement;
	}
	
	
	@FindBy(xpath="//*[@id=\"main\"]/section[4]/div[2]/div[1]/figure/a")
	WebElement interactiveGallery;
	
	
	public void clickInteractiveGallery() {
		interactiveGallery.click();
	}
	
	@FindBy(xpath="/html/body/div[6]/button")
	WebElement closeButton;
	
	public void closeIntGallery() {
		closeButton.click();
	}
	
	@FindBy(css = ".chapternav-item-nike>a")
	WebElement specificClock;
	
	public WebElement specificClock() {
		return specificClock;
	}
	
	
	public WebElement returnWatch(){
		return watch;
	}
	
	
}
