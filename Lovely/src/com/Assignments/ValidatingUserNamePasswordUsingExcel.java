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
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ValidatingUserNamePasswordUsingExcel 
{
	public static void main(String[] args) throws IOException, InterruptedException 
	{
		String ApplicationUrl="http://127.0.0.1/orangehrm-4.2.0.1/symfony/web/index.php/auth/login";
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "./DriverFiles/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(ApplicationUrl);
		
		driver.manage().window().maximize();
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		FileInputStream File=new FileInputStream("./src/com/ExcelSheets/ValidationOfUserNameAndPassword.xlsx");	
		
		XSSFWorkbook WorkBook=new XSSFWorkbook(File);
		
		XSSFSheet Sheet= WorkBook.getSheet("Sheet1");
		
		int rowscount=Sheet.getLastRowNum();
		System.out.println("Number of Rows in sheet :-"+rowscount);
		
		for(int rowindex=1;rowindex<=rowscount;rowindex++)
		{
			Row row1=Sheet.getRow(rowindex);

			int cellcount=row1.getLastCellNum();
			System.out.println("Cell count of sheet1 : - "+cellcount);

			for (int rowofcellindex=0;rowofcellindex<=1;rowofcellindex++)
			{
				Cell usernamecell=row1.getCell(rowofcellindex);

				String Username=usernamecell.getStringCellValue();
				
				System.out.println("username:-"+Username);
				switch(rowofcellindex)
				{
				case 0:
						By userNameL=By.id("txtUsername");
						WebElement userName=driver.findElement(userNameL);
						userName.sendKeys(Username);
						break;
				case 1:
					
						By PasswordL=By.name("txtPassword");
						WebElement Password=driver.findElement(PasswordL);
						Password.sendKeys(Username);
						
				}
			}
			By LoginL1=By.className("button");
			WebElement Loginn=driver.findElement(LoginL1);
			Loginn.click();
			
			try 
			{
				 By AdminL=By.id("menu_admin_viewAdminModule");
				 WebElement HomePage=driver.findElement(AdminL);
				 String HomePageText=HomePage.getText();
				 
				 System.out.println(HomePageText);
					
				 Sheet.getRow(rowindex).createCell(2).setCellValue("Pass");
				 				 
			 } 
			 catch (Exception e) 
			 {
				
				 
				 By InvalidCredentialL=By.id("spanMessage");
				 WebElement InvalidCredentials=driver.findElement(InvalidCredentialL);
				 String ActualInvalidText=InvalidCredentials.getText();
				 System.out.println(ActualInvalidText);
				 Sheet.getRow(rowindex).createCell(2).setCellValue("Fail");
				  				 
				 File LogInScreenShot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 FileUtils.copyFile(LogInScreenShot, new File("./ValidationScreenShots/"+rowindex+".png"));

			 }
			
		}
		
		By WelcomeAdminL=By.id("welcome");
		WebElement WelcomeAdmin=driver.findElement(WelcomeAdminL);
		WelcomeAdmin.click();
		
		WebDriverWait Wait=new WebDriverWait(driver, 10);
		Wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WelcomeAdminL));
		
		WebElement LogOut=driver.findElement(By.linkText("Logout"));
		LogOut.click();
		FileOutputStream file =new FileOutputStream("./src/com/ExcelSheets/ValidationOfUserNameAndPassword.xlsx");
		WorkBook.write(file);
		WorkBook.close();
		
		
		
		driver.quit();

	}
}

