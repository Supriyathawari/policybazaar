package test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class NewTest1 {
  @Test
  public void f()
  {
	 WebDriver driver=new ChromeDriver();
	 driver.get("https://mvnrepository.com/");
  }
}
