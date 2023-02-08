package com.Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class OrangeHrmScreenShots 
{

	public static void takeScreenShot(WebDriver driver, String imageName) throws IOException
	{
		
		TakesScreenshot takeScreenShot=(TakesScreenshot)driver;
		File errorScreenShot=takeScreenShot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(errorScreenShot, new File("./OrangeHrmApplicationErrorScreenShots/"+imageName+".png"));
		
	}
}
