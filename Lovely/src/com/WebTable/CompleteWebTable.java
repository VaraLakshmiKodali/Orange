package com.WebTable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CompleteWebTable 
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
	
	public void completeTableData() throws IOException 
	{
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/CompleteWebTableData.xlsx");
		XSSFWorkbook workBook=new XSSFWorkbook(File);
		XSSFSheet sheet=workBook.getSheet("Sheet2");
		for(int row=0;row<=36;row++)
		{
			Row rowvalue=sheet.createRow(row);
			
			for(int cell=0;cell<=8;cell++)
			{
				
				By webTableL=By.xpath("/html/body/div[5]section[1]/div/section/div[1]/table/tbody/tr["+row+"]/td["+cell+"]");
				WebElement webTable=driver.findElement(webTableL);
				String webtableData=webTable.getText();
				System.out.print(webtableData+" ");
				rowvalue.createCell(cell).setCellValue(webtableData);
				
				
			}
			
			System.out.println();
		}
		
		FileOutputStream file=new FileOutputStream("./src/com/ExcelSheets/CompleteWebTableData.xlsx");
		workBook.write(file);
		workBook.close();
	}
	public static void main(String[] args) throws IOException 
	{
		
		CompleteWebTable getData=new CompleteWebTable();
		getData.applicationLaunch();
		getData.completeTableData();
		getData.applicationClose();
		
	}
		
}
