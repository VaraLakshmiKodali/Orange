package com.WebTable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingFirstColumnData
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
	
	public void firstRow() throws IOException
	{
		
		FileInputStream file=new FileInputStream("./src/com/ExcelSheets/TimeAndDateRowData.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
					
		for(int index=1;index<36;index++)
		{
			//html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr[1]/td[1]
			
			By cityNameL=By.xpath("/html/body/div[5]/section[1]/div/section/div[1]/div/table/tbody/tr["+index+"]/td[1]");
			WebElement cityName=driver.findElement(cityNameL);
			
			Row row=sheet.createRow(index);
			Cell rowOfCell=row.createCell(0);
			
			String cityNameText=cityName.getText();
			rowOfCell.setCellValue(cityNameText);
			System.out.println(cityNameText);
			
		}

		FileOutputStream File=new FileOutputStream("./src/com/ExcelSheets/TimeAndDateRowData.xlsx");
		workbook.write(File);
		workbook.close();
		
	}
	
	
	public static void main(String[] args) throws IOException
	{
	
		CapturingFirstColumnData getData=new CapturingFirstColumnData();
		getData.applicationLaunch();
		getData.firstRow();
		getData.applicationClose();
		
	}

}
