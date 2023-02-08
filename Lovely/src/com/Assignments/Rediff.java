package com.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Rediff 
{
	public static void main(String[] args)
	{
		
		String ApplicationUrl="http://register.rediff.com/register/register.php?FormName=user_details";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
			
	}
}
