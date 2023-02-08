package com.OrangeHrmApplicationTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.OrangeHrmApplication.BaseTest;

public class OrangeHrm_LogInTest extends BaseTest
{

	@Test(priority=1)
	public void logInPageValidation()
	{
		
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
		
	}

	@Test(priority=2)
	public void logInTest()
	{
		
		String UserNameTestData="VaraLakshmi";
		By UserNameL=By.id("txtUsername");
		WebElement UserName=driver.findElement(UserNameL);
		UserName.sendKeys(UserNameTestData);
		
		String PasswordTestData="LovelyVaram@1998";
		By PasswordL=By.id("txtPassword");
		WebElement Password=driver.findElement(PasswordL);
		Password.sendKeys(PasswordTestData);		
		
		By LogInL=By.className("button");
		WebElement LogIn=driver.findElement(LogInL);
		LogIn.click();
		
	}
	
	@Test(priority=3)
	public void logOutTest()
	{
		
		By WelcomeL=By.id("welcome");
		WebElement WelcomeAdmin=driver.findElement(WelcomeL);
		WelcomeAdmin.click();
		
		By LogOutL=By.linkText("Logout");
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeL));

		WebElement LogOut=driver.findElement(LogOutL);
		LogOut.click();

	}
	
}
