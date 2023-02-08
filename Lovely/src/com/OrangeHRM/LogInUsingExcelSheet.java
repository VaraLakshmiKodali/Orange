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
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInUsingExcelSheet
{
	public static void main(String[] args) throws IOException 
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement LogInPanel=driver.findElement(By.id("logInPanelHeading"));
		String LogInPanelText=LogInPanel.getText();
		System.out.println(LogInPanelText);
				
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/UserNamePasswordORhm.xlsx");

		XSSFWorkbook workbook=new XSSFWorkbook(File);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		Row row=sheet.getRow(1);

		Cell rowofcell=row.getCell(0);
		String usernametextdata=rowofcell.getStringCellValue();
		
		WebElement usernametext=driver.findElement(By.id("txtUsername"));  
		usernametext.sendKeys(usernametextdata);
		   
		System.out.println(usernametextdata);

		Cell rowofcell1=row.getCell(1);
		String passwordtextdata=rowofcell1.getStringCellValue();
		
		WebElement passwordtextdata1=driver.findElement(By.name("txtPassword"));
		passwordtextdata1.sendKeys(passwordtextdata);
		   
		System.out.println(passwordtextdata);
		
		WebElement Logintext=driver.findElement(By.id("btnLogin"));
		Logintext.click();
		
		File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/LogInPageScreenShot.png"));
		
		String ExpectedUrl="dashboard";
		System.out.println("The Expected Url is :- "+ExpectedUrl);
		String ActualUrl=driver.getCurrentUrl();
		if(ActualUrl.contains(ExpectedUrl))
		{
			System.out.println("Log In Successful");
			
			sheet.getRow(1).createCell(2).setCellValue("PASS");	
			
			FileOutputStream File1=new FileOutputStream("./src/com/ExcelSheets/UserNamePasswordORhm.xlsx");
			workbook.write(File1);
			
		}
		else
		{
			System.out.println("Log In Failed");
			
			sheet.getRow(1).createCell(2).setCellValue("FAIL");	
			
			FileOutputStream File1=new FileOutputStream("./src/com/ExcelSheets/UserNamePasswordORhm.xlsx");
			workbook.write(File1);
			
		}
		
		
		workbook.close();				
		driver.quit();
	}
}
