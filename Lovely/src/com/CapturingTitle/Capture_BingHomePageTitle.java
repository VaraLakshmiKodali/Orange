package com.CapturingTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Capture_BingHomePageTitle 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		String ApplicationUrl="https://Bing.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		String Actual_BingHomePageTitle=driver.getTitle();
		System.out.println("The Actual Bing Home Page Title is :- "+Actual_BingHomePageTitle);
		driver.quit();
	}

}
