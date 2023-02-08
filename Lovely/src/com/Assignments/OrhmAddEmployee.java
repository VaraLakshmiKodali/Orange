package com.Assignments;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrhmAddEmployee 
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
		
		/*
		 * <a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/viewPimModule" id="menu_pim_viewPimModule" class="firstLevelMenu"><b>PIM</b></a>
		 */
		
		
		By PIML=By.id("menu_pim_viewPimModule");
		WebElement PIM=driver.findElement(PIML);
		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();
		
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/pim/addEmployee" id="menu_pim_addEmployee">Add Employee</a>
		By AddEmployeeL=By.linkText("Add Employee");
		WebDriverWait Wait=new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(AddEmployeeL));
		
		WebElement AddEmployee=driver.findElement(AddEmployeeL);
		AddEmployee.click();
		
		
		//<input class="formInputText" maxlength="30" type="text" name="firstName" id="firstName">
		
		
		String FirstNameTestData="Kodali";
		By FirstNameL=By.id("firstName");
		WebElement FirstName=driver.findElement(FirstNameL);
		FirstName.sendKeys(FirstNameTestData);
		System.out.println(" The First Name is :- "+FirstNameTestData);

		
		//<input class="formInputText" maxlength="30" type="text" name="middleName" id="middleName">
		String MiddleNameTestData="Vara Lakshmi";
		By MiddleNameL=By.id("middleName");
		WebElement MiddleName=driver.findElement(MiddleNameL);
		MiddleName.sendKeys(MiddleNameTestData);
		System.out.println(" The Middle Name is :- "+MiddleNameTestData);
		
		//<input class="formInputText" maxlength="30" type="text" name="lastName" id="lastName">
		
		String LastNameTestData="Netha";
		By LastNameL=By.id("lastName");
		WebElement LastName=driver.findElement(LastNameL);
		LastName.sendKeys(LastNameTestData);
		System.out.println(" The Last Name is :- "+LastNameTestData);

		
		
		//<input class="formInputText" maxlength="10" type="text" name="employeeId" value="0020" id="employeeId">
		
		
		By EmployeeIdL=By.id("employeeId");
		WebElement EmployeeID=driver.findElement(EmployeeIdL);
		String AutoUpdatedEmployeeId=EmployeeID.getAttribute("value");
		System.out.println(" Actual Employee Id :- "+AutoUpdatedEmployeeId);
		
	
		
		//<input type="button" class="" id="btnSave" value="Save">
		
		By SaveL=By.id("btnSave");
		WebElement Save=driver.findElement(SaveL);
		Save.click();
		
		//<input value="Kodali" type="text" name="personal[txtEmpFirstName]" class="block default editable" maxlength="30" title="First Name" id="personal_txtEmpFirstName" disabled="disabled">
		
			
		
		String Expected_FirstName="Kodali";
		System.out.println("The Expected First Name is :- "+Expected_FirstName);
		
		By firstNameL=By.id("personal_txtEmpFirstName");
		WebElement Actual_FirstNameElement=driver.findElement(firstNameL);
		String	ActualFirstName=Actual_FirstNameElement.getAttribute("value");
		System.out.println(" The Actual First Name is :- "+ActualFirstName);
		if(ActualFirstName.equals(FirstNameTestData))
		{
			System.out.println(" The Expected First Name is Matched - PASS");
		}
		else
		{
			System.out.println("The Expected First Name is NOT Matched - FAIL");
		}
		
		//<input value="Vara Lakshmi" type="text" name="personal[txtEmpMiddleName]" class="block default editable" maxlength="30" title="Middle Name" id="personal_txtEmpMiddleName" disabled="disabled">
		
		String Expected_MiddleName="Vara Lakshmi";
		System.out.println("The Expected Middle Name is :- "+Expected_MiddleName);
		By middleNameL=By.id("personal_txtEmpMiddleName");
		WebElement Actual_MiddleNameElement=driver.findElement(middleNameL);
		String Actual_MiddleName=Actual_MiddleNameElement.getAttribute("value");
		System.out.println("The Actual Middle Name is :- "+Actual_MiddleName);
		if (Actual_MiddleName.equals(MiddleNameTestData))
		{
			System.out.println("The Expected Middle Name is Matched - PASS");
		}
		else
		{
			System.out.println("The Actual First Name is Not Matched - FAIL");
		}
		
		//<input value="Netha" type="text" name="personal[txtEmpLastName]" class="block default editable" maxlength="30" title="Last Name" id="personal_txtEmpLastName" disabled="disabled">
		
		String Expected_LastName="Netha";
		System.out.println("The Expected Last Name is :- "+Expected_LastName);
		By lastNameL=By.id("personal_txtEmpLastName");
		WebElement Actual_LastNameElement=driver.findElement(lastNameL);
		String Actual_LastName=Actual_LastNameElement.getAttribute("value");
		System.out.println("The Actual Last Name is :- "+Actual_LastName);
		if(Actual_LastName.equals(LastNameTestData))
		{
			System.out.println("The Expected Last Name is Matched - PASS");
		}
		else
		{
			System.out.println("The Expected Last Name is NOT Matched - FAIL");
		}
		
		//<input value="0016" type="text" name="personal[txtEmployeeId]" maxlength="10" class="editable" id="personal_txtEmployeeId" disabled="disabled">
		
		
		By EmployeeIdLocator=By.id("personal_txtEmployeeId");
		WebElement Actual_EmployeeIdNumber=driver.findElement(EmployeeIdLocator);
		String Actual_EmployeeIDNumber=Actual_EmployeeIdNumber.getAttribute("value");
		System.out.println("The Actual Last Name is :- "+Actual_EmployeeIDNumber);
		if(Actual_EmployeeIDNumber.equals(AutoUpdatedEmployeeId))
		{
			System.out.println("The Employee Id is Matched - PASS");
		}
		else
		{
			System.out.println("The Employee Id is NOT Matched - FAIL");
		}
		
		
				
		//<a href="#" id="welcome" class="panelTrigger">Welcome Admin</a>
		
		By WelcomeL=By.linkText("Welcome Admin");
		WebElement WelcomeAdmin=driver.findElement(WelcomeL);
		WelcomeAdmin.click();
		
		//<a href="/orangehrm-4.2.0.1/symfony/web/index.php/auth/logout">Logout</a>
		 

		By LogOutL=By.linkText("Logout");
		WebElement LogOut=driver.findElement(LogOutL);
		LogOut.click();
				
		driver.quit();

	}
}
