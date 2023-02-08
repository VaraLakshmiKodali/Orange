package com.OrangeHRM;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OHrm_EmployeeList 
{

	public static void main(String[] args) throws IOException 
	{
		
	String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
	WebDriver driver;
	System.setProperty("webdriver.edge.driver", "./DriverFiles/msedgedriver.exe");
	driver=new EdgeDriver();
	driver.get(ApplicationUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
	String UserNameTestData="VaraLakshmi";
	By UserNameL=By.id("txtUsername");
	WebElement UserName=driver.findElement(UserNameL);
	UserName.sendKeys(UserNameTestData);
	
	String PasswordTestData="LovelyVaram@1998";
	By PasswordL=By.id("txtPassword");
	WebElement Password=driver.findElement(PasswordL);
	Password.sendKeys(PasswordTestData);		
	
	By LogInL=By.className("button");
	WebElement LogIn=driver.findElement(LogInL);
	LogIn.click();
	
	By PIMLocator=By.id("menu_pim_viewPimModule");
	WebElement PIM=driver.findElement(PIMLocator);
	
	Actions action=new Actions(driver);
	action.moveToElement(PIM).build().perform();
	 
	By EmployeeListL=By.id("menu_pim_viewEmployeeList");
	
	WebDriverWait Wait=new WebDriverWait(driver, 10);
	Wait.until(ExpectedConditions.visibilityOfElementLocated(EmployeeListL));
	
	WebElement EmployeeList=driver.findElement(EmployeeListL);
	EmployeeList.click();
	
	///html/body/div[1]/div[3]/div[2]/div/form
	
	By webTableL=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form");
	WebElement webTable=driver.findElement(webTableL);
	
	By tableRow=By.tagName("tr");
	List<WebElement>rowData=webTable.findElements(tableRow);
	
	FileInputStream File=new FileInputStream("./src/com/ExcelSheets/EmployeeList.xlsx");
	XSSFWorkbook workBook=new XSSFWorkbook(File);
	XSSFSheet sheet=workBook.getSheet("Sheet1");
	for(int row=0;row<rowData.size();row++)
	{
		
		Row row1=sheet.createRow(row);
		List<WebElement>cellData=rowData.get(row).findElements(By.tagName("td"));
		
		for(int cell=0;cell<cellData.size();cell++)
		{
			
			String data=cellData.get(cell).getText();
			row1.createCell(cell).setCellValue(data);
			System.out.print(data);
		}
		System.out.println();
	}
	
	By IdL=By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[4]/table/tbody/tr[1]/td[2]/a");
	WebElement webTable1=driver.findElement(IdL);
	
	By tableRow1=By.tagName("tr");
	List<WebElement>rowData1=webTable1.findElements(tableRow1);
	
	for(int i=0;i<rowData1.size();i++)
	{
		
		List<WebElement>cellData1=rowData1.get(i).findElements(By.tagName("td"));
		for(int j=0;j<cellData1.size();j++)
		{
		
			String data1=cellData1.get(j).getText();
			System.out.print(data1);
			
		}
		
		System.out.println();
	}
	
	FileOutputStream file=new FileOutputStream("./src/com/ExcelSheets/EmployeeList.xlsx");
	workBook.write(file);
	workBook.close();
	driver.quit();	
	}
	
}
