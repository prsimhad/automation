import java.awt.AWTException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadioButton {

	
	WebDriver driver;
	
	@Test(priority=1)
	public void funWithYahooPage() throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "Z:\\chromedriver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
        
       // options.addArguments("start-maximized"); 
       // driver = new ChromeDriver(options);
        
        driver = new ChromeDriver();
        
        driver.get("http://demo.guru99.com/test/radio.html");
        
	}
	
	@Test(priority=2)
	public void totalRadioButtons(){
		
		List<WebElement> elements = driver.findElements(By.xpath("//input[contains(@id,'vfb-7')]"));
		
		System.out.println("Total number of radio button ===>" + elements.size());
		
		int count = 0 ;
		
		for(WebElement element : elements){
			
			if (count == (elements.size() - 2)){
				
				element.click();
				break;
			}
			count++;
		}
	}
	
	
}
