package com.Assignments;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class ValidateHeaderBlockOfTsrtc 
{
	public static void main(String[] args) 
	{
		String applicationUrlAddress="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(applicationUrlAddress);

		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		By tsrtcHeaderBlockLocator=By.className("menu-wrap");
	    WebElement tsrtcHeaderBlock=driver.findElement(tsrtcHeaderBlockLocator);
	       
	    By HeaderblocklinksLocator=By.tagName("a");
	    List<WebElement>HeaderBlockLinks=tsrtcHeaderBlock.findElements(HeaderblocklinksLocator);
	    
	    
	    int HeaderBlockLinksCount=HeaderBlockLinks.size();
	    System.out.println(" The No.of Links in Header Block :-"+ HeaderBlockLinksCount);

	    for(int index=0;index<HeaderBlockLinksCount;index++)
	    {  
	        
	        String HeaderBlockLinksname=HeaderBlockLinks.get(index).getText();
	        System.out.println(index+ " " +HeaderBlockLinksname);
	      
	        //EXtracted Expected Url Adress of elements
	    
	        WebElement Elements=HeaderBlockLinks.get(index);
	        String ExpectedUrl=Elements.getAttribute("href");
	        System.out.println(" The Expected Url is :- "+ExpectedUrl);
	      
	        HeaderBlockLinks.get(index).click();
	      
	          
	        //Actual Url Adress Of elements
	
	        String ActualUrl=driver.getCurrentUrl();
	        System.out.println(" The Actual Current Url is :- "+ActualUrl);
	        
	        
	        //Validation of URL Adress    

	        if (ActualUrl.contains(ExpectedUrl))
	        {
	        	System.out.println("The Actual Url contains Expected Url Address -Pass");
	        }
	        else
	        {
	        	System.out.println("The Actual Url Does NOT contains Expected Url Address -Fail");
	        }
	          
	          
	        System.out.println();
	          
	        driver.navigate().back();
	      
	        //Recreate the arraylist
	        //identifying the header block again from the previous page
	      
	        tsrtcHeaderBlock=driver.findElement(tsrtcHeaderBlockLocator);
	      
	        //getting the header block element again into the arraylist
	      
	        HeaderBlockLinks=tsrtcHeaderBlock.findElements(HeaderblocklinksLocator);
	        

	    }  
	    driver.quit();    

		
		
		
	}
}
