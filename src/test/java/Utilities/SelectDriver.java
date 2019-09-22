package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class SelectDriver {
	WebDriver driver;
	String projectLocation = System.getProperty("user.dir");
	
	public SelectDriver(WebDriver driver){
		this.driver = driver;
	}
	
	public WebDriver selectMyDriver(String browser){
		
		if(browser.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", projectLocation + "//lib_drivers//chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", projectLocation + "//lib_drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browser.equals("edge")){
			System.setProperty("webdriver.edge.driver", projectLocation + "//lib_drivers//microsoftwebdriver.exe");
			driver = new EdgeDriver();
		}else {
			System.setProperty("webdriver.ie.driver", projectLocation + "//lib_drivers//ieDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	
	
	public WebDriver invokeBrowser(){
		
		Properties prop  = new Properties();
		try{
			FileInputStream fis = new FileInputStream(projectLocation + "\\src\\test\\resources\\config.properties");
		prop.load(fis);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		String browserName = prop.getProperty("browser");
		
		
		String projectLocation = System.getProperty("user.dir");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", projectLocation + "//lib_drivers//chromedriver.exe");
			// System.setProperty("webdriver.chrome.driver", projectLocation + "//lib_drivers//chromedriver.exe");
			// the above line works too, need to update teh drivers from c:/Lib_drivers
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", projectLocation + "//lib_drivers//geckodriver.exe");
			driver = new FirefoxDriver();
		}else if(browserName.equals("edge")){
			// System.setProperty("webdriver.chrome.driver", projectLocation + "//lib_drivers//chromedriver.exe");
			// driver = new ChromeDriver();
			System.setProperty("webdriver.edge.driver", projectLocation + "//lib_drivers//MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}else {
			System.setProperty("webdriver.ie.driver", projectLocation + "//lib_drivers//ieDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		return driver;
	}
	
	

}
