package PageClassses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MusicPageFactory {
	WebDriver driver;
	WebElement element;

	public MusicPageFactory(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement musicLink(){
		element = driver.findElement(By.xpath("//nav[@id='ac-globalnav']/div/ul[2]/li[7]/a"));
		return element;
	}
	
	public void clickOnMusicLink(){
		musicLink().click();
	}
	

}
