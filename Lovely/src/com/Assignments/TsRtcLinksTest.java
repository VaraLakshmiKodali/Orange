package com.Assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TsRtcLinksTest 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize(); 
		
		By TsRtcHeaderBlockL=By.className("menu-wrap");
		WebElement HeaderBlock=driver.findElement(TsRtcHeaderBlockL);
		
		By HeaderBlockL=By.tagName("a");
		List<WebElement>TsRtcHeaderBlockLinks=HeaderBlock.findElements(HeaderBlockL);

		int TsRtcHeaderBlockLinksCount=TsRtcHeaderBlockLinks.size();
		System.out.println("The No.of Links in TsRtc Web Page is :- "+TsRtcHeaderBlockLinksCount);
		
		for(int index=0;index<TsRtcHeaderBlockLinksCount;index++)
		{
			String TsRtcHeaderBlockLinkName=TsRtcHeaderBlockLinks.get(index).getText();
			System.out.println(index+ " "+TsRtcHeaderBlockLinkName);
		}
	
	}
}
