

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class WebDriverTest {
	
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
		
	@Test(priority=1)
	public void funWithYahooPage() {
		
		driver.get("https://www.yahoo.com/");
		
		// Step 1. Assert that we are on the correct page by checking that title = 'Yahoo' 
		String title = driver.getTitle();
		
		//System.out.println("title is ====>"+title);
		
		Assert.assertTrue(title.equals("Yahooo"), "yes we are on the correct page");
		/*
		 * Step 2. Display the count of options on the left side panel ('Mail', 'News', 'Sports',......)
		 * including 'More Yahoo Sites' option
	 	 */
		
		List<WebElement> optionsPanel = driver.findElements(By.xpath("//div[@id='mega-bottombar']/ul/li"));
		
		System.out.println("Count of options on the left side panel is : "+optionsPanel.size());
		
		// Step 3: Enter 'Nutrition' on the search bar on the top
		
		driver.findElement(By.id("uh-search-box")).sendKeys("Nutrition");
	
		// Step 4: Click Search button
		
		driver.findElement(By.id("uh-search-button")).click();

		// Step 5: Display count of Images on the page
		
		List<WebElement> imagesOnPage = driver.findElements(By.tagName("img"));
		System.out.println("Count of images on the page is : "+imagesOnPage.size());
		
		// Step 6. Click 'Sign In' button on the top left side
		
		driver.findElement(By.id("yucs-login_signIn")).click();
		
		// Step 7. Display the boolean state of the checkbox next to 'Keep me signed in'
		
		System.out.println("Boolan state of the checkbox next to keep me signed in ==>"+driver.findElement(By.id("persistent")).getAttribute("value"));

		// Step 8. Click 'Sign In' button 
			
		driver.findElement(By.id("login-signin")).click();
		/*
		 * Step 9. Error will be displayed. 
		 * Assert true when the error message contains the expectedErrorStr defined below
		 */
		String expectedErrorStr = "Sorry, we don't recognize this email.";
		
		String actualErrorStr = driver.findElement(By.xpath("//div[@id='username-country-code-field']/following-sibling::p")).getText();
		
		Assert.assertEquals(actualErrorStr, expectedErrorStr, "Both actual and expected error string are equal");
		
	}
	
	/**
	 * Test to simulate an attempted Sign in to Paypal and validate error
	 * message returned
	 * 
	 * Starting point will be the PayPal
	 * 
	 * *** You may want to do a manual test at first to gather the needed
	 * element locators needed for the test ****** Run Thru The Debugger
	 * 
	 * https://www.paypal.com
	 * 
	 * Follow Steps below
	 * 
	 */
		
	@Test
	public void funWithPayPalSignUpPage() {
		
		driver.get("https://www.paypal.com");
		
		/*
		 * Step 1. Assert that we are on the correct page by checking that title = 'Send Money, Pay Online or Set Up
		 * a Merchant Account - PayPal'  
		 */ 
		
		String title = driver.getTitle();
		Assert.assertTrue(title.equals("Send Money, Pay Online or Set Up a Merchant Account - PayPal"), "yes we are on the correct page");

		// Step 2. Click 'Sign Up for Free' button
		
		driver.findElement(By.id("signup-button")).click();
		
		// Step 3: Enter email address test@google.com 
		
		driver.findElement(By.id("cta-btn")).click();
		
		driver.findElement(By.id("paypalAccountData_email")).sendKeys("test@google.com");
		
		// Step 4: Enter password test123 
		
		driver.findElement(By.id("paypalAccountData_password")).sendKeys("test123");
        
		// Step 5: Enter confirm password test123
        
		driver.findElement(By.id("paypalAccountData_confirmPassword")).sendKeys("test123");
		// Step 6: Click 'Continue' button  
        
		driver.findElement(By.id("/appData/action")).click();
		/*
		 * Step 7. Error will be displayed		
		 * Assert True that error message contains the expectedErrorStr defined below
 		 */
		String expectedErrorStr = "It looks like you already signed up.";
		
		String actualErrorStr = driver.findElement(By.xpath("//div[@class = 'vx_form-control-message']/p/span")).getText();
		Assert.assertEquals(actualErrorStr, expectedErrorStr, "Both actual and expected error string are equal");
		
		// Step 8. Print out the boolean state of the 'confirmPassword' input field displayed
		
		boolean isDisplayed = driver.findElement(By.id("paypalAccountData_confirmPassword")).isDisplayed();
		
		System.out.println("Confirm password field is displayed :"+isDisplayed);
		
		// Step 9. Display the count of Images on the Sign In page
		
		List<WebElement> imageTags = driver.findElements(By.tagName("img"));
		
		System.out.println("Number of image tags are : "+imageTags);
		
		// Step 10. Display the country flag shown on the bottom right side
		
		boolean countryFlag = driver.findElement(By.xpath("//div[@class = 'country-and-lang-selector']/span/a")).isDisplayed();
		
		if(countryFlag){
			System.out.println("Country Flag is displayed!!");
		}else{
			System.out.println("Country Flag is not displayed!!");
		}
		
	}

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
}
