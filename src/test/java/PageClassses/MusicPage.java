package PageClassses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MusicPage {
	WebDriver driver;
	WebElement element;

	public MusicPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//nav[@id='ac-globalnav']/div/ul[2]/li[7]/a")
	WebElement musicIcon;
		
	public void clickOnMusicLink(){
		musicIcon.click();
	}
	

}
