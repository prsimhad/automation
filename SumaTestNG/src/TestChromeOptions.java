

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestChromeOptions {
	
	WebDriver driver;

	/**
	 * Test to navigate Yahoo page
	 * 
	 * Starting point will be the yahoo.com
	 * 
	 * *** You may want to do a manual test at first to gather the needed
	 * element locators needed for the test ****** Run Thru The Debugger
	 * 
	 * https://www.yahoo.com
	 * 
	 * Follow Steps below
	 * 
	 */
		
	Boolean value = false;
	
	@Test(priority=1)
	public void funWithYahooPage() throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "Z:\\chromedriver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        
       // options.addArguments("start-maximized"); 
        driver = new ChromeDriver(options);
        
       // driver = new ChromeDriver();
        
        driver.get("https://self-service.iam.target.com/");
        /*
        FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "Z:\\geckodriver\\geckodriver.exe");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);
        FirefoxDriver driver = new FirefoxDriver(firefoxOptions);
        
        */
        
       // driver.manage().window().maximize();
      //  driver.findElement(By.tagName("body")).sendKeys("Keys.ESCAPE");
       // driver.wait(10);
       // driver.get("https://www.google.com/");
        Thread.sleep(20000);
        /*
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_ESCAPE);
        robot.keyRelease(KeyEvent.VK_ESCAPE);
        */
       // int pageLoadTimeout = 10;
       // driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
       // ((JavascriptExecutor) driver).executeScript("return window.stop");
     //  value =  this.existsElement("reload-button");
        try{
        //value = driver.findElement(By.id("reload-button")).isDisplayed();
        
        WebDriverWait wait = new WebDriverWait(driver,15);
       // interstitial-wrapper

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".interstitial-wrapper")));
        
        	if(element == null){
        		value = false;
        	}else{
        		value = true;
        	}
       // value = true;
        }catch(Exception e){
        	//value = false;
        }
       // value = driver.findElement(By.id("lst-ib")).isDisplayed();
        System.out.println("element found==========>"+value);
        
        //driver = new ChromeDriver();
       // driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	public boolean existsElement(String id) throws InterruptedException {
        try {
              Thread.sleep(8000);
              System.out.println("inside existsElement====>");
            driver.findElement(By.id("lst-ib"));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
	
   /*
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Z:\\chromeD\\chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}	
	*/
}
