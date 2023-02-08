package com.CapturingTitle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Capture_GoogleHomePageTitle
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		String ApplicationUrl="https://Google.com";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		String Actual_GoogleHomePageTitle=driver.getTitle();
		System.out.println("The Actual Google Home Page Title is :- "+Actual_GoogleHomePageTitle);
		
	}

}
