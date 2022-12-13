package neoStoxUtility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import neoStoxBase.BaseNew;

public class Listener extends BaseNew implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
	Reporter.log("TC failed please try again...", true);
	try {
		UtilityNew.screenshot(driver,result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void onTestSuccess(ITestResult result)
	{
	Reporter.log("TC success...", true);
	}
	public void onTestSkipped(ITestResult result)
	{
	Reporter.log("TC is skipped please check", true);
	}


}
