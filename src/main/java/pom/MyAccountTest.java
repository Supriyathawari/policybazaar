package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import utility.Utility;

public class MyAccountTest 
{ // variable
	
	@FindBy(xpath="//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement username;
	
	@FindBy(xpath = "//div[@title='Logout']") private WebElement logoutbutton;
	
	//constructor
	
	public MyAccountTest (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Method
	
	public String getActualUserName() throws InterruptedException
	{    
		Utility.wait(1000);
		Reporter.log("getting actual user name", true);
		String actualUN=username.getText();
		return actualUN;
	}
	
	public void clickonlogoutbutton()
	{
		Reporter.log("clicking logging out...", false);
		logoutbutton.click();
	}

}
