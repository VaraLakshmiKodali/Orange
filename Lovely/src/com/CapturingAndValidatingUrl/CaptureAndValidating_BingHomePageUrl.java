package com.CapturingAndValidatingUrl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CaptureAndValidating_BingHomePageUrl 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://Bing.com";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		String Expected_BingHomePageUrl="bing.com";
		System.out.println("The Expected Bing Home Page Url is :- "+Expected_BingHomePageUrl);
		String Actual_BingHomePageUrl=driver.getCurrentUrl();
		System.out.println("The Actual Bing Home Page Url is :- "+Actual_BingHomePageUrl);
		if(Actual_BingHomePageUrl.contains(Expected_BingHomePageUrl))
		{
			System.out.println("The Url is Matched - PASS");
		}
		else
		{
			System.out.println("The Url is NOT Matched - FAIL");
		}
		driver.quit();
	}
}
