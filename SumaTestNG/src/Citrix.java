import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.htmlunit.*;
import org.testng.annotations.Test;

class Citrix {
	
	WebDriver driver;

	@Test(priority=1)
	public void findCitrixElement() throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "Z:\\chromedriver\\chromedriver.exe");
		/*
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("start-maximized"); 
        driver = new ChromeDriver(options);
        */
        driver = new ChromeDriver();
        
        driver.get("https://targetctx.cadency.trintech.com/");
        
        Thread.sleep(5000);
        
        
	}
	

}
