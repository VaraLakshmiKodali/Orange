package com.LinksTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ValueLabsTesting 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://valuelabs.com";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		
		By HeaderBlockL=By.id("navbarSupportedContent");
		WebElement HeaderBlock=driver.findElement(HeaderBlockL);
		
		By HeaderBlockLinksL=By.tagName("a");
		List<WebElement>HeaderBlockLinks=HeaderBlock.findElements(HeaderBlockLinksL);
		
		int HeaderBlockLinksCount=HeaderBlockLinks.size();
		System.out.println("The No.of Links In Value Labs Header Block :- "+HeaderBlockLinksCount);
		
		for(int index=0;index<HeaderBlockLinks.size();index++)
		{
			if(HeaderBlockLinks.get(index).isDisplayed())
			{
				String HeaderBlockLinkName=HeaderBlockLinks.get(index).getText();
				System.out.println(index+" "+HeaderBlockLinkName);
			}
		}
		
		driver.quit();		
		
	}
}
