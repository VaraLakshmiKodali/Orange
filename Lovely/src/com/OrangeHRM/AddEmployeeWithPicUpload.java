package com.OrangeHRM;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeeWithPicUpload 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		WebDriver driver;
		System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
		driver=new EdgeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		By LogInPanelL=By.id("logInPanelHeading");
		WebElement LogInPanel=driver.findElement(LogInPanelL);
		
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/AddEmployee.xlsx");
		
		XSSFWorkbook WorkBook=new XSSFWorkbook(File);
		
		XSSFSheet Sheet=WorkBook.getSheet("Sheet1");
		
		Row Row1=Sheet.getRow(1);
		Cell RowOfCell=Row1.getCell(0);
		
		String ExpectedLogInPanelText=RowOfCell.getStringCellValue();
		System.out.println(ExpectedLogInPanelText);
		
		String ActualLogInPanelText=LogInPanel.getText();
		Row1.createCell(1).setCellValue(ActualLogInPanelText);
		System.out.println("The Text of The LogIn Panel is :- "+ActualLogInPanelText);
		
		if(ActualLogInPanelText.equals(ExpectedLogInPanelText))
		{
			
			System.out.println("The Text Matched - Pass");
			Row1.createCell(2).setCellValue("Pass");
			
		}
		else
		{
			
			System.out.println("The Text is NOT Matched - Fail");
			Row1.createCell(2).setCellValue("Fail");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
						
		}
		
		String ExpectedLogInPageTitle=driver.getTitle();
		Row1.createCell(3).setCellValue(ExpectedLogInPageTitle);
		System.out.println("The Expected LogIn Page Title is :- "+ExpectedLogInPageTitle);
		
		RowOfCell=Row1.getCell(4);
		String ActualLogInPageTitle=RowOfCell.getStringCellValue();
		
		System.out.println("The Actual LogIn Page Title is :- "+ActualLogInPageTitle);
		if(ActualLogInPageTitle.equals(ExpectedLogInPageTitle))
		{
			
			System.out.println("The Title Of The Page Matched - Pass");
			Row1.createCell(5).setCellValue("Pass");
			
		}
		else
		{
		
			System.out.println("The Title Of The Page NOT Matched - Fail");
			Row1.createCell(5).setCellValue("Fail");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
			
		}
		
		String UserNameTestData="VaraLakshmi";
		By UserNameL=By.id("txtUsername");
		WebElement UserName=driver.findElement(UserNameL);
		UserName.sendKeys(UserNameTestData);
		Row1.createCell(6).setCellValue(UserNameTestData);
		
		String PasswordTestData="LovelyVaram@1998";
		By PasswordL=By.id("txtPassword");
		WebElement Password=driver.findElement(PasswordL);
		Password.sendKeys(PasswordTestData);
		Row1.createCell(7).setCellValue(PasswordTestData);
		
		By LogInL=By.className("button");
		WebElement Login=driver.findElement(LogInL);
		Login.click();
		
		String ExpectedHomePageText=Row1.getCell(8).getStringCellValue();
		System.out.println("The Home Page Text is :-"+ExpectedHomePageText);
		
		By HomePageTextL=By.id("menu_admin_viewAdminModule");
		WebElement HomePageText=driver.findElement(HomePageTextL);
		String ActualHomePageText=HomePageText.getText();
		System.out.println(ActualHomePageText);
		Row1.createCell(9).setCellValue(ActualHomePageText);
		
		if(ActualHomePageText.equals(ExpectedHomePageText))
		{
			
			System.out.println("Home Page Text Matched - Pass");
			Row1.createCell(10).setCellValue("Pass");
			
		}
		else
		{
			
			System.out.println("Home Page Text NOT Matched - Fail");
			Row1.createCell(10).setCellValue("Fail");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
						
		}
		
		By PIMLocator=By.id("menu_pim_viewPimModule");
		WebElement PIM=driver.findElement(PIMLocator);
		
		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();
		
		By AddEmployeeL=By.linkText("Add Employee");
		WebDriverWait Wait=new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(AddEmployeeL));
		
		WebElement AddEmployee=driver.findElement(AddEmployeeL);
		AddEmployee.click();
		
		String ExpectedAddEmployeePageText=Row1.getCell(11).getStringCellValue();
		System.out.println(ExpectedAddEmployeePageText);
		
		By ActualAddEmployeePageTextL=By.className("hasTopFieldHelp");
		WebElement ActualAddEmployeePage=driver.findElement(ActualAddEmployeePageTextL);
		String ActualAddEmployeePageText=ActualAddEmployeePage.getText();
		Row1.createCell(12).setCellValue(ActualAddEmployeePageText);
		
		System.out.println(ActualAddEmployeePageText);
		
		if(ActualAddEmployeePageText.equals(ExpectedAddEmployeePageText))
		{
			
			System.out.println("The Text Matched - Pass");
			Row1.createCell(13).setCellValue("Pass");
						
		}
		else
		{
			
			System.out.println("The Text is NOT Matched - Fail");
			Row1.createCell(13).setCellValue("Fail");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
			
		}
		
		String firstNameData="Rajanala";
		By firstNameL=By.id("firstName");
		WebElement firstName=driver.findElement(firstNameL);
		firstName.sendKeys(firstNameData);
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys("Tirupati").build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys("Reddy").build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		
		By employeeIdL=By.id("employeeId");
		WebElement employeeId=driver.findElement(employeeIdL);
		employeeId.getAttribute("value");
	
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		
		Thread.sleep(5000);
		
		java.lang.Runtime.getRuntime().exec("C:\\Users\\INDIAN\\OneDrive\\Desktop\\Eclipse\\OrangeHRM_DDT\\ImageexeFile\\ImgeProperty.exe");
		
		Thread.sleep(5000);
		
		By saveButtonL=By.id("btnSave");
		WebElement save=driver.findElement(saveButtonL);
		save.click();
		
		By empPicL=By.id("empPic");
		WebElement empPic=driver.findElement(empPicL);
		
		boolean flag=empPic.isDisplayed();
		if(flag)
		{
			
			System.out.println("Pass");
			
		}
		else
		{
		
			System.out.println("Fail");
			
		}
		
		FileOutputStream file=new FileOutputStream("./src/com/ExcelSheets/AddEmployee.xlsx");
		WorkBook.write(file);
		WorkBook.close();
		driver.quit();
		
	}
}
