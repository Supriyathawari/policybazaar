package pom;


//import java.io.IOException;

//import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

//import commonMethod.CommonMethodUse;

public class PomloginPage 
{
	//veriable
	@FindBy(xpath = "//a[text()='Sign in']") private  WebElement signinbutton;
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement  Mobilenofield;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]")private WebElement signinwithpassword;
	@FindBy(name = "password")private WebElement passwordfield;
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement loginwithsigninbutton;
	@FindBy(xpath = "//div[text()='My Account']")  private WebElement   createmyaccount;
	@FindBy(xpath = "//span[text()=' My profile ']") private WebElement  clickonmyprofile;
	
	
	
	//constructor
	
	public PomloginPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
		
	}
	
	//method
	
	public void clickOnSignInbuttonHomepage() 
	{
		Reporter.log("click on sign in button", true);
		signinbutton.click();
	}
	
	public void intermobileno(String MobNo) 
	{
		Reporter.log("inter mobile number", true);
		Mobilenofield.sendKeys(MobNo);
	}
	
	public void clickwithsigninbutton() 
	{
		Reporter.log("click with sign in button", true);
		signinwithpassword.click();
	}
	
	public void Interpassword(String PWD) 
	{
		Reporter.log("inter password", true);
		passwordfield.sendKeys(PWD);
	}
	
	public void loginwithsigninbuttonHomepage()
	{
		Reporter.log("login with sign in button home page", true);
		loginwithsigninbutton.click();
	}
	
	public void myaccount()
	{
		Reporter.log("my account page ", true);
		createmyaccount.click();
	}
	
	public void myprofile()
	{
		Reporter.log("my profile page", true);
		clickonmyprofile.click();
	}
	
	

}
