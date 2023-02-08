package com.OrangeHRM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Orhm 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		//Validating The Title
		
		String Expected_OrangeHrmTitle="OrangeHrm";
		System.out.println("The Expected Orange Hrm Title is :-"+Expected_OrangeHrmTitle);
		String Actual_OrangeHrmTitle=driver.getTitle();
		System.out.println("The Actual Orange Hrm Title is :-"+Actual_OrangeHrmTitle);
		if(Actual_OrangeHrmTitle.equals(Expected_OrangeHrmTitle))
		{
			System.out.println("The Title Of the Orange Hrm is Matched - PASS");
		}
		else
		{
			System.out.println("The Title Of the Orange Hrm is NOT Matched - FAIL");
		}

		//Validating the Url Address
		
		String Expected_OrangeHrmUrl="orangehrm-4.2.0.1";
		System.out.println("The Expected Url Address is :-"+Expected_OrangeHrmUrl);
		String Actual_OrangeHrmUrl=driver.getCurrentUrl();
		System.out.println("The Actual Url Address is :-"+Actual_OrangeHrmUrl);
		if(Actual_OrangeHrmUrl.contains(Expected_OrangeHrmUrl))
		{
			System.out.println("The Actual Orange Hrm Url contains The Expected Orange Hrm Url - PASS");
		}
		else
		{
			System.out.println("The Actual Orange Hrm Url Does NOT contains The Expected Orange Hrm Url - FAIL");
		}
		
		//Inspecting and Validating the Login Panel
		
		//<div id="logInPanelHeading">LOGIN Panel</div>
		// Text Data in Login Panel
	
		String Expected_LogInTextOfOhrm="LOGIN Panel";
		System.out.println("The Expected Text in Log In Panel is :- "+Expected_LogInTextOfOhrm);
		
		By LogInL=By.id("logInPanelHeading");
		WebElement LogIn=driver.findElement(LogInL);
		String Actual_LogInTextOfOhrm=LogIn.getText();
		System.out.println("The Actual Text in Log In Panel is :- "+Actual_LogInTextOfOhrm);
		if(Actual_LogInTextOfOhrm.equals(Expected_LogInTextOfOhrm))
		{
			System.out.println("The Text is Matched - PASS");
		}
		else
		{
			System.out.println("The Text is NOT Matched - FAIL");
		}
		
		// Login With Valid Test Data
		
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
		
		By LoginL=By.className("button");
		WebElement Login=driver.findElement(LoginL);
		Login.click();
		
		By WelcomeL=By.linkText("Welcome Admin");
		WebElement WelcomeAdmin=driver.findElement(WelcomeL);
		WelcomeAdmin.click();
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		 
			
		
		By LogOutL=By.linkText("Logout");
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeL));
	
		
		WebElement LogOut=driver.findElement(LogOutL);
		LogOut.click();
		
		//Validating The Text in Log In Panel and Log In Page After Log Out and  
		
		String Expected_LogInPanelTextAfterLogOut="LogIn Panel";
		System.out.println("The Expected Log In Panel Text After Log Out is :- "+Expected_LogInPanelTextAfterLogOut);
		
		By LogInAfterLogOutL=By.id("logInPanelHeading");
		WebElement LogIn1=driver.findElement(LogInAfterLogOutL);
		String Actual_LogInTextAfterLogOut=LogIn1.getText();
		System.out.println("The Actual Text Of Log In Panel After Log Out is :- "+Actual_LogInTextAfterLogOut);
		if(Actual_LogInTextAfterLogOut.contains(Expected_LogInPanelTextAfterLogOut))
		{
			System.out.println("The Actual Text contains Expected Text - PASS");
		}
		else
		{
			System.out.println("The Actual Text Does NOT contains Expected Text - FAIL");
		}
		driver.quit();
	}
}

