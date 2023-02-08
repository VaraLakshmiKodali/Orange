package com.Buttons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class RadioButton 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://echoecho.com/htmlforms10.htm";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		By group1RadioButtonsL=By.name("group1");
		List<WebElement>group1RadioButtons=driver.findElements(group1RadioButtonsL);
		int group1RadioButtonsCount=group1RadioButtons.size();
		System.out.println("The No.Of RadioButton: "+group1RadioButtonsCount);
		for(int index=0;index<group1RadioButtonsCount;index++)
		{
			
			String radioButtonName=group1RadioButtons.get(index).getAttribute("value");
			System.out.println(index+" - "+radioButtonName);
			
		}
		driver.quit();
	}
}
