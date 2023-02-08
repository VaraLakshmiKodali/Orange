package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInFunctionality 
{
	public static void main(String[] args)
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		String Expected_OrangeHrmTitle="OrangeHRM";
		System.out.println("The Expected Title of Orange HRM Home Page is :- "+Expected_OrangeHrmTitle);
		String Actual_OrangeHrmTitle=driver.getTitle();
		System.out.println("The Actual Title of Orange HRM Home Page is :- "+Actual_OrangeHrmTitle);
		if(Actual_OrangeHrmTitle.equals(Expected_OrangeHrmTitle))
		{
			System.out.println("The Title Of Orange HRM Home Page is Matched - PASS");
		}
		else
		{
			System.out.println("The Title Of Orange HRM Home Page is NOT Matched - FAIL");
		}
		
		/*<input name="txtUsername" id="txtUsername" type="text">
		 * locator=id
		 * selector= txtUsername
		 */
		driver.findElement(By.id("txtUsername")).sendKeys("VaraLakshmi");
		/*<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		 * locator=id
		 * selector=txtPassword
		 */
		driver.findElement(By.id("txtPassword")).sendKeys("LovelyVaram@1998");
		/*<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		 * locator=class
		 * selector=button
		 */
		driver.findElement(By.className("button")).click();
		
		driver.quit();
		}
}
