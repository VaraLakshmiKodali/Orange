package com.NavigatingToApplication;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BingApplicationLaunch 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ApplicationUrl="https://Bing.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		driver.close();
	}
}
