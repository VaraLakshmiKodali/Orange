package com.OrangeHrmApplicationTestCases;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.OrangeHrmApplication.BaseTest;

public class OrangeHrmEmployeeList extends BaseTest
{
	
	FileInputStream propertiesFile;
	Properties property;
	FileInputStream File;
	XSSFWorkbook workBook;
	XSSFSheet sheet;
	Row row1;
	FileOutputStream file;
	
		
	@Test(priority = 1)
	public void logIn() throws IOException
	{
		
		propertiesFile= new FileInputStream("C:\\Users\\INDIAN\\OneDrive\\Desktop\\Eclipse\\OrangeHRM_DDT\\src\\com\\Config\\PropertiesFile.properties");
		Properties property=new Properties();
		property.load(propertiesFile);
				
		String UserNameTestData="VaraLakshmi";
		By UserNameL=By.id(property.getProperty("userNameProperty"));
		WebElement UserName=driver.findElement(UserNameL);
		UserName.sendKeys(UserNameTestData);
		
		String PasswordTestData="LovelyVaram@1998";
		By PasswordL=By.id(property.getProperty("passwordProperty"));
		WebElement Password=driver.findElement(PasswordL);
		Password.sendKeys(PasswordTestData);		
		
		By LogInL=By.className(property.getProperty("logInButtonProperty"));
		WebElement LogIn=driver.findElement(LogInL);
		LogIn.click();
		
	}
	
	@Test(priority = 2)
	public void employeeList()
	{
		By PIMLocator=By.id(property.getProperty("PIMProperty"));
		WebElement PIM=driver.findElement(PIMLocator);
		
		Actions action=new Actions(driver);
		action.moveToElement(PIM).build().perform();
		 
		By EmployeeListL=By.id(property.getProperty("EmployeeListProperty"));
				
		WebDriverWait Wait=new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeListL));
		
		WebElement EmployeeList=driver.findElement(EmployeeListL);
		EmployeeList.click();
		
	}
	
	public void employeeListData() throws IOException
	{
		
		By webTableL=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form");
		WebElement webTable=driver.findElement(webTableL);
		
		By tableRow=By.tagName("tr");
		List<WebElement>rowData=webTable.findElements(tableRow);
		
		File=new FileInputStream("./src/com/ApplicationTestFiles/EmployeeList.xlsx");
		workBook=new XSSFWorkbook(File);
		sheet=workBook.getSheet("Sheet1");
		
		for(int row=0;row<rowData.size();row++)
		{
			
			row1=sheet.createRow(row);
			List<WebElement>cellData=rowData.get(row).findElements(By.tagName("td"));
			
			for(int cell=0;cell<cellData.size();cell++)
			{
				
				String data=cellData.get(cell).getText();
				row1.createCell(cell).setCellValue(data);
				System.out.print(data+" ");
				
			}
			
			System.out.println();
		}
		/*
		By IdLocator=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[2]/a");
		WebElement webTable1=driver.findElement(IdLocator);
		
		By tableRow1=By.tagName("tr");
		List<WebElement>rowData1=webTable1.findElements(tableRow1);
		
		for(int i=0;i<rowData1.size();i++)
		{
			
			List<WebElement>cellData1=rowData1.get(i).findElements(By.tagName("td"));
			
			for(int j=0;j<cellData1.size();j++)
			{
			
				String data1=cellData1.get(j).getText();
				System.out.print(data1+" ");
				
			}
			
			System.out.println();
			
		}
		
		file=new FileOutputStream("./src/com/ApplicationTestResultsFiles/EmployeeListResultsFile.xlsx");
		workBook.write(file);
		*/
	}

}
	
	
	



