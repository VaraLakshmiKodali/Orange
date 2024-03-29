package com.OrangeHrmApplication;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest 
{

	public WebDriver driver;
	String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	
	@BeforeTest
	public void setUp()
	{
	
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		
		//WebPageWait - for the Application to be loaded on browser
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
	}
	
	
	@AfterTest
	public void tearDown()
	{
		
		driver.quit();
		
	}
	
}
