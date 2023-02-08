package com.Assignments;

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
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogInTest 
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
		
		FileInputStream File= new FileInputStream("./src/com/ExcelSheets/LogInTest.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(File);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		Row row1=sheet.getRow(1);
		Cell rowOfCell=row1.getCell(0);
		
		String ExpectedLogInPanelText=rowOfCell.getStringCellValue();
		System.out.println(ExpectedLogInPanelText);
		
		String ActualLogInPanelText=LogInPanel.getText();
		row1.createCell(1).setCellValue(ActualLogInPanelText);
		System.out.println("The Text of The LogIn Panel is :- "+ActualLogInPanelText);
		
		if(ActualLogInPanelText.equals(ExpectedLogInPanelText))
		{
			
			System.out.println("The Text Matched - Pass");
			row1.createCell(2).setCellValue("Pass");
						
		}
		else
		{
			
			System.out.println("The Text is NOT Matched - Fail");
			row1.createCell(2).setCellValue("Fail");
			
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));
			
		}
		
		String ExpectedLogInPageTitle=row1.getCell(3).getStringCellValue();
		System.out.println("The Expected LogIn Page Title is :- "+ExpectedLogInPageTitle);
		
		String ActualLogInPageTitle=driver.getTitle();
		row1.createCell(4).setCellValue(ExpectedLogInPageTitle);
		
		System.out.println("The Actual LogIn Page Title is :- "+ActualLogInPageTitle);
		if(ActualLogInPageTitle.equals(ExpectedLogInPageTitle))
		{
			
			System.out.println("The Title Of The Page Matched - Pass");
			row1.createCell(5).setCellValue("Pass");
			
		}
		else
		{
		
			System.out.println("The Title Of The Page NOT Matched - Fail");
			row1.createCell(5).setCellValue("Fail");
			
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));
			
		}
		
		
		String ExpectedLogInPageUrl=row1.getCell(6).getStringCellValue();
		System.out.println("The Expected LogIn Page Url :- "+ExpectedLogInPageUrl);
		String ActualLogInPageUrl=driver.getCurrentUrl();
		row1.createCell(7).setCellValue(ActualLogInPageUrl);
		System.out.println("The Actual LogIn Page Url :- "+ActualLogInPageUrl);
		if(ActualLogInPageUrl.contains(ExpectedLogInPageUrl))
		{
			
			System.out.println(" LogIn Page Url Matched - Pass");
			row1.createCell(8).setCellValue("Pass");
			
		}
		else
		{
			
			System.out.println(" LogIn Page Url NOT Matched - Fail");
			row1.createCell(8).setCellValue("Fail");
			
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));
		}
		
		String array[][]=new String[4][2];
		
		array[0][0]="Mukesh";
		array[0][1]="Mukesh1234";
		array[1][0]="Naveen";
		array[1][1]="LovelyVaram@1998";
		array[2][0]="VaraLakshmi";
		array[2][1]="Jashwanth";
		array[3][0]="VaraLakshmi";
		array[3][1]="LovelyVaram@1998";
		
		
		row1.createCell(9).setCellValue(array[0][0]);
		row1.createCell(10).setCellValue(array[0][1]);
		
		Row row2=sheet.createRow(2);
		
		row2.createCell(9).setCellValue(array[1][0]);
		row2.createCell(10).setCellValue(array[1][1]);
		
		Row row3=sheet.createRow(3);
		
		row3.createCell(9).setCellValue(array[2][0]);
		row3.createCell(10).setCellValue(array[2][1]);
		
		Row row4=sheet.createRow(4);
		
		row4.createCell(9).setCellValue(array[3][0]);
		row4.createCell(10).setCellValue(array[3][1]);
		
		for (int rowindex=1;rowindex<=sheet.getLastRowNum();rowindex++)

		{
		
			for(int rowofcellindex=9;rowofcellindex<10;rowofcellindex++)
		   
			{
				Thread.sleep(5000);
				
				Row Username=sheet.getRow(rowindex);
				Cell Username1=Username.getCell(rowofcellindex);
				String row1Username=Username1.getStringCellValue();
				System.out.println(row1Username);
		       
				By userNameL=By.id("txtUsername");
				WebElement userName=driver.findElement(userNameL);
				userName.sendKeys(row1Username);

				for (int rowofcellindex1=10;rowofcellindex1<11;rowofcellindex1++)
				{
					Row Password1=sheet.getRow(rowindex);//first row
					Cell Password=Password1.getCell(rowofcellindex1);
					String row1Password=Password.getStringCellValue();
					System.out.println(row1Password);

					By PasswordL=By.name("txtPassword");
					WebElement password=driver.findElement(PasswordL);
					password.sendKeys(row1Password);

					By LoginL=By.className("button");
					WebElement Login=driver.findElement(LoginL);
					Login.click();
			
				}
				
				try 
				{
					 By AdminL=By.id("menu_admin_viewAdminModule");
					 WebElement HomePage=driver.findElement(AdminL);
						
					 String ExpectedText="Admin";
					 sheet.getRow(rowindex).createCell(11).setCellValue(ExpectedText);
					 					
					 String ActualHomePageText=HomePage.getText();
					
					 sheet.getRow(4).createCell(12).setCellValue(ActualHomePageText);
					 
					 sheet.getRow(rowindex).createCell(13).setCellValue("Pass");
					 System.out.println("Home Page Text Matched - Pass");
					 
					 
				 } 
				catch (Exception e) 
				{
					
					 String ExpectedPageText="Admin";
					 sheet.getRow(rowindex).createCell(11).setCellValue(ExpectedPageText);
					 
					 By InvalidCredentialL=By.id("spanMessage");
					 WebElement InvalidCredentials=driver.findElement(InvalidCredentialL);
					 String ActualInvalidText=InvalidCredentials.getText();
					 sheet.getRow(rowindex).createCell(12).setCellValue(ActualInvalidText);
					 
					 sheet.getRow(rowindex).createCell(13).setCellValue("Fail");
					 System.out.println("Home Page Text NOT Matched - Fail");
					 				 
					 File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					 FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/"+rowindex+".png"));
					 
				 }

			}
			
			System.out.println();
		}
		
		By WelcomeAdminL=By.id("welcome");
		WebElement WelcomeAdmin=driver.findElement(WelcomeAdminL);
		WelcomeAdmin.click();
		
		WebDriverWait Wait=new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeAdminL));
		
		WebElement LogOut=driver.findElement(By.linkText("Logout"));
		LogOut.click();
		
		WebElement LogInPanel1=driver.findElement(By.id("logInPanelHeading"));
		
		String ExpectedLogInPanelTextAfterLogOut=sheet.getRow(1).getCell(14).getStringCellValue();
		System.out.println(ExpectedLogInPanelTextAfterLogOut);
		row4.createCell(14).setCellValue(ExpectedLogInPanelTextAfterLogOut);
						
		String ActualLogInPanelTextAfterLogOut=LogInPanel1.getText();
		System.out.println("The Text of The Web Element is :- "+ActualLogInPanelTextAfterLogOut);
		row4.createCell(15).setCellValue(ActualLogInPanelTextAfterLogOut);
		
		if(ActualLogInPanelTextAfterLogOut.equals(ExpectedLogInPanelTextAfterLogOut))
		{
			
			System.out.println("LogIn Panel Text After LogOut is Matched - Pass");
			row4.createCell(16).setCellValue("Pass");
				
		}
		else
		{
			
			System.out.println("LogIn Panel Text After LogOut Not Matched - Fail");
			row4.createCell(16).setCellValue("Fail");
						 
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));
			
		}
		
		
		FileOutputStream File0=new FileOutputStream("./src/com/ExcelSheets/LogInTest.xlsx");
		workBook.write(File0);
		workBook.close();
		driver.quit();

		
	}
	
}
