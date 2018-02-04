package PageClassses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IPadPOM {
	WebDriver driver;

	public IPadPOM(WebDriver driver) {
		this.driver = driver;
	}

	By iPadPro = By.xpath("//nav[@id='chapternav']/div/ul/li[1]/a/figure");

	public WebElement iPadPro() {
		return driver.findElement(iPadPro);
	}

	public void clickOnIPadPro(){
		iPadPro().click();
	}
	
	By imageChangeButton = By.xpath("//div[@id='gallery-performance']/div[1]/ul/li[2]/button");
	
	public WebElement imageChangeButton(){
		return driver.findElement(imageChangeButton);
	}
	
	public void clickOnImageChangeButton(){
		imageChangeButton().click();
	}
	
	By dynamicElementAppear = By.xpath("//section[@id='section-design']/div/div/div/div/div[2]/div/div[2]/figure[2]/div/span[1]/span");
	
	public WebElement dynamicElementAppear(){
		return driver.findElement(dynamicElementAppear);
	}
}
