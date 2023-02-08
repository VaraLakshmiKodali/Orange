package com.DropDownAutomation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class Monster 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://my.monsterindia.com/sponsered_popup.html";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		By CurrentLocationL=By.className("border_grey1");
		WebElement CurrentLocation=driver.findElement(CurrentLocationL);
		
		Select SelectionFromCurrentLocation=new Select(CurrentLocation);
		SelectionFromCurrentLocation.selectByIndex(3);
		SelectionFromCurrentLocation.selectByValue("492");
		SelectionFromCurrentLocation.selectByVisibleText("Delhi");
		
		By IndustryL=By.id("id_industry");
		WebElement Industry=driver.findElement(IndustryL);
		Select SelectionFromIndustry=new Select(Industry);
		SelectionFromIndustry.selectByIndex(1);
		SelectionFromIndustry.selectByValue("4");
		SelectionFromIndustry.selectByVisibleText("Banking/Accounting/Financial Services");
		
		SelectionFromIndustry.deselectByIndex(2);
		SelectionFromIndustry.deselectByValue("5");
		SelectionFromIndustry.deselectByVisibleText("Other");
		SelectionFromIndustry.deselectAll();
		driver.quit();
		
	}
}
