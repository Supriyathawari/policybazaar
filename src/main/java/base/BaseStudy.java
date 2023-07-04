package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;

public class BaseStudy 
{    
	//Driver and Browser setUp
	static protected  WebDriver driver;
	
	public void lunchbrowser() throws IOException
	{
		 driver=new ChromeDriver();
		 driver.get("https://www.policybazaar.com/");
		driver.manage().window().maximize();
		Reporter.log("lunching Browser", true);
	}
	
	public void lunchbrowserfrompropertyfile() throws IOException
	{
		 driver=new ChromeDriver();
		 driver.get(Utility.readDataFromPropertyFile("url"));
		driver.manage().window().maximize();
		Reporter.log("lunching Browser", true);
	}
	
	public void closeBrowser() throws InterruptedException
	{
		Utility.wait(1000);
		Reporter.log("Closing Browser", true);
		driver.close();
	}

}
