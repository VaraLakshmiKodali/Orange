package com.Screenshot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BingHomePageScreenShot 
{
	public static void main(String[] args) throws IOException 
	{
		String ApplicationUrl="https://Bing.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
				
		WebDriverWait Wait=new WebDriverWait(driver, 26);
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("id_s")));
				
		File BingHomePageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(BingHomePageScreenShot, new File("./ApplicationScreenShots/BingHomePageScreenShot3.png"));
		
		driver.quit();
	}
}
