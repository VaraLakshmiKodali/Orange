package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TsrtcLinksTesting 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		By LinkTextL=By.tagName("a");
		List<WebElement>TsrtcHomePageLinks=driver.findElements(LinkTextL);
		int TsrtcHomePageLinksCount=TsrtcHomePageLinks.size();
		System.out.println("The No.of Links in Tsrtc Home Page :- "+TsrtcHomePageLinksCount);
		for(int index=0;index<TsrtcHomePageLinksCount;index++)
		{
			String TsrtcHomePageLinkName=TsrtcHomePageLinks.get(index).getText();
			System.out.println(TsrtcHomePageLinkName);
		}
		driver.quit();
	}
}
