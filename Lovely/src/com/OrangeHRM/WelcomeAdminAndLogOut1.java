package com.OrangeHRM;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomeAdminAndLogOut1
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		// Maximizing The Window
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String ExpectedOrangeHRMHomePageTitle="OrangeHRM";
		System.out.println("The Expected Title of Orange HRM Home Page is :- "+ExpectedOrangeHRMHomePageTitle);
		String ActualOrangeHRMHomePageTitle=driver.getTitle();
		System.out.println("The Actial Orange HRM Home Page Title is :- "+ActualOrangeHRMHomePageTitle);
		if(ActualOrangeHRMHomePageTitle.equals(ExpectedOrangeHRMHomePageTitle))
		{
			System.out.println("The Title is Matched - PASS");
		}
		else
		{
			System.out.println("The Title is NOT Matched - FAIL");
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
		WebElement LogIn=driver.findElement(LogInL);
		LogIn.click();
		
		
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		
		By WelcomeL=By.linkText("Welcome Admin");
		WebElement WelcomeAdmin=driver.findElement(WelcomeL);
		WelcomeAdmin.click();
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		 

		By LogOutL=By.linkText("Logout");
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeL));

		WebElement LogOut=driver.findElement(LogOutL);
		LogOut.click();
		driver.quit();

	}
}
