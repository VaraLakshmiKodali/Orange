package com.ValidatingTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validate_BingHomePageTitle 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://bing.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		String Expected_BingHomePageTitle="Bing";
		System.out.println("The Expected Bing Home Page Title is :-"+Expected_BingHomePageTitle);
		String Actual_BingHomePageTitle=driver.getTitle();
		System.out.println("The Actual Bing Home Page Title is :-"+Actual_BingHomePageTitle);
		if(Actual_BingHomePageTitle.equals(Expected_BingHomePageTitle))
		{
			System.out.println("The Title of Bing Home Page is Matched - PASS");
		}
		else
		{
			System.out.println("The Title of Bing Home Page is NOT Matched - FAIL");
		}
		driver.quit();
	}
}
 