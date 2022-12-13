package neoStoxTest;

import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import neoStoxBase.BaseNew;
import neoStoxPom.NeoStoxHomePage;
import neoStoxPom.NeoStoxLoginpage;
import neoStoxPom.NeoStoxPasswordPage;

import neoStoxUtility.UtilityNew;

public class ValidateneostoxUsername extends BaseNew 
{


NeoStoxLoginpage login;
NeoStoxPasswordPage password;
NeoStoxHomePage home;
@BeforeClass
public void launchNeoStox() throws InterruptedException, IOException
{
launchBrowser();//form base class
login= new NeoStoxLoginpage(driver);

password= new NeoStoxPasswordPage(driver);
home= new NeoStoxHomePage(driver);
}
@BeforeMethod
public void logintoNeoStox() throws EncryptedDocumentException, IOException,
InterruptedException
{
login.sendMobileNum(driver, UtilityNew.readDataFrompropertyFile(""));
login.clickOnSignInButton(driver);
UtilityNew.wait(driver, 1000);
password.enterPassword(driver, UtilityNew.readDataFrompropertyFile(""));
Thread.sleep(1000);
password.clickOnSubmitButton(driver);
Thread.sleep(1000);
home.handlePopUp(driver);
}
@Test
public void validateUserName()
{
	Assert.assertEquals(home.equals(home), null);
}
}
