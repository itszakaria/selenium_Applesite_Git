package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class SupportPF {
	
	WebDriver driver;
	ExtentTest test;
	
	
	public SupportPF(WebDriver driver, ExtentTest test){
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//nav[@id='ac-globalnav']/div/ul[2]/li[8]/a")
	WebElement support;
	
	
	public void clickOnSupport(){
		support.click();
	}
	
	
	@FindBy(xpath="//nav[@id='ac-localnav']/div/div[2]/div/div[1]/ul/li[2]/a")
	WebElement contactSupport;
	
	
	public WebElement retContactSupport(){
		return contactSupport;
	}
	
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div/div/div[1]/a/div/img")
	WebElement appleWatch;	
	
	public WebElement returnAppleWatch(){
		return appleWatch;
	}	
}
