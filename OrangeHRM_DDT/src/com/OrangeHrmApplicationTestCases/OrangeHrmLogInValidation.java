package com.OrangeHrmApplicationTestCases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.OrangeHrmApplication.BaseTest;
import com.Utility.Log;

public class OrangeHrmLogInValidation extends BaseTest
{
	
	WebElement WelcomeAdmin;
	FileInputStream propertiesFile;
	Properties property;
	FileInputStream File;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	Row row1;
	Cell rowOfCell;
	FileOutputStream file;
	
	@Test(priority=1)
	public void logInPageValidation() throws IOException
	{
		
		propertiesFile= new FileInputStream("C:\\Users\\INDIAN\\OneDrive\\Desktop\\Eclipse\\OrangeHRM_DDT\\src\\com\\Config\\PropertiesFile.properties");
		property=new Properties();
		property.load(propertiesFile);
				
		File= new FileInputStream("./src/com/ApplicationTestDataFiles/LogInTest.xlsx");
		workBook=new XSSFWorkbook(File);
		sheet=workBook.getSheet("Sheet1");
		
		row1=sheet.getRow(1);
		rowOfCell=row1.getCell(0);
		
		String ExpectedLogInPanelText=sheet.getRow(1).getCell(0).getStringCellValue();
		
		Log.info("The Expected LogIn Page LogIn Panel Text is :- "+ExpectedLogInPanelText);
		
		By LogInPanelL=By.id(property.getProperty("logInPageLogInPanelProperty"));
		WebElement LogInPanel=driver.findElement(LogInPanelL);
		
		String ActualLogInPanelText=LogInPanel.getText();
		sheet.getRow(1).createCell(1).setCellValue(ActualLogInPanelText);
		Log.info("The Actual LogIn Page LogIn Panel Text is :- "+ActualLogInPanelText);
		
		if(ActualLogInPanelText.equals(ExpectedLogInPanelText))
		{
			
			Log.info("The Actual and Expected LogIn Page LogIn Panel Text Matched - PASS");
			sheet.getRow(1).createCell(2).setCellValue("The Actual and Expected LogIn Page LogIn Panel Text Matched");
			
			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
			
		}
		else
		{
			
			Log.info("The Actual and Expected LogIn Page LogIn Panel Text are NOT Matched- FAIL");
			sheet.getRow(1).createCell(2).setCellValue("The Actual and Expected LogIn Page LogIn Panel Text are NOT Matched");
			
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));
			
			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
						
		}
		
	}

	@Test(priority=2)
	public void logInPageTitleValidation() throws IOException
	{
		
		String ExpectedLogInPageTitle=row1.getCell(3).getStringCellValue();
		Log.info("The Expected LogIn Page Title is :- "+ExpectedLogInPageTitle);
		
		String ActualLogInPageTitle=driver.getTitle();
		sheet.getRow(1).createCell(4).setCellValue(ExpectedLogInPageTitle);
		Log.info("The Actual LogIn Page Title is :- "+ActualLogInPageTitle);
		
		if(ActualLogInPageTitle.equals(ExpectedLogInPageTitle))
		{
			
			Log.info("The Expected and Actual LogIn Page Title are Matched - PASS");
			sheet.getRow(1).createCell(5).setCellValue("The Expected and Actual LogIn Page Title are Matched");

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
						
		}
		else
		{
		
			Log.info("The Expected and Actual LogIn Page Title are NOT Matched - FAIL");
			sheet.getRow(1).createCell(5).setCellValue("The Expected and Actual LogIn Page Title are NOT Matched");
			
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
			
		}
		
	}

	@Test(priority=3)
	public void logInPageUrlValidation() throws IOException
	{
		
		String ExpectedLogInPageUrl=row1.getCell(6).getStringCellValue();
		Log.info("THe Expected LogIn Page URL Is :- "+ExpectedLogInPageUrl);
		
		String ActualLogInPageUrl=driver.getCurrentUrl();
		sheet.getRow(1).createCell(7).setCellValue(ActualLogInPageUrl);
		Log.info("THe Actual LogIn Page URL Is :- "+ActualLogInPageUrl);
		
		if(ActualLogInPageUrl.contains(ExpectedLogInPageUrl))
		{
			
			Log.info("The Actual URL Matches with Expected URL - PASS");
			sheet.getRow(1).createCell(8).setCellValue("The Actual URL Matches with Expected URL");

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
			
		}
		else
		{
			
			Log.info("The Actual URL NOT Matched with Expected URL - FAIL");
			sheet.getRow(1).createCell(8).setCellValue("The Actual URL NOT Matched with Expected URL");
			
			File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
			
		}
		
	}

	Row row2,row3,row4;

	@Test(priority=4)
	public void exportingUserNameAndPasswordDataToExcel() throws IOException, InterruptedException
	{
		
		String array[][]=new String[4][2];
		
		array[0][0]="Mukesh";
		array[0][1]="Mukesh@1234";
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
	
		file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
		workBook.write(file);
		
	}
	@Test(priority=5)
	public void validatingLoginFunctionality() throws IOException, InterruptedException
	{
		for (int rowindex=1;rowindex<=sheet.getLastRowNum();rowindex++)

		{
		
			for(int rowofcellindex=9;rowofcellindex<10;rowofcellindex++)
		   
			{
				Thread.sleep(5000);
				
				Row Username=sheet.getRow(rowindex);//first row
				Cell Username1=Username.getCell(rowofcellindex);
				String row1Username=Username1.getStringCellValue();
				Log.info("The User Name is :- "+row1Username);
				
				By userNameL=By.id(property.getProperty("userNameProperty"));
				WebElement userName=driver.findElement(userNameL);
				userName.sendKeys(row1Username);

				for (int rowofcellindex1=10;rowofcellindex1<11;rowofcellindex1++)
				{
					
					Row Password1=sheet.getRow(rowindex);//first row
					Cell Password=Password1.getCell(rowofcellindex1);
					String row1Password=Password.getStringCellValue();
					Log.info("The Password is :- "+row1Password);

					By PasswordL=By.name(property.getProperty("passwordProperty"));
					WebElement password=driver.findElement(PasswordL);
					password.sendKeys(row1Password);

					By LoginL=By.className(property.getProperty("logInButtonProperty"));
					WebElement Login=driver.findElement(LoginL);
					Login.click();
			
				}
				
				try 
				{
					
					By AdminL=By.id(property.getProperty("adminProperty"));
					WebElement HomePage=driver.findElement(AdminL);
						
					String ExpectedText="Admin";
					sheet.getRow(rowindex).createCell(11).setCellValue(ExpectedText);
					 					
					String ActualHomePageText=HomePage.getText();
					
					sheet.getRow(4).createCell(12).setCellValue(ActualHomePageText);
					 
					sheet.getRow(rowindex).createCell(13).setCellValue("The Home Page Text Matched");
					Log.info("The Home Page Text Matched - PASS");
					
					file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
					workBook.write(file);
										 
				} 
				catch (Exception e) 
				{
 					
					String ExpectedPageText="Admin";
					sheet.getRow(rowindex).createCell(11).setCellValue(ExpectedPageText);
					 
					By InvalidCredentialL=By.id(property.getProperty("InvalidCredentialsProperty"));
					WebElement InvalidCredentials=driver.findElement(InvalidCredentialL);
					String ActualInvalidText=InvalidCredentials.getText();
					sheet.getRow(rowindex).createCell(12).setCellValue(ActualInvalidText);
					 
					sheet.getRow(rowindex).createCell(13).setCellValue("The Home Page Text NOT Matched");
					Log.info("The Home Page NOT Text Matched - FAIL");
					 				 
					File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
					FileUtils.copyFile(LogInScreenShot, new File("./LogInScreenShots/"+rowindex+".png"));
					 
					file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
					workBook.write(file);
						
				 }

			}
			
			System.out.println();
			
		}
		
	}
	
	WebElement LogOut;
	
	@Test(priority = 6)
	public void logOut()
	{
		By WelcomeAdminL=By.id(property.getProperty("welcomeAdminProperty"));
		WelcomeAdmin=driver.findElement(WelcomeAdminL);
		WelcomeAdmin.click();
				
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeAdminL));
		
		LogOut=driver.findElement(By.linkText(property.getProperty("logOutProperty")));
		LogOut.click();
				
	}

	@Test(priority = 7)
	public void logInPanelTextValidation1() throws IOException
	{
		
		WebElement LogInPanel1=driver.findElement(By.id(property.getProperty("logInPageLogInPanelProperty")));
		
		String ExpectedLogInPanelTextAfterLogOut1=sheet.getRow(1).createCell(14).getStringCellValue();
		Log.info("The Expected LogIn Page LogIn Panel Text is :- "+ExpectedLogInPanelTextAfterLogOut1);
		
		String ActualLogInPanelTextAfterLogOut1=LogInPanel1.getText();
		Log.info("The Actual LogIn Page LogIn Panel Text is :-"+ActualLogInPanelTextAfterLogOut1);
		
		sheet.getRow(1).createCell(15).setCellValue(ActualLogInPanelTextAfterLogOut1);
				
		if(ActualLogInPanelTextAfterLogOut1.equals(ExpectedLogInPanelTextAfterLogOut1))
		{
			
			Log.info("The Expected and Actual LogIn Page LogIn Panel Text matched : PASS");
			sheet.getRow(1).createCell(16).setCellValue("The Expected and Actual LogIn Page LogIn Panel Text matched");
			
			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
			
		}
		else
		{
			
			Log.info("The Expected and Actual LogIn Page LogIn Panel Text NOT matched - FAIL");
			sheet.getRow(1).createCell(16).setCellValue("The Expected and Actual LogIn Page LogIn Panel Text NOT matched");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./LogInScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/LogInTestResultsFile.xlsx");
			workBook.write(file);
			
		}

	}
	
}
