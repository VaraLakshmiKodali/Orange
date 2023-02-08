package com.ValidatingTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Validating_GoogleHomePage
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ApplicatioUrl="https://Google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicatioUrl);
		String Expected_GoogleHomePageTitle="Google";
		System.out.println("The Expected Title of Google Home Page :- "+Expected_GoogleHomePageTitle);
		String Actual_GoogleHomePageTitle=driver.getTitle();
		System.out.println("The Actual Title of Google Home Page :- "+Actual_GoogleHomePageTitle);
		if(Actual_GoogleHomePageTitle.equals(Expected_GoogleHomePageTitle))
		{
			System.out.println("The Title is Matched - PASS");
		}
		else
		{
			System.out.println("The Title is NOT Matched - FAIL");
		}
		driver.quit();
	}
		
}
