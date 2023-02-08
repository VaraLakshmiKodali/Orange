package com.Alerts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TsRtcAlertBox 
{
	public static void main(String[] args) throws InterruptedException 
	{
		String ApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		// id="searchBtn" 
		
		WebElement CheckAvailability=driver.findElement(By.id("searchBtn"));
		CheckAvailability.click();
		
		Alert Alert=driver.switchTo().alert();
		
		Thread.sleep(5000);
		
		Alert.accept();
		
		WebElement Enquiry=driver.findElement(By.linkText("Enquiry"));
		
		Enquiry.click();
		
		driver.quit();
		
	}
}
