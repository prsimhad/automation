import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class iFrame {
	
	WebDriver driver;
	
	@Test(priority=1)
	public void funWithYahooPage() throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "Z:\\chromedriver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
        
       // options.addArguments("start-maximized"); 
       // driver = new ChromeDriver(options);
        
        driver = new ChromeDriver();
        
        driver.get("http://demo.guru99.com/test/guru99home/");
        
	}
	
	@Test(priority=2)
	public void totaliFrames(){
		
		List<WebElement> elements = driver.findElements(By.tagName("iframe"));
		
		for(WebElement element : elements){
			if(element.getAttribute("src").contains("youtube")){
			driver.switchTo().frame(element);
			element.click();
			break;
			
			}
		}
		
		driver.switchTo().defaultContent();
	}
	
	
	@AfterClass
	public void closeDriver(){
		//driver.close();
	}

}
