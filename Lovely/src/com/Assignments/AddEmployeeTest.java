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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddEmployeeTest 
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
					
		//14,15,16
		
		Row1.createCell(14).setCellValue(array[0][0]);
		Row1.createCell(15).setCellValue(array[0][1]);
		Row1.createCell(16).setCellValue(array[0][2]);
		
		Row Row2=Sheet.createRow(2);
		
		Row2.createCell(14).setCellValue(array[1][0]);
		Row2.createCell(15).setCellValue(array[1][1]);
		Row2.createCell(16).setCellValue(array[1][2]);
		
		Row Row3=Sheet.createRow(3);
		
		Row3.createCell(14).setCellValue(array[2][0]);
		Row3.createCell(15).setCellValue(array[2][1]);
		Row3.createCell(16).setCellValue(array[2][2]);
		
		
		Row Row4=Sheet.createRow(4);
		
		Row4.createCell(14).setCellValue(array[3][0]);
		Row4.createCell(15).setCellValue(array[3][1]);
		Row4.createCell(16).setCellValue(array[3][2]);
		
		Row Row5=Sheet.createRow(5);
		
		Row5.createCell(14).setCellValue(array[4][0]);
		Row5.createCell(15).setCellValue(array[4][1]);
		Row5.createCell(16).setCellValue(array[4][2]);
		
		for (int rowindex=1;rowindex<Sheet.getLastRowNum();rowindex++)
		{
			
			for(int rowofcellindex=14;rowofcellindex<15;rowofcellindex++)
			{
				Thread.sleep(5000);
				
				By AddEmployeeL1=By.linkText("Add Employee");
				WebDriverWait Wait1=new WebDriverWait(driver, 10);
				Wait1.until(ExpectedConditions.visibilityOfElementLocated(AddEmployeeL1));
				
				WebElement AddEmployee1=driver.findElement(AddEmployeeL1);
				AddEmployee1.click();
				
				Row name=Sheet.getRow(rowindex);//first row
				Cell name1=name.getCell(rowofcellindex);
				String FirstName=name1.getStringCellValue();
				System.out.println(FirstName);
				
				By firstNameL=By.id("firstName");
				WebElement firstName=driver.findElement(firstNameL);
				firstName.sendKeys(FirstName);
				for(int rowofcellindex1=15;rowofcellindex1<16;rowofcellindex1++)
				{
					Row middleName=Sheet.getRow(rowindex);
			 		Cell MN=middleName.getCell(rowofcellindex1);
					
					String MN1=MN.getStringCellValue();
					System.out.println(MN1);
					
					By ExpectedMiddleNameL1=By.id("middleName");
					WebElement MiddleName1=driver.findElement(ExpectedMiddleNameL1);
					MiddleName1.sendKeys(MN1);
					for(int index2=16;index2<17;index2++)
					{
						
						Row LastName=Sheet.getRow(rowindex);
						Cell LN=LastName.getCell(index2);
						
						String LN1=LN.getStringCellValue();
						System.out.println(LN1);
												
						By LastNameL1=By.id("lastName");
						WebElement LastName1=driver.findElement(LastNameL1);
						LastName1.sendKeys(LN1);
						
						By EmployeeIdL1=By.id("employeeId");
						WebElement EmployeeID1=driver.findElement(EmployeeIdL1);
						String AutoUpdatedEmployeeId1=EmployeeID1.getAttribute("value");
						Sheet.getRow(rowindex).createCell(17).setCellValue(AutoUpdatedEmployeeId1);
						
						By SaveL=By.id("btnSave");
						WebElement Save=driver.findElement(SaveL);
						Save.click();		
						
						String ExpectedPersonalDetailsPageText=Sheet.getRow(1).getCell(18).getStringCellValue();
						System.out.println(ExpectedPersonalDetailsPageText);
						Sheet.getRow(rowindex).createCell(18).setCellValue(ExpectedPersonalDetailsPageText);
						By ActualPersonalDetailsPageL=By.className("hasTopFieldHelp");
						WebElement PersonalDetailsPage=driver.findElement(ActualPersonalDetailsPageL);
						
						String ActualPersonalDetailsPageText=PersonalDetailsPage.getText();
						Sheet.getRow(rowindex).createCell(19).setCellValue(ActualPersonalDetailsPageText);
						System.out.println(ActualPersonalDetailsPageText);
						
						if(ActualPersonalDetailsPageText.equals(ExpectedPersonalDetailsPageText))
						{
							
							System.out.println("Text Matched - Pass");
							Sheet.getRow(rowindex).createCell(20).setCellValue("Pass");
																
						}
						else
						{
							
							System.out.println("Text NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(20).setCellValue("Fail");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
							
							
						}
					
						String ExpectedFN=Sheet.getRow(rowindex).getCell(14).getStringCellValue();
						System.out.println(ExpectedFN);
						
						By FNL=By.id("personal_txtEmpFirstName" );
						WebElement AFN=driver.findElement(FNL);
						
						String ActualFirstNameText=AFN.getAttribute("value");
						Sheet.getRow(rowindex).createCell(21).setCellValue(ActualFirstNameText);
						System.out.println(ActualFirstNameText);
						if(ActualFirstNameText.equals(ExpectedFN))
						{
							
							System.out.println("Text Matched - Pass");
							Sheet.getRow(rowindex).createCell(22).setCellValue("Pass");
							
						}
						else
						{
							
							System.out.println("Text NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(22).setCellValue("Fail");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
							
						}
						
						String ExpectedMN=Sheet.getRow(rowindex).getCell(15).getStringCellValue();
						System.out.println(ExpectedMN);
						
						By MNL=By.id("personal_txtEmpMiddleName" );
						WebElement AMN=driver.findElement(MNL);
						
						String ActualMiddleNameText=AMN.getAttribute("value");
						Sheet.getRow(rowindex).createCell(23).setCellValue(ActualMiddleNameText);
						System.out.println(ActualMiddleNameText);
						if(ActualMiddleNameText.equals(ExpectedMN))
						{
							
							System.out.println("Text Matched - Pass");
							Sheet.getRow(rowindex).createCell(24).setCellValue("Pass");
							
						}
						else
						{
							
							System.out.println("Text NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(24).setCellValue("Fail");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
							
						}
						
						String ExpectedLN=Sheet.getRow(rowindex).getCell(16).getStringCellValue();
						System.out.println(ExpectedLN);
						
						By LNL=By.id("personal_txtEmpLastName" );
						WebElement ALN=driver.findElement(LNL);
						
						String ActualLastNameText=ALN.getAttribute("value");
						Sheet.getRow(rowindex).createCell(25).setCellValue(ActualLastNameText);
						System.out.println(ActualLastNameText);
						if(ActualLastNameText.equals(ExpectedLN))
						{
							
							System.out.println("Text Matched - Pass");
							Sheet.getRow(rowindex).createCell(26).setCellValue("Pass");
							
						}
						else
						{
							
							System.out.println("Text NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(26).setCellValue("Fail");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
							
						}
						
						//"personal_txtEmployeeId"
						

						String ExpectedEmpId=Sheet.getRow(rowindex).getCell(16).getStringCellValue();
						System.out.println(ExpectedLN);
						
						By EmpIdL=By.id("personal_txtEmployeeId" );
						WebElement EmpId=driver.findElement(EmpIdL);
						
						String ActualEmpId=EmpId.getAttribute("value");
						Sheet.getRow(rowindex).createCell(27).setCellValue(ActualEmpId);
						System.out.println(ActualEmpId);
						if(ActualEmpId.equals(ExpectedEmpId))
						{
							
							System.out.println("Text Matched - Pass");
							Sheet.getRow(rowindex).createCell(28).setCellValue("Pass");
							
						}
						else
						{
							
							System.out.println("Text NOT Matched - Fail");
							Sheet.getRow(rowindex).createCell(28).setCellValue("Fail");
							
							File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
							FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
							
						}
																	
					}
									
				}
				
			}
					
		}
		
		By WelcomeAdminL=By.id("welcome");
		WebElement WelcomeAdmin=driver.findElement(WelcomeAdminL);
		WelcomeAdmin.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeAdminL));
		
		WebElement LogOut=driver.findElement(By.linkText("Logout"));
		LogOut.click();
		
		WebElement LogInPanel1=driver.findElement(By.id("logInPanelHeading"));
		
		String ExpectedLogInPanelTextAfterLogOut=Sheet.getRow(1).getCell(29).getStringCellValue();
		System.out.println(ExpectedLogInPanelTextAfterLogOut);
		
		String ActualLogInPanelTextAfterLogOut=LogInPanel1.getText();
		System.out.println("The Text of The Web Element is :- "+ActualLogInPanelTextAfterLogOut);
		Row1.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
		
		
		if(ActualLogInPanelTextAfterLogOut.equals(ExpectedLogInPanelTextAfterLogOut))
		{
			
			System.out.println("LogIn Panel Text After LogOut is Matched - Pass");
			Row1.createCell(31).setCellValue("Pass");
			Row2.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row2.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row2.createCell(31).setCellValue("Pass");
			Row3.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row3.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row3.createCell(31).setCellValue("Pass");
			Row4.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row4.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row4.createCell(31).setCellValue("Pass");
			Row5.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row5.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row5.createCell(31).setCellValue("Pass");
							
		}
		else
		{
			
			System.out.println("LogIn Panel Text After LogOut Not Matched - Fail");
			Row1.createCell(31).setCellValue("Fail");
			Row2.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row2.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row2.createCell(31).setCellValue("Fail");
			Row3.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row3.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row3.createCell(31).setCellValue("Fail");
			Row4.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row4.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row4.createCell(31).setCellValue("Fail");
			Row5.createCell(29).setCellValue(ExpectedLogInPanelTextAfterLogOut);
			Row5.createCell(30).setCellValue(ActualLogInPanelTextAfterLogOut);
			Row5.createCell(31).setCellValue("Fail");
			
			File AddEmployeeScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(AddEmployeeScreenShot, new File("./AddEmployeeScreenShots/.png"));
			
		}

		FileOutputStream File0=new FileOutputStream("./src/com/ExcelSheets/AddEmployee.xlsx");
		WorkBook.write(File0);
		WorkBook.close();
		driver.quit();
	}
	
}
