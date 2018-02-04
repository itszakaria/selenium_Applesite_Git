package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
	
public class IpadPF {
	WebDriver driver;
	ExtentTest test;

	public IpadPF(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//nav[@id='ac-globalnav']/div/ul[2]/li[3]/a")
	WebElement ipad;

	public void clickOnIpad() {
		ipad.click();
	}
	
	
}