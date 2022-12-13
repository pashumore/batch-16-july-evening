package neoStoxUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import neoStoxBase.BaseNew;

public class UtilityNew extends BaseNew
{
	public static String readDataFrompropertyFile(String key) throws IOException
	{
	//create object of Properties class--> java
	Properties prop= new Properties();
	
	//create object of FileInputStream and pass properties file path as aparameter
	FileInputStream myFile= new FileInputStream("C:\\Users\\Prashant More\\eclipse-workspace\\16_july_maven\\ Properties.properties");
	
	prop.load(myFile);
	
	String value = prop.getProperty(key);
	
	Reporter.log("Reading " +key+ " from property file", true);
	
	return value;
	}
	public static String screenshot(WebDriver driver, String screenShotName) throws IOException
	{
	wait(driver, 500);
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest= new File("E:\\16 july A even Selenium\\Selenium\\Screenshot"+screenShotName+".png");
	
	FileHandler.copy(src, dest);
	
	Reporter.log("taking screenshot", true);
	return screenShotName;
	}
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
	wait(driver, 500);
	
	JavascriptExecutor js = (JavascriptExecutor)driver;
	
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	
	Reporter.log("SCrolling into view",true);
	}
	public static void wait(WebDriver driver, int waitTime)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofMillis(waitTime));
	
	Reporter.log("Waiting for "+waitTime+"ms",true);
	}
	
}



