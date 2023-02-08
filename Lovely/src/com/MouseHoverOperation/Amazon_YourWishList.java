package com.MouseHoverOperation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon_YourWishList 
{
	public static void main(String[] args) 
	{
		String ApplicationUrl="https://Amazon.in";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);

		//Maximizing the Window
		driver.manage().window().maximize();
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*<a href="https://www.amazon.in/ap/signin?openid.pape.max_auth_age=0&amp;openid.return_to=https%3A%2F%2Fwww.amazon.in%2F%3Fref_%3Dnav_ya_signin&amp;openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;openid.assoc_handle=inflex&amp;openid.mode=checkid_setup&amp;openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&amp;openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&amp;" class="nav-a nav-a-2   nav-progressive-attribute" data-nav-ref="nav_ya_signin" data-nav-role="signin" data-ux-jq-mouseenter="true" id="nav-link-accountList" tabindex="0" data-csa-c-type="link" data-csa-c-slot-id="nav-link-accountList" data-csa-c-content-id="nav_ya_signin" data-csa-c-id="ejrgc7-ip30f2-m0ybua-5bbm80">
		  <div class="nav-line-1-container"><span id="nav-link-accountList-nav-line-1" class="nav-line-1 nav-progressive-content">Hello, sign in</span></div>
		  <span class="nav-line-2 ">Account &amp; Lists<span class="nav-icon nav-arrow" style="visibility: visible;"></span>
		  </span>
		</a>
		id="nav_link_accountList"
		selector=sign in
		*/
		
		By HelloSignInL=By.id("nav-link-accountList-nav-line-1");
		WebElement HelloSignIn=driver.findElement(HelloSignInL);
		
		//Actions Class
		Actions action=new Actions(driver);
		action.moveToElement(HelloSignIn).build().perform();
		
		By YourWishListL=By.linkText("Your Wish List");
		
		WebDriverWait Wait=new WebDriverWait(driver, 20);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(YourWishListL));
		
		WebElement YourWishList=driver.findElement(YourWishListL);
		YourWishList.click();
		driver.quit();
	}
}
