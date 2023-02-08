package com.Assignments;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompleteTable
{

	WebDriver driver;
	String ApplicationUrl="https://www.timeanddate.com/worldclock/";
	
	public void applicationLaunch()
	{
		
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0,550)");
		
		
	}
	
	public void applicationClose()
	{
		
		driver.quit();
		
	}
	
	public void tableData() throws IOException
	{
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/CompleteWebTableData.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(File);
		XSSFSheet sheet=workBook.getSheet("Sheet1");
		
		WebElement table=driver.findElement(By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody"));
		System.out.println(table);
		List<WebElement>rowsCount=driver.findElements(By.tagName("tr"));
		
		for(int row=0;row<rowsCount.size();row++)
		{
	
			Row rowvalue=sheet.createRow(row);
			List<WebElement>colunmsCount=rowsCount.get(row).findElements(By.tagName("td"));
		
			for(int cell=0;cell<colunmsCount.size();cell++)
			{
			
				String cellValue=colunmsCount.get(cell).getText();
				System.out.println(cellValue+"\t");
				rowvalue.createCell(cell).setCellValue(cellValue);
				
			}
			
			System.out.println();
		}
		
		FileOutputStream file=new FileOutputStream("./src/com/ExcelSheets/CompleteWebTableData.xlsx");
		workBook.write(file);
		workBook.close();
	}
	
	public static void main(String[] args) throws IOException 
	{
		CompleteTable table=new CompleteTable();
		table.applicationLaunch();
		table.tableData();
		table.applicationClose();
	}
}
