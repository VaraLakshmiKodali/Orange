package com.Assignments;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OsmaniaUniversity 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String ApplicationUrl="https://www.osmania.ac.in/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		By languageLocater=By.className("notranslate");
	    WebElement Language=driver.findElement(languageLocater);
	       
	    By LanguageDropdown_Locater=By.tagName("option");
	    List <WebElement> LanguageDropdown=Language.findElements(LanguageDropdown_Locater);
	    
	    Thread.sleep(200);
	     
	    int LanguageDropdownCount=LanguageDropdown.size();
	    System.out.println("Total Languages count in selection Language Dropdown:-"+LanguageDropdownCount);
	   	         
	    for (int index=0;index<LanguageDropdownCount;index++)
	    {
	    	String Languagename=LanguageDropdown.get(index).getText();
	    	System.out.println(index+ " " +Languagename);

	    	Select selectionLanguage=new Select(Language);
	    	selectionLanguage.selectByIndex(index);
	 
	    	WebDriverWait wait=new WebDriverWait(driver,20);
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(LanguageDropdown_Locater));
	           
	    	File OsmaniaLanguageScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(OsmaniaLanguageScreenShot, new File("./OsmaniaScreenShots/"+Languagename+".png"));
	 	}
		driver.quit();      
	}
}


		   
	