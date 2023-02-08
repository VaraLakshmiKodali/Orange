package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrangeHrmApplicationMethods 
{
	public static WebDriver driver;
	String applicationUrlAddress="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/dashboard";
		
	@Given("^User should open the chrome browser in the system$")
	public void user_should_open_the_chrome_browser_in_the_system() 
	{
		
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver = new ChromeDriver();
				
	}

	@When("^User enters OrangeHrm Application Url Address$")
	public void user_enters_OrangeHrm_Application_Url_Address()
	{
	
		driver.manage().deleteAllCookies();
		driver.get(applicationUrlAddress);
	
		driver.manage().window().maximize();

		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Then("^User should be navigated to OrangeHrm Application LogIn Page$")
	public void user_should_be_navigated_to_OrangeHrm_Application_LogIn_Page()
	{
		
		String ExpectedLogInPageUrl="orangehrm";
		System.out.println("The Expected LogIn Page Url :- "+ExpectedLogInPageUrl);
		String ActualLogInPageUrl=driver.getCurrentUrl();
		
		System.out.println("The Actual LogIn Page Url :- "+ActualLogInPageUrl);
		if(ActualLogInPageUrl.contains(ExpectedLogInPageUrl))
		{
			
			System.out.println(" LogIn Page Url Matched - Pass");
			
		}
		else
		{
			
			System.out.println(" LogIn Page Url NOT Matched - Fail");
						
		}

	}
		

	@Then("^User should close the OrangeHrm Application with the browser$")
	public void user_should_close_the_OrangeHrm_Application_with_the_browser() 
	{
	    
		driver.quit();
		
	}

	@Then("^User should enter username and password and click on logIn button$")
	public void user_should_enter_username_and_password_and_click_on_logIn_button() 
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
		WebElement Login=driver.findElement(LogInL);
		Login.click();
		
	}

	@Then("^User should be able to navigate to OrangeHrm Application Home Page$")
	public void user_should_be_able_to_navigate_to_OrangeHrm_Application_Home_Page() 
	{
		
		By adminLocator=By.id("menu_admin_viewAdminModule");
		WebElement admin=driver.findElement(adminLocator);
		String actualAdminText=admin.getText();
		
		String expectedAdminText="Admin";
		
		if (actualAdminText.equals(expectedAdminText))
		{
			
			System.out.println("The Text Matched - Pass");
			
		} 
		else 
		{

			System.out.println("The Text NOT Matched - Fail");
			
		}
	}

	@Then("^User should enter \"([^\"]*)\" and \"([^\"]*)\" and click on logIn button$")
	public void user_should_enter_and_and_click_on_logIn_button(String UserName, String Password)  
	{
				
		By UserNameL=By.id("txtUsername");
		WebElement userName=driver.findElement(UserNameL);
		userName.sendKeys(UserName);
		
		
		By PasswordL=By.id("txtPassword");
		WebElement password=driver.findElement(PasswordL);
		password.sendKeys(Password);

		By LogInL=By.className("button");
		WebElement Login=driver.findElement(LogInL);
		Login.click();
		
	}
	
	@Then("^User should logout from the OrangeHrm Application$")
	public void user_should_logout_from_the_OrangeHrm_Application() 
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

	@Then("^User  should close the OrangeHrm Application with the browser$")
	public void user_should_close_the_OrangeHrm_Application_with_the_browser1() 
	{
	
		driver.quit();
		
	}
	
}
