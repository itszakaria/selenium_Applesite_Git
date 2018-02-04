package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class IPhonePagePF {
	WebDriver driver;
	ExtentTest test;

	public IPhonePagePF(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//nav[@id=\"ac-globalnav\"]/div/ul[2]/li[4]/a")
	WebElement iPhone;

	public void clickOnIPhone() {
		iPhone.click();
	}
	
	
}