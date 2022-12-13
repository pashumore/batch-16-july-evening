package neoStoxBase;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import neoStoxUtility.UtilityNew;

public class BaseNew 
{
	protected WebDriver driver;
	
	public void launchBrowser() throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver","E:\\16 july A even Selenium\\Selenium\\chromedriver.exe\"");
			
	driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get(UtilityNew.readDataFrompropertyFile("url"));
	
	Reporter.log("Launching browser", true);
	
	Thread.sleep(1000);


}
}
