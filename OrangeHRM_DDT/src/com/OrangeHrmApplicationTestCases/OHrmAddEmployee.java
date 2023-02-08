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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.OrangeHrmApplication.BaseTest;
import com.Utility.Log;

public class OHrmAddEmployee extends BaseTest 
{
	
	FileInputStream propertiesFile;
	Properties property;
	FileInputStream File;
	XSSFWorkbook WorkBook;
	XSSFSheet Sheet;
	Row Row1;
	Cell RowOfCell;
	FileOutputStream file;
	
	@Test(priority = 1)
	public void logInPageValidation() throws IOException
	{

		propertiesFile=new FileInputStream("C:\\Users\\INDIAN\\OneDrive\\Desktop\\Eclipse\\OrangeHRM_DDT\\src\\com\\Config\\PropertiesFile.properties");
		property=new Properties();
		property.load(propertiesFile);
		
		By LogInPanelL=By.id(property.getProperty("logInPageLogInPanelProperty"));
		WebElement LogInPanel=driver.findElement(LogInPanelL);
		
		File=new FileInputStream("./src/com/ApplicationTestDataFiles/AddEmployee.xlsx");
		
		WorkBook=new XSSFWorkbook(File);
		
		Sheet=WorkBook.getSheet("Sheet1");
		
		Row1=Sheet.getRow(1);
		RowOfCell=Row1.getCell(0);
		
		String ExpectedLogInPanelText=RowOfCell.getStringCellValue();
		Log.info("The Expected LogIn Page LogIn Panel Text is :- "+ExpectedLogInPanelText);
		
		String ActualLogInPanelText=LogInPanel.getText();
		Row1.createCell(1).setCellValue(ActualLogInPanelText);
		Log.info("The Actual LogIn Page LogIn Panel Text is :- "+ActualLogInPanelText);
		
		if(ActualLogInPanelText.equals(ExpectedLogInPanelText))
		{
			
			Log.info("The Actual and Expected Text Matched - PASS");
			Row1.createCell(2).setCellValue("The Actual and Expected Text Matched");
			
			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}
		else
		{
			
			Log.info("The Actual and Expected Text NOT Matched - Fail");
			Row1.createCell(2).setCellValue("The Actual and Expected Text NOT Matched");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
						
		}
					
	}

	@Test(priority = 2)
	public void logInPageTitleValidation() throws IOException
	{
		
		String ExpectedLogInPageTitle=driver.getTitle();
		Row1.createCell(3).setCellValue(ExpectedLogInPageTitle);
		Log.info("The Expected LogIn Page Title is :- "+ExpectedLogInPageTitle);
		
		RowOfCell=Row1.getCell(4);
		String ActualLogInPageTitle=RowOfCell.getStringCellValue();
		Log.info("The Actual LogIn Page Title is :- "+ActualLogInPageTitle);
		
		if(ActualLogInPageTitle.equals(ExpectedLogInPageTitle))
		{
			
			Log.info("The Actual and Expected Title are Matched - Pass");
			Row1.createCell(5).setCellValue("The Actual and Expected Title are Matched");

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}
		else
		{
		
			Log.info("The Actual and Expected Title are NOT Matched - Fail");
			Row1.createCell(5).setCellValue("The Actual and Expected Title are NOT Matched");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}
		
	}

	@Test(priority = 3)
	public void logInWithValidData()
	{
		
		String UserNameTestData="VaraLakshmi";
		Row1.createCell(6).setCellValue(UserNameTestData);
		
		By UserNameL=By.id(property.getProperty("userNameProperty"));
		WebElement UserName=driver.findElement(UserNameL);
		
		String user=Sheet.getRow(1).getCell(6).getStringCellValue();
		UserName.sendKeys(user);
		
		Log.info("The User Name is :- "+user);
		
		String PasswordTestData="LovelyVaram@1998";
		Row1.createCell(7).setCellValue(PasswordTestData);
		
		By PasswordL=By.id(property.getProperty("passwordProperty"));
		WebElement Password=driver.findElement(PasswordL);
		
		String password=Sheet.getRow(1).getCell(7).getStringCellValue();
		Password.sendKeys(password);
		
		Log.info("The Password is :- "+password);
		
		By LogInL=By.className(property.getProperty("logInButtonProperty"));
		WebElement Login=driver.findElement(LogInL);
		Login.click();
		
	}
	
	@Test(priority = 4)
	public void validatingHomePageText() throws IOException
	{
		
		String ExpectedHomePageText=Row1.getCell(8).getStringCellValue();
		Log.info("The Expected Home Page Text is :- "+ExpectedHomePageText);
		
		By HomePageTextL=By.id(property.getProperty("adminProperty"));
		WebElement HomePageText=driver.findElement(HomePageTextL);
		
		String ActualHomePageText=HomePageText.getText();
		Log.info("The Actual Home Page Text is :- "+ActualHomePageText);
		Row1.createCell(9).setCellValue(ActualHomePageText);
		
		if(ActualHomePageText.equals(ExpectedHomePageText))
		{
			
			Log.info("The Actual and Expected Home Page Text Matched - Pass");
			Row1.createCell(10).setCellValue("The Actual and Expected Home Page Text Matched");

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}
		else
		{
			
			Log.info("The Actual and Expected Home Page Text NOT Matched - Fail");
			Row1.createCell(10).setCellValue("The Actual and Expected Home Page Text NOT Matched");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
						
		}
	}

	@Test(priority = 5)
	public void addEmployeePageTextValidation() throws IOException
	{
		
		By PIMLocator=By.id(property.getProperty("PIMProperty"));
		WebElement PIM=driver.findElement(PIMLocator);
		
		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();
		
		By AddEmployeeL=By.id(property.getProperty("AddEmployeeProperty"));
		WebDriverWait Wait=new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(AddEmployeeL));
		
		WebElement AddEmployee=driver.findElement(AddEmployeeL);
		AddEmployee.click();
		
		String ExpectedAddEmployeePageText=Row1.getCell(11).getStringCellValue();
		Log.info("The Expected Add Employee Page Text is :- "+ExpectedAddEmployeePageText);
		
		By ActualAddEmployeePageTextL=By.className(property.getProperty("AddEmployeePageTextProperty"));
		WebElement ActualAddEmployeePage=driver.findElement(ActualAddEmployeePageTextL);
		String ActualAddEmployeePageText=ActualAddEmployeePage.getText();

		Row1.createCell(12).setCellValue(ActualAddEmployeePageText);
		
		Log.info("The Actual Add Employee Page Text is :- "+ActualAddEmployeePageText);
		
		if(ActualAddEmployeePageText.equals(ExpectedAddEmployeePageText))
		{
			
			Log.info("The Actual and Expected Add Employee Page Text Matched - Pass");
			Row1.createCell(13).setCellValue("The Actual and Expected Add Employee Page Text Matched");

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
						
		}
		else
		{
			
			Log.info("The Actual and Expected Add Employee Page Text NOT Matched - Fail");
			Row1.createCell(13).setCellValue("The Actual and Expected Add Employee Page Text NOT Matched");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}
		
	}
	
	Row Row2,Row3,Row4,Row5;

	@Test(priority = 6)
	public void exportingEmployeeDetailsToExcelSheet() throws IOException
	{
		
		
		String array[][]=new String[5][3];
		array[0][0]="Kodali";
		array[0][1]="Rajini";
		array[0][2]="Devi";
		array[1][0]="Kodali";
		array[1][1]="Vamshi Kumar";
		array[1][2]="Netha";
		array[2][0]="Chilikoti";
		array[2][1]="Sivaji";
		array[2][2]="Raj";
		array[3][0]="Chilikoti";
		array[3][1]="Vara Pasad";
		array[3][2]="Netha";
		array[4][0]="Chilikoti";
		array[4][1]="Sri Ram";
		array[4][2]="Netha";
		
		Row1.createCell(14).setCellValue(array[0][0]);
		Row1.createCell(15).setCellValue(array[0][1]);
		Row1.createCell(16).setCellValue(array[0][2]);
		
		Row2=Sheet.createRow(2);
		
		Row2.createCell(14).setCellValue(array[1][0]);
		Row2.createCell(15).setCellValue(array[1][1]);
		Row2.createCell(16).setCellValue(array[1][2]);
		
		Row3=Sheet.createRow(3);
		
		Row3.createCell(14).setCellValue(array[2][0]);
		Row3.createCell(15).setCellValue(array[2][1]);
		Row3.createCell(16).setCellValue(array[2][2]);
		
		
		Row4=Sheet.createRow(4);
		
		Row4.createCell(14).setCellValue(array[3][0]);
		Row4.createCell(15).setCellValue(array[3][1]);
		Row4.createCell(16).setCellValue(array[3][2]);
		
		Row5=Sheet.createRow(5);
		
		Row5.createCell(14).setCellValue(array[4][0]);
		Row5.createCell(15).setCellValue(array[4][1]);
		Row5.createCell(16).setCellValue(array[4][2]);
		
		file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
		WorkBook.write(file);
			
	}
	

	@Test(priority = 7)
	public void validatingTheData() throws InterruptedException, IOException
	{
	
		for (int rowindex=1;rowindex<Sheet.getLastRowNum();rowindex++)
		{
			
			Thread.sleep(5000);
			
			for(int rowofcellindex=14;rowofcellindex<15;rowofcellindex++)
			{
				Thread.sleep(5000);
				
				By AddEmployeeL1=By.id(property.getProperty("AddEmployeeProperty"));
				WebDriverWait Wait1=new WebDriverWait(driver, 10);
				Wait1.until(ExpectedConditions.visibilityOfElementLocated(AddEmployeeL1));
				
				WebElement AddEmployee1=driver.findElement(AddEmployeeL1);
				AddEmployee1.click();
								
				String FirstName=Sheet.getRow(rowindex).getCell(rowofcellindex).getStringCellValue();
						
				Log.info("The First Name is :- "+FirstName);
				
				By firstNameL=By.id(property.getProperty("FirstNameProperty"));
				WebElement firstName=driver.findElement(firstNameL);
				firstName.sendKeys(FirstName);
				
				for(int rowofcellindex1=15;rowofcellindex1<16;rowofcellindex1++)
				{
					
			 		String MiddleName=Sheet.getRow(rowindex).getCell(rowofcellindex1).getStringCellValue();
					
					Log.info("The Middle Name is :- "+MiddleName);
					
					By ExpectedMiddleNameL1=By.id(property.getProperty("MiddleNameProperty"));
					WebElement MiddleName1=driver.findElement(ExpectedMiddleNameL1);
					MiddleName1.sendKeys(MiddleName);
					
					for(int index2=16;index2<17;index2++)
					{
												
						String LastName=Sheet.getRow(rowindex).getCell(index2).getStringCellValue();
						Log.info("The Last Name is :- "+LastName);
												
						By LastNameL1=By.id(property.getProperty("LastNameProperty"));
						WebElement LastName1=driver.findElement(LastNameL1);
						LastName1.sendKeys(LastName);
						
						By EmployeeIdL1=By.id(property.getProperty("AutoGeneraatedEmployeeIdProperty"));
						WebElement EmployeeID1=driver.findElement(EmployeeIdL1);
						String AutoUpdatedEmployeeId1=EmployeeID1.getAttribute("value");
						
						Log.info("The Auto-Updated Employee Id is :- "+AutoUpdatedEmployeeId1);
						Sheet.getRow(rowindex).createCell(17).setCellValue(AutoUpdatedEmployeeId1);
						
						By SaveL=By.id(property.getProperty("SaveButtonProperty"));
						WebElement Save=driver.findElement(SaveL);
						Save.click();		
						
						String ExpectedPersonalDetailsPageText=Sheet.getRow(1).getCell(18).getStringCellValue();
						Log.info("The Expected Personal Details Page Text is :- "+ExpectedPersonalDetailsPageText);
						Sheet.getRow(rowindex).createCell(18).setCellValue(ExpectedPersonalDetailsPageText);
						
						By ActualPersonalDetailsPageL=By.className(property.getProperty("PersonalDetailsPageTextProperty"));
						WebElement PersonalDetailsPage=driver.findElement(ActualPersonalDetailsPageL);
						
						String ActualPersonalDetailsPageText=PersonalDetailsPage.getText();
						Sheet.getRow(rowindex).createCell(19).setCellValue(ActualPersonalDetailsPageText);
						Log.info("The Actual Personal Details Page Text is :-"+ActualPersonalDetailsPageText);
						
						if(ActualPersonalDetailsPageText.equals(ExpectedPersonalDetailsPageText))
						{
							
							Log.info("The Actual and Expected Personal Details Page Text Matched - Pass");
							Sheet.getRow(rowindex).createCell(20).setCellValue("The Actual and Expected Personal Details Page Text Matched");

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						else
						{
							
							Log.info("The Actual and Expected Personal Details Page Text NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(20).setCellValue("The Actual and Expected Personal Details Page Text NOT Matched");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
														
						}
					
						String ExpectedFirstName=Sheet.getRow(rowindex).getCell(14).getStringCellValue();
						Log.info("The Expected First Name is "+ExpectedFirstName);
						
						By FNL=By.id(property.getProperty("PersonalDetailsPageFirstNameProperty") );
						WebElement AFN=driver.findElement(FNL);
						
						String ActualFirstNameText=AFN.getAttribute("value");
						Sheet.getRow(rowindex).createCell(21).setCellValue(ActualFirstNameText);
						Log.info("The Actual First Name is :- "+ActualFirstNameText);
						
						if(ActualFirstNameText.equals(ExpectedFirstName))
						{
							
							Log.info("The Actual and Expected First Name is Matched - Pass");
							Sheet.getRow(rowindex).createCell(22).setCellValue("The Actual and Expected First Name is Matched");

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						else
						{
							
							Log.info("The Actual and Expected First Name is NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(22).setCellValue("The Actual and Expected First Name is NOT Matched");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						
						String ExpectedMiddleName=Sheet.getRow(rowindex).getCell(15).getStringCellValue();
						Log.info("The Expected Middle Name is :- "+ExpectedMiddleName);
						
						By MNL=By.id(property.getProperty("PersonalDetailsPageMiddleNameProperty") );
						WebElement AMN=driver.findElement(MNL);
						
						String ActualMiddleNameText=AMN.getAttribute("value");
						Sheet.getRow(rowindex).createCell(23).setCellValue(ActualMiddleNameText);
						Log.info("The Actual Middle Name is :- "+ActualMiddleNameText);
						
						if(ActualMiddleNameText.equals(ExpectedMiddleName))
						{
							
							Log.info("The Actual and Expected Middle Name Matched - Pass");
							Sheet.getRow(rowindex).createCell(24).setCellValue("The Actual and Expected Middle Name Matched");

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						else
						{
							
							Log.info("The Actual and Expected Middle Name NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(24).setCellValue("The Actual and Expected Middle Name NOT Matched");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						
						String ExpectedLastName=Sheet.getRow(rowindex).getCell(16).getStringCellValue();
						Log.info("The Expected Last Name is :- "+ExpectedLastName);
						
						By LNL=By.id(property.getProperty("PersonalDetailsPageLastNameProperty") );
						WebElement ALN=driver.findElement(LNL);
						
						String ActualLastNameText=ALN.getAttribute("value");
						Sheet.getRow(rowindex).createCell(25).setCellValue(ActualLastNameText);
						Log.info("The Actual Last Name is :- "+ActualLastNameText);
						
						if(ActualLastNameText.equals(ExpectedLastName))
						{
							
							Log.info("The Actual and Expected LAst Name Matcched - Pass");
							Sheet.getRow(rowindex).createCell(26).setCellValue("The Actual and Expected LAst Name Matcched");

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						else
						{
							
							Log.info("The Actual and Expected LAst Name NOT Matcched - Fail");
							Sheet.getRow(rowindex).createCell(26).setCellValue("The Actual and Expected LAst Name NOT Matcched");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						
						String ExpectedEmpId=Sheet.getRow(rowindex).getCell(17).getStringCellValue();
						Log.info("The Expected Employee Id is :- "+ExpectedEmpId);
						
						By EmpIdL=By.id(property.getProperty("PersonalDetailsPageEmployeeIdProperty") );
						WebElement EmpId=driver.findElement(EmpIdL);
						
						String ActualEmpId=EmpId.getAttribute("value");
						Sheet.getRow(rowindex).createCell(27).setCellValue(ActualEmpId);
						Log.info("The Actual Employee Id is :- "+ActualEmpId);
						
						if(ActualEmpId.equals(ExpectedEmpId))
						{
							
							Log.info("The Actual and Expected Employee Id is Matched - Pass");
							Sheet.getRow(rowindex).createCell(28).setCellValue("The Actual and Expected Employee Id is Matched");

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
						else
						{
							
							Log.info("The Actual and Expected Employee Id is NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(28).setCellValue("The Actual and Expected Employee Id is NOT Matched");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

							file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
							WorkBook.write(file);
							
						}
																	
					}
									
				}
				
			}
					
		}
		
	}

	@Test(priority = 8)
	public void logOut()
	{
		
		By WelcomeAdminL=By.id(property.getProperty("welcomeAdminProperty"));
		WebElement WelcomeAdmin=driver.findElement(WelcomeAdminL);
		WelcomeAdmin.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeAdminL));
		
		WebElement LogOut=driver.findElement(By.linkText(property.getProperty("logOutProperty")));
		LogOut.click();
				
	}

	@Test(priority = 9)
	public void logInPanelTextValidation1() throws IOException
	{
		
		WebElement LogInPanel1=driver.findElement(By.id(property.getProperty("logInPageLogInPanelProperty")));
		
		String ExpectedLogInPanelTextAfterLogOut1=Row1.createCell(29).getStringCellValue();
		Log.info("The Expected LogIn Page LogIn Panel Text is :- "+ExpectedLogInPanelTextAfterLogOut1);
		
		String ActualLogInPanelTextAfterLogOut1=LogInPanel1.getText();
		Log.info("The Actual LogIn Page LogIn Panel Text is :- "+ActualLogInPanelTextAfterLogOut1);
		
		Row1.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut1);
				
		if(ActualLogInPanelTextAfterLogOut1.equals(ExpectedLogInPanelTextAfterLogOut1))
		{
			
			Log.info("The Actual and Expected LogIn Page LogIn Panel Text Matched After LogOut - Pass");
			Row1.createCell(31).setCellValue("The Actual and Expected LogIn Page LogIn Panel Text Matched After LogOut ");
			
			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}
		else
		{
			
			Log.info("The Actual and Expected LogIn Page LogIn Panel Text NOT Matched After LogOut - Fail");
			Row1.createCell(31).setCellValue("The Actual and Expected LogIn Page LogIn Panel Text NOT Matched After LogOut ");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));

			file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/AddEmployeeTestResultsFile.xlsx");
			WorkBook.write(file);
			
		}

	}

}