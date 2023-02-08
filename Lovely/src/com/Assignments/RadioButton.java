package com.Assignments;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
public class RadioButton
{
	public static void main(String[] args) throws InterruptedException 
	{
		String ApplicationUrl="https://echoecho.com/htmlforms10.htm";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, 1000)");
		
		
		By group1RadioButtonsL=By.name("group1");
		List<WebElement>group1RadioButtons=driver.findElements(group1RadioButtonsL);
			
		By group2RadioButtonL=By.name("group2");
		List<WebElement>group2RadioButtons=driver.findElements(group2RadioButtonL);
		
		int group1RadioButtonsCount=group1RadioButtons.size();
		int group2RadioButtonsCount=group2RadioButtons.size();
		
		System.out.println("The No.Of RadioButton: "+group1RadioButtonsCount);
		System.out.println("The No.Of RadioButton: "+group2RadioButtonsCount);
		
		for(int index=0;index<group1RadioButtonsCount;index++)
		{
			
			group1RadioButtons.get(index).click();
			group2RadioButtons.get(index).click();
			
			Thread.sleep(5000);
			
			System.out.println();
			
			for(int indexStatus=0;indexStatus<group1RadioButtonsCount;indexStatus++)
			{
				
				String group1RadioButtonsName=group1RadioButtons.get(indexStatus).getAttribute("value");
				String radioButtonsStatus1=group1RadioButtons.get(indexStatus).getAttribute("checked");
				
				String group2RadioButtonsName=group2RadioButtons.get(indexStatus).getAttribute("value");
				String radioButtonsStatus2=group2RadioButtons.get(indexStatus).getAttribute("checked");
				
				System.out.println(index+" - "+group1RadioButtonsName+" - "+radioButtonsStatus1+"   "+indexStatus+" - "+group2RadioButtonsName+" - "+radioButtonsStatus2);
				
			}
			
		}
		driver.quit();
	}
	
}

