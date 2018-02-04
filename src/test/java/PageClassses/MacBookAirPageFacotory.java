package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class MacBookAirPageFacotory {
	WebDriver driver;
	ExtentTest elog;

	public MacBookAirPageFacotory(WebDriver driver, ExtentTest elog) {
		this.driver = driver;
		this.elog = elog;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//nav[@id='chapternav']/div/ul/li[2]/a/span")
	WebElement macbookAir;
	
	
	public WebElement macbookAirButton(){
		return macbookAir;
	}
	
	public void clickOnMacabookAir() {
		macbookAir.click();
		elog.log(LogStatus.INFO, "Clicked on MacbookAir");
	}

	
	@FindBy(xpath="//nav[@id=\"chapternav\"]/div/ul/li[10]/a/figure")
	WebElement compareAll;
	
	public void clickOnCompareMacs(){
		compareAll.click();
		elog.log(LogStatus.INFO, "Clicked on compare");
	}
	
	
	@FindBy(xpath="//div[@id='main']/div/div/p/a")
	WebElement compareMacs;
	
	public void clickOnCompare(){
		compareMacs.click();
		elog.log(LogStatus.PASS, "Clicked on Compare models");
	}
	
	@FindBy(xpath="//div[@id='main']/section[6]/div[4]/div[2]/div/p")
	WebElement scrollToView;
	
	public WebElement scrollToView(){
		return scrollToView;
	}
	

}
