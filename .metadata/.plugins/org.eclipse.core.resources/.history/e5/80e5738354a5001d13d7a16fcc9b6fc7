package com.OrangeHrmApplicationTestCases;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.OrangeHrmApplication.BaseTest;
import com.Utility.ExcelCommonMethods;
import com.Utility.Log;
import com.Utility.OrangeHrmProperty;

public class LogInFunctionalityTest extends BaseTest
{
	
	Properties property;
	String excelFileInputPath="./src/main/java/com/OrangeHrmApplicationTestDataFiles/LogInTest.xlsx";
	String excelFileOutputPath="./src/main/java/com/OrangeHrmApplicationTestDataResultsFiles/LogInTestResultFile.xlsx";
	String SheetName="Sheet1";
	ExcelCommonMethods excelFile;
		

	@Test(priority=1,description="validating login Page-LOGIN Panel Text")
	public void validateLoginPageTest() throws IOException 
	{

		excelFile=new ExcelCommonMethods(excelFileInputPath, excelFileOutputPath, SheetName);
		property=OrangeHrmProperty.loadProperty();
      
		By loginPageLoginPanelTextLocator=By.id(property.getProperty("logInPageLogInPanelProperty"));
		WebElement loginPageLoginPanel=driver.findElement(loginPageLoginPanelTextLocator);
		
		String actual_loginPageLoginPanelText=loginPageLoginPanel.getText();
				
		excelFile.setCellValue(1, 1, actual_loginPageLoginPanelText);
		
		String expected_loginPageLoginPanelText=excelFile.getCellValue(1, 0);
		
		if(actual_loginPageLoginPanelText.equals(expected_loginPageLoginPanelText))
		{
			Log.info("Successfully navigated to the OrangeHRM Application - PASS");
			excelFile.setCellValue(1, 2, "Successfully navigated to the OrangeHRM Application - PASS" );
		}
		else
		{
			Log.info("Failed to navigate to the OrangeHRM Application - FAIL");
			excelFile.setCellValue(1, 2, "Failed to navigate to the OrangeHRM Application - FAIL" );
		}
	}
	
	@Test(priority = 2)
	public void titleValidation() throws IOException
	{
		
		String actual_loginPageTitle=driver.getTitle();
		excelFile.setCellValue(1, 4, actual_loginPageTitle);
		String expected_loginPageTitle=excelFile.getCellValue(1, 3);
		if(actual_loginPageTitle.equals(expected_loginPageTitle))
		{
			Log.info("Successfully Validated the OrangeHRM Application Login page Title - PASS");
			excelFile.setCellValue(1, 5, "Successfully Validated the OrangeHRM Application Login page Title - PASS" );
		}
		else
		{
			Log.info("Failed to navigate to the OrangeHRM Application - FAIL");
			excelFile.setCellValue(1, 5, "Failed to navigate to the OrangeHRM Application - FAIL" );
		}
	}
	
	@Test(priority = 3)
	public void urlValidation() throws IOException
	{
		
		String actual_LoginPageUrlAddress=driver.getCurrentUrl();
		excelFile.setCellValue(1, 7, actual_LoginPageUrlAddress);
		String expected_LoginPageUrlAddress=excelFile.getCellValue(1, 6);
		
		if(actual_LoginPageUrlAddress.contains(expected_LoginPageUrlAddress))
		{
			Log.info("Successfully Validated the OrangeHRM Application Login page URL Address - PASS");
			excelFile.setCellValue(1, 8, "Successfully Validated the OrangeHRM Application Login page URL Address - PASS" );
		}
		else
		{
			Log.info("Failed to Validate the OrangeHRM Application Login page URL Address - FAIL");
			excelFile.setCellValue(1, 8, "Failed to Validate the OrangeHRM Application Login page URL Address  - FAIL" );
		}
		excelFile.saveExcelData();
	}

/*
	@Test(priority = 2)
	private void multipleTestDataToExcel()
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
		
		
		
	}

	@Test(priority=3,description="OrangeHRM Application Login Functionality Test")
	public void validateLoginFunctionalityTest() throws IOException
	{
		int rowIndex=1;
		while(true)
		{
			try
			{
				String userName=excelFile.getCellValue(rowIndex, 9);

				String password=excelFile.getCellValue(rowIndex, 10);

				By userNameElementLocator=By.id(property.getProperty("UserNameProperty"));
				WebElement userNameElemen=driver.findElement(userNameElementLocator);
				userNameElemen.clear();
				userNameElemen.sendKeys(userName);
				By PasswordElementLocator=By.id(property.getProperty("PasswordProperty"));
				WebElement PasswordElemen=driver.findElement(PasswordElementLocator);
				PasswordElemen.clear();
				PasswordElemen.sendKeys(password);
				By LoginPageLoginButtonLocator=By.className(property.getProperty("logInButtonProperty"));
				driver.findElement(LoginPageLoginButtonLocator).click();
				if(isLoginPage())
				{
					//Login page
					Log.info("Failed to Navigate to the OrangeHRM Application - FAIL");
					OrangeHrmScreenShots.takeScreenShot(driver,userName+password);
					excelFile.setCellValue(rowIndex, 11, "Failed to Navigate to the OrangeHRM Application - FAIL");
				}
				else
				{
					//HomePage
					Log.info("Successfully Navigated to the OrangeHRM Application - Pass");
					validateHomePage(rowIndex);
					Logout();
				}


				rowIndex++;

			}
			catch (Exception e)
			{
				break;
			}

		}

		excelFile.saveExcelData();
	}

	private boolean isLoginPage()
	{

		try
		{
			By LoginPageInvalidMessageLocator=By.id(property.getProperty("InvalidMessageproperty"));
			return driver.findElement(LoginPageInvalidMessageLocator).isDisplayed();
		}	
		catch (Exception e)
		{
			return false;
		}
	}
	private void validateHomePage(int rowIndex) throws IOException
	{
		String expected_HomePageText=excelFile.getCellValue(1, 12);
		By HomePageWelocomeAdminLocator=By.linkText(property.getProperty("WelcomeAdminProperty"));
		String actual_HomePageText=driver.findElement(HomePageWelocomeAdminLocator).getText();
		excelFile.setCellValue(1, 13, actual_HomePageText);
		if(actual_HomePageText.contains(expected_HomePageText))
		{
			Log.info("Successfully Navigated to the OrangeHRM Application HomePage - Pass");
			excelFile.setCellValue(rowIndex, 14, "Successfully Navigated to the OrangeHRM Application HomePage - Pass");
		}
		else
		{
			Log.info("Failed to Navigate to the OrangeHRM Application HomePage - FAIL");
			OrangeHrmScreenShots.takeScreenShot(driver,"FailedToNavigateHomePage");
			excelFile.setCellValue(rowIndex, 14, actual_HomePageText);
		}
	}
	private void Logout() throws IOException
	{

		By HomePageWelcomeAdminLocator=By.linkText(property.getProperty("WelcomeAdminProperty"));
		driver.findElement(HomePageWelcomeAdminLocator).click();
		By homePageLogoutElementLocator=By.linkText(property.getProperty("logOutProperty"));
		driver.findElement(homePageLogoutElementLocator).click();

		By loginPageLoginPanelTextLocator=By.id(property.getProperty("logInPageLogInPanelProperty"));
		String actual_loginPageLoginPanelTextAfterLogout=driver.findElement(loginPageLoginPanelTextLocator).getText();
		excelFile.setCellValue(1, 16, actual_loginPageLoginPanelTextAfterLogout);
		String expected_loginPageLoginPanelTextAfterLogout=excelFile.getCellValue(1, 15);
		if(actual_loginPageLoginPanelTextAfterLogout.equals(expected_loginPageLoginPanelTextAfterLogout))
		{
			Log.info("Successfully Logout from the OrangeHRM Application - PASS");
			excelFile.setCellValue(1, 17, "Successfully Logout from the OrangeHRM Application - PASS" );
		}
		else
		{
			Log.info("Failed to Logout from OrangeHRM Application - FAIL");
			excelFile.setCellValue(1, 17, "Failed to Logout from OrangeHRM Application - FAIL" );
		}

	}
*/
}