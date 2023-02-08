package com.DragAndDropOperation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame_Drag 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://jqueryui.com/droppable/";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//<iframe src="/resources/demos/droppable/default.html" class="demo-frame"></iframe>
		//By WebPageFrameL=By.className("demo-frame");
		//WebElement Frame=driver.findElement(WebPageFrameL);
		
		WebElement WebPageFrame=driver.findElement(By.className("demo-frame"));
		
		driver.switchTo().frame(WebPageFrame);
		
		// id="draggable" 
		
		WebElement DragMeToMyTarget=driver.findElement(By.id("draggable"));
		
		String DragMeToMyTargetText=DragMeToMyTarget.getText();
		System.out.println("The Text Of the Web Element is :- "+DragMeToMyTargetText);
		
		driver.quit();
		
	}
}
