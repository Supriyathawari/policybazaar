package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility 
{
	//Commonly used method 
	//Screenshot 
	//read data for excel
	//wait
	// scrolling 
	
	public static void TakeScreenshot(WebDriver driver, String FileName) throws IOException
	{
	    File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    
	    File dec=new File("C:\\Users\\HP\\eclipse-workspace\\policybazaar\\screenshots\\myscreenshot.png");
	    
	    FileHandler.copy(src, dec);
	    
	    Reporter.log("TakeScreenshot", true);
	    Reporter.log("takeing Screen shot"+dec, true);
	}
	
	public static void scrollIntoView(WebDriver driver, WebElement element)
	{
		  ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", element);
		  
		  Reporter.log("ScrollIntoView", true);
		  
		}
	
	public static String readdatafromExcel(int row, int cell) throws EncryptedDocumentException, IOException
	{
		FileInputStream Myfile=new FileInputStream("D:\\18febExcelSheet.xlsx");
		 Reporter.log("read in data from excel row data"+row+"cell data is "+cell, true);
		String value = WorkbookFactory.create(Myfile).getSheet("Sheet3").getRow(row).getCell(cell).getStringCellValue();
		
		return value;
		
	}
	
	
	public static void wait(int WaitTime) throws InterruptedException
	{
		Reporter.log("waiting for"+WaitTime+"mili sec", true);
		Thread.sleep(WaitTime);
	}
	
	
	
	public static String readDataFromPropertyFile(String Key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream myfile=new FileInputStream("C:\\Users\\HP\\eclipse-workspace\\feb18_2023_selenium\\Myproperty.properties");
		prop.load(myfile);
		String value=prop.getProperty(Key);
		Reporter.log("reading data"+Key+"from property", true);
		return value;
		
	}

}
