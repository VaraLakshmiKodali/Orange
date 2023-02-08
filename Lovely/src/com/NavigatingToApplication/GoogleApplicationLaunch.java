package com.NavigatingToApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleApplicationLaunch 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ApplicationUrl="https://Google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		driver.close();
	}
}
