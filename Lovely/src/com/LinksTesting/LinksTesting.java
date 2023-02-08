package com.LinksTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTesting 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://Google.com";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		/*<a class="gb_7 gb_8 gb_de gb_dd" 
		 * href="https://accounts.google.com/ServiceLogin?hl=en&amp;
		 * passive=true&amp;continue=https://www.google.com/&amp;ec=GAZAmgQ" 
		 * target="_top">Sign in</a> 
		 */
		By SignInL=By.linkText("Sign in");
		WebElement SignIn=driver.findElement(SignInL);
		SignIn.click();
		driver.quit();
	
	}
}
