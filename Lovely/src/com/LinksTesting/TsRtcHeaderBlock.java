package com.LinksTesting;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class TsRtcHeaderBlock 
{
	public static void main(String[] args)
	{
		String ApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize(); 
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		By TsRtcHeaderBlockL=By.className("menu-wrap");
		WebElement HeaderBlock=driver.findElement(TsRtcHeaderBlockL);
		
		By HeaderBlockLinksL=By.tagName("a");
		List<WebElement>HeaderBlockLinks=HeaderBlock.findElements(HeaderBlockLinksL);
		
		int HeaderBlockLinksCount=HeaderBlockLinks.size();
		System.out.println("The No.of Links in TsRtc Web Page is :- "+HeaderBlockLinksCount);
		
		for(int index=0;index<HeaderBlockLinksCount;index++)
		{
			String HeaderBlockLinkName=HeaderBlockLinks.get(index).getText();
			System.out.println(index+ " "+HeaderBlockLinkName);
			
			HeaderBlockLinks.get(index).click();
			
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println();
			
			driver.navigate().back();
			
			HeaderBlock=driver.findElement(TsRtcHeaderBlockL);
			HeaderBlockLinks=HeaderBlock.findElements(HeaderBlockLinksL);
			
		}
		driver.quit();
	}
}
