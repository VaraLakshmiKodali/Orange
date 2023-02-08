package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Login 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		String Expected_OrangeHrmHomePageTitle="OrangeHRM";
		System.out.println("The Expected Orange Hrm Home Page Title is :- "+Expected_OrangeHrmHomePageTitle);
		String Actual_OrangeHrmHomePageTitle=driver.getTitle();
		System.out.println("The Actual Orange Hrm Home Page Title is :- "+Actual_OrangeHrmHomePageTitle);
		if(Actual_OrangeHrmHomePageTitle.equals(Expected_OrangeHrmHomePageTitle))
		{
			System.out.println("The Title of Orange Hrm Home Page Title is Matched - PASS");
		}
		else
		{
			System.out.println("The Title of Orange Hrm Home Page Title is NOT Matched - FAIL");
		}
		
		/*<input name="txtUsername" id="txtUsername" type="text">
		 * locator=id
		 * selector= txtUsername
		 */
		
		String UserNameTestData="VaraLakshmi";
		By UserNameL=By.id("txtUsername");
		WebElement UserName=driver.findElement(UserNameL);
		UserName.sendKeys(UserNameTestData);
		
		/*<input name="txtPassword" id="txtPassword" autocomplete="off" type="password">
		 * locator=id
		 * selector=txtPassword
		 */
		
		String PasswordTestData="LovelyVaram@1998";
		By PasswordL=By.id("txtPassword");
		WebElement Password=driver.findElement(PasswordL);
		Password.sendKeys(PasswordTestData);
		
		/*<input type="submit" name="Submit" class="button" id="btnLogin" value="LOGIN">
		 * locator=class
		 * selector=button
		 */
		
		By LogInL=By.className("button");
		WebElement Login=driver.findElement(LogInL);
		Login.click();

		driver.quit();
	}
}
