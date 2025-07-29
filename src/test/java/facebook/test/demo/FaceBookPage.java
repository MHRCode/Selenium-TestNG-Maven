package facebook.test.demo;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mahwish.testbase.BaseClass;

public class FaceBookPage extends BaseClass{
	
	

	String url = "https://www.facebook.com/";
	

	
	
	@Test
	public void welcomeMsg() {
		driver.get(url);
		String expectedResult = "Connect with friends and the world around you on Facebook.";
		String actualResult = driver.findElement(By.xpath("//h2[@class='_8eso']")).getText();
		
		Assert.assertEquals(actualResult, expectedResult, "Not match!");
		
	}
	
	@Test
	public void VerifyLoginFields() {
		driver.get(url);
		WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
		Assert.assertTrue(email.isDisplayed());
		
		WebElement password = driver.findElement(By.xpath("//input[@id='pass']"));
		Assert.assertTrue(password.isDisplayed());
		
		WebElement loginButton = driver.findElement(By.xpath("//button[@name='login']"));
		Assert.assertTrue(loginButton.isDisplayed());
	}
	
	

}
