package com.GmailAutomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SignInAutomation 
{
	public static void main(String[] args)
	{
		String ApplicationUrl="https://Google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		String Expected_GoogleHomePageTitle="Google";
		System.out.println("The Expected Title of Google Home Page is :- "+Expected_GoogleHomePageTitle);
		String Actual_GoogleHomePageTitle=driver.getTitle();
		System.out.println("The Actual Title of Google Home Page is :- "+Actual_GoogleHomePageTitle);
		if(Actual_GoogleHomePageTitle.equals(Expected_GoogleHomePageTitle))
		{
			System.out.println("The Title is Matched - PASS");
		}
		else
		{
			System.out.println("The Title is NOT Matched - FAIL");
		}
		String Expected_GoogleHomePageUrl="google.com";
		System.out.println("The Expected Google Home Page Url is :- "+Expected_GoogleHomePageUrl);
		String Actual_GoogleHomePageUrl=driver.getCurrentUrl();
		System.out.println("The Actual Google Home Page Url is :- "+Actual_GoogleHomePageUrl);
		if(Actual_GoogleHomePageUrl.contains(Expected_GoogleHomePageUrl))
		{
			System.out.println("The Url Matched - PASS ");
		}
		else
		{
			System.out.println("The Url NOT Matched - FAIL");
		}
		
		//<a class="gb_j" data-pid="23" href="https://mail.google.com/mail/&amp;ogbl" target="_top">Gmail</a>
		 
		
		By GmailL=By.linkText("Gmail");
		WebElement Gmail=driver.findElement(GmailL);
		Gmail.click();
		/*
		 * <a class="button
           
           
           
            button--medium
           
            button--mobile-before-hero-only
           " href="https://accounts.google.com/AccountChooser/signinchooser?service=mail&amp;continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&amp;flowName=GlifWebSignIn&amp;flowEntry=AccountChooser" data-action="sign in" data-category="cta" data-label="header">Sign in</a>
		 */
		
		By SignInL=By.linkText("Sign in");
		WebElement SignIn=driver.findElement(SignInL);
		SignIn.click();
		
		//<input type="email" class="whsOnd zHQkBf" jsname="YPqjbf" autocomplete="username" spellcheck="false" tabindex="0" aria-label="Email or phone" name="identifier" value="" autocapitalize="none" id="identifierId" dir="ltr" data-initial-dir="ltr" data-initial-value="">
		 
		
		String EmailOrPhone_TestData="varalakshmikodali111@gmail.com";
		By EmailOrPhoneL=By.id("identifierId");
		WebElement EmailOrPhone=driver.findElement(EmailOrPhoneL);
		EmailOrPhone.sendKeys(EmailOrPhone_TestData);
		
		//<span jsname="V67aGc" class="VfPpkd-vQzf8d">Next</span>
		By NextL=By.linkText("Next");
		WebElement Next=driver.findElement(NextL);
		Next.click();
		
		
		driver.quit();
		
		
	}
}
