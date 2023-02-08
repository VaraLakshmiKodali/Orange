package com.Assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExpectedTitleAndUrl 
{
	public static void main(String[] args)
	{
		String ApplicationUrl="https://Google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		String Expected_GoogleHomePageTitle="google";
		System.out.println("The Expected Google Home Page Title is :- "+Expected_GoogleHomePageTitle);
		String Actual_GoogleHomePageTitle=driver.getTitle();
		System.out.println("The Actual Google Home Page Title is :- "+Actual_GoogleHomePageTitle);
		if(Actual_GoogleHomePageTitle.equals(Expected_GoogleHomePageTitle))
		{
			System.out.println("The Title Matched - PASS");
		}
		else
		{
			System.out.println("The Title NOT Matched - FAIL");
		}
		char FirstLetter_Expected_G=Expected_GoogleHomePageTitle.charAt(0);
		System.out.println("The First Letter Should be G "+FirstLetter_Expected_G);
		char Actual_TitleIndex=Actual_GoogleHomePageTitle.charAt(0);
		System.out.println("The Actual Title Index is "+Actual_TitleIndex);
		if(Actual_TitleIndex==(FirstLetter_Expected_G))
		{
			System.out.println("The First Letter Matched - PASS");
		}
		else
		{
			System.out.println("The First Letter NOT Matched - FAIL");
		}
		String ExpectedGoogleHomePageUrl="google.com";
		System.out.println("The Expected Google Home Page Url :- "+ExpectedGoogleHomePageUrl);
		String ActualGoogleHomePageUrl=driver.getCurrentUrl();
		System.out.println("The Actual Google Home Page Url is :- "+ActualGoogleHomePageUrl);
		if(ActualGoogleHomePageUrl.contains(ExpectedGoogleHomePageUrl))
		{
			System.out.println("The Url Matched - PASS");
		}
		else
		{
			System.out.println("The Url NOT Matched - FAIL");
		}
		driver.quit();
	}
}
