package facebook.test.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FaceBookPage {
	
	WebDriver driver;
	String url = "https://www.facebook.com/";
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
	}
	@Test
	public void welcomeMsg() {
		
		String expectedResult = "Connect with friends and the world around you on Facebook.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		Assert.assertEquals(actualResult, expectedResult, "Not match!");
		
	}
	
	@Test
	public void VerifyLoginFields() {
		
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		Assert.assertTrue(email.isDisplayed());
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		Assert.assertTrue(password.isDisplayed());
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
		Assert.assertTrue(loginButton.isDisplayed());
	}
	
	

}
