import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Salesforce {
	WebDriver driver;
	
	By securityQuestionRadio = By.id("sec_qna");
    By submitBtn = By.id("submit-button");
    By securityQuestion = By.xpath("//*[@id=\"QNA_FORM\"]/div[1]/div[3]/div/div/div/div/label");
    By answerField = By.id("answer0");
    By skip = By.id("optional-enroll-button");
    
    By salesforcelogin = By.xpath("//*[@id=\"idp_section_buttons\"]/button");
    By loginid = By.id("loginID");
    By Password = By.id("pass");
    By loginBtn = By.xpath("//*[@id=\"root\"]/div/div/div[2]/form/div[2]/button");
    
    
    Boolean value = false;
	
	@Test(priority=1)
	public void funWithYahooPage() throws InterruptedException, AWTException {
		
		
		System.setProperty("webdriver.chrome.driver", "Z:\\chromedriver\\chromedriver.exe");
		//ChromeOptions options = new ChromeOptions();
       // options.addArguments("headless");
        
       // options.addArguments("start-maximized"); 
       // driver = new ChromeDriver(options);
        
        driver = new ChromeDriver();
        
        driver.get("https://test-target.cs13.force.com/mySupport/login?so=00DW0000008xUL6");
        
        driver.findElement(salesforcelogin).click();
        driver.findElement(loginid).sendKeys("A602073");
        driver.findElement(Password).sendKeys("Akhil.436");
        driver.findElement(loginBtn).click();   
        
        Thread.sleep(10000);
       value =  this.existsElement("sec_qna");
       System.out.println("Element present========>"+value);
        driver.findElement(securityQuestionRadio).click();
	}
	
	public boolean existsElement(String id) throws InterruptedException {
        try {
             
              System.out.println("inside existsElement====>");
            driver.findElement(By.id(id));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }
}
