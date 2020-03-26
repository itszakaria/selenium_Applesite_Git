package TestCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExtentFactory;
import Utilities.TestBase;

public class DailyWork extends TestBase {
	static String fromCity = "JFK, New York";
	static String toCity = "Dhaka, Bangladesh";
	// static String toCity = "Jeddah, Saudi Arabia (JED-King Abdulaziz Intl.)";
	static String fromDate = "01/31/2020";
	static String toDate = "02/28/2020";

	@Test
	public void dailyTesting() {
		try {
			baseUrl = "https://legacy.quran.com/24";
			log = LogManager.getLogger(DailyWork.class.getName());
			report = ExtentFactory.getInstance("AppleHomePage");
			elog = report.startTest("Apple Home Page Testing getting started.");

			driver.get(baseUrl);
			driver.findElement(By.xpath("//*[contains(text(), 'Trans')]/../../input")).click();

			elog.log(LogStatus.INFO, "Opened the Application");
			Thread.sleep(3);
			driver.findElement(By.tagName("body")).click();
			System.out.println("open tabs: " + driver.getWindowHandles().size());
			// Thread.sleep(1);

			

			
			
			openNewTab(1, "https://www.expedia.com");
			takeExpediaActions();
			driver.switchTo().defaultContent();
			
			

			
			
			// openNewTab(2, "https://certs-school.lms.simplilearn.com/dashboard");
			
			
			
			
			// openNewTab(2, "https://www.zillow.com/homes/for_sale/Orlando,-FL_rb/");
			openNewTab(2, "https://www.zillow.com/");
			driver.findElement(By.xpath("//button[@id='price']")).click();
			driver.findElement(By.xpath("//*[@id='price-exposed-max']")).click();	
			driver.findElement(By.xpath("//*[@id='price-exposed-max']")).sendKeys("300000");
			driver.findElement(By.xpath("//*[@id='search-page-react-content']/section/div[1]/div[2]/div[2]/div/div/div/button")).click();
				
				
				
				
				
			System.out.println("sdgfrdsgdsrg");
			
		} catch (Exception e) {
			// driver.quit();
			e.printStackTrace();
		}

	}
	
	public static void openNewTab(int numOfTab, String Url) throws InterruptedException {
		Thread.sleep(2);
		ArrayList<String> tabs = null;

		for (int i = 1; i < 8; i++) {
			try {
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				Thread.sleep(1);
				robot.keyPress(KeyEvent.VK_T);
				Thread.sleep(1);
				robot.keyRelease(KeyEvent.VK_T);
				Thread.sleep(1);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(1);

				// switches to new tab
				tabs = new ArrayList<String>(driver.getWindowHandles());
				if (tabs.size() > numOfTab) {
					System.out.println("open tabs: " + driver.getWindowHandles().size());
					break;
				}

				Thread.sleep(2);
			} catch (Exception e) {

				e.printStackTrace();

			}
			Thread.sleep(2);
			System.out.println("tried times :" + i);
		}
		Thread.sleep(2);
		driver.switchTo().window(tabs.get(numOfTab));
		driver.get(Url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(2);
	}
	
	
	public static void takeExpediaActions() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement el = driver.findElement(By.xpath("(//*[contains(text(), 'Flights')])[4]"));
		act.moveToElement(el).click().build().perform();;
	
		Thread.sleep(2);
		Actions act2 = new Actions(driver);
		WebElement elem = driver.findElement(By.id("flight-origin-hp-flight"));
		act2.moveToElement(elem).click().build().perform();
		act2.moveToElement(elem).sendKeys(fromCity).build().perform();
		Thread.sleep(3);

		WebElement elem2 = driver.findElement(By.xpath("(//*[contains(text(), 'Flying to')])[1]/following-sibling::input"));
		act2.moveToElement(elem2).click().build().perform();
		act.moveToElement(elem2).sendKeys(toCity).build().perform();
		
		Thread.sleep(2);
		WebElement elem3 = driver.findElement(By.xpath("//input[@id='flight-departing-hp-flight']"));
		act2.moveToElement(elem3).click().sendKeys(fromDate).build().perform();
		//act.moveToElement(elem3).sendKeys("12/27/2019").build().perform();
		Thread.sleep(1000L);
		
		// act2.moveToElement(elem3).sendKeys(Keys.TAB).build().perform();
		 
		
		
		
		Thread.sleep(3000L);
		
		
		WebElement elem4 = driver.findElement(By.xpath("//label[@for='flight-returning-hp-flight']"));
		Actions act4 = new Actions(driver);
		act4.moveToElement(elem4).click().build().perform();
		act4.moveToElement(elem4).click().build().perform();
		Thread.sleep(2000);
		try{
			elem4.clear();
		}catch(Exception e) {
			
		}
		
		/*Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_A);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		
		robo.keyPress(KeyEvent.VK_DELETE);
		robo.keyRelease(KeyEvent.VK_DELETE);*/
		
		act4.moveToElement(elem4).click().sendKeys("03/31/2020").build().perform();
		driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
		// driver.findElement(By.xpath("//button[@class='datepicker-paging datepicker-next btn-paging btn-secondary next']")).click();
		Thread.sleep(2000);
		List<WebElement> dates = driver.findElements(By.xpath("//caption[text()='Feb 2020']/ancestor::table//td"));
		System.out.println("dates size is: " + dates.size());
		
		for(WebElement date : dates) {
			// System.out.println(date.getText().toString());
			if(date.getText().toString().contains("28")) {
				System.out.println("found date march 30");
				act4.moveToElement(date).click().build().perform();
				Thread.sleep(1000);
				break;
			}
			
		}
		driver.findElement(By.xpath("(//label[@class='col search-btn-col']/button[@type='submit'])[1]")).click();
	}
	
}

