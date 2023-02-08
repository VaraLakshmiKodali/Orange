package com.WebTable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingFirstRowOfFirstColumnData 
{
	
	WebDriver driver;
	String ApplicationUrl="https://www.timeanddate.com/worldclock/";
	
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,550)");
		
		
	}
	
	public void applicationClose()
	{
		
		driver.quit();
		
	}
	
	public void cityName()
	{
	
		///html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
		By cityNameL=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]");
		WebElement cityName=driver.findElement(cityNameL);
		String cityNameText=cityName.getText();
		System.out.println(cityNameText);
		
	}
	
	public static void main(String[] args) 
	{
	
		CapturingFirstRowOfFirstColumnData getData=new CapturingFirstRowOfFirstColumnData();
		getData.applicationLaunch();
		getData.cityName();
		
	}
	
	
}
