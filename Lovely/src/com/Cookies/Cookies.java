package com.Cookies;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Cookies 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://www.tsrtconline.in/oprs-web/";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		Set<Cookie>tsRtcCookies=driver.manage().getCookies();
		
		int tsRtcCookiesCount=tsRtcCookies.size();
		System.out.println("The no.of Cookies in TsRtc HomePage : "+tsRtcCookiesCount);
		
		Iterator<Cookie>tsRtcIT=tsRtcCookies.iterator();
		while(tsRtcIT.hasNext())
		{
			
			Cookie cookie=tsRtcIT.next();
			System.out.println(cookie.getDomain()+" - "+cookie.getName());
			
		}
		
		driver.manage().deleteAllCookies();
		tsRtcCookies=driver.manage().getCookies();
		tsRtcCookiesCount=tsRtcCookies.size();
		System.out.println("The No.Of Cookies in TsRtc HomePage : "+tsRtcCookiesCount);
		driver.quit();
	}
}
