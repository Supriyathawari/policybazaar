package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseStudy;
import pom.MyAccountTest;
import pom.PomloginPage;
import utility.Utility;



//@Listeners(testStudy.Listener.class)
public class PB_TC_1020_ValidatedPolicyUserName1 extends BaseStudy
{   
	  MyAccountTest myacc;
	  PomloginPage login;
	  String TCID="PB_TC1234";
	  
	  
	@BeforeClass
	public void lunchBrowser() throws InterruptedException, IOException
	{   
		Utility.wait(100);
		lunchbrowserfrompropertyfile();
		
		login=new PomloginPage(driver);
		myacc=new MyAccountTest(driver);
	}
	
	@BeforeMethod
	public void signintoPolicyBazaar() throws InterruptedException, EncryptedDocumentException, IOException
	{
		Utility.wait(1000);
		login.clickOnSignInbuttonHomepage();
		Utility.wait(1000);
		login.intermobileno(Utility.readDataFromPropertyFile("mobNum"));
		Utility.wait(1000);
		login.clickwithsigninbutton();
		Utility.wait(1000);
		login.Interpassword(Utility.readDataFromPropertyFile("pwd"));
		Utility.wait(1000);
		login.loginwithsigninbuttonHomepage();
		Utility.wait(2000);
		login.myaccount();
		Utility.wait(1000);
		login.myprofile();
		Utility.wait(1000);
		
		Set<String> allpageid = driver.getWindowHandles();
		List<String> l = new ArrayList<>(allpageid);
		String mainpageid = l.get(0);
		String childpageid = l.get(1);
		
		driver.switchTo().window(childpageid);
		Reporter.log("switching to child page id ", true);
		
	}
	
  @Test
  public void validatedusername() throws EncryptedDocumentException, IOException, InterruptedException 
  {   
	  Utility.wait(1000);
	 String actualUN = myacc.getActualUserName();
	 
	String expUN = Utility.readDataFromPropertyFile("UN");
	Utility.wait(1000);
	Assert.assertEquals(actualUN,expUN,"tc is failed actual and exp value are not maching");
	//Utility.TakeScreenshot(driver,actualUN +" "+ TCID);
	  
  }
  
  @AfterMethod
  public void logoutfrompolicybazaar()
  {
	  myacc.clickonlogoutbutton();
  }
  
  @AfterClass
  public void CloseApplication() throws InterruptedException
  {
	  closeBrowser();
  }
}
