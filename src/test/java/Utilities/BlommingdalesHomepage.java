package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BlommingdalesHomepage {

	WebDriver driver;
	
	public BlommingdalesHomepage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, BlommingdalesHomepage.class);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//input[@class='aboveNavSearchBox ui-autocomplete-input' and @type='text']")
	static WebElement searchbox;
	
	public void writeOnWebElement(String str) {
		searchbox.sendKeys(str);
	}
	
	@FindBy(id="subnavSearchSubmit")
	static WebElement searchButton;
	
	public void clickOnSearchButton() {
		searchButton.click();
	}
	
	@FindBy(id="sortBy")
	static WebElement sortByBox;
	
	public void clickOnSortbyBox() {
		sortByBox.click();
	}
	
	@FindBy(xpath="//ul[@class='newDropDown_list']/li[5]/a")
	static WebElement highLow;
	
	public void selectHighLow() {
	highLow.click();
	}
	
	@FindBy(xpath="//img[@title='Burberry - Contrast Check Classic Tie']")
	WebElement justAnItem;
	
	public void clickOnJustAnItem() {
		justAnItem.click();
	}
	
	
	
	
}
