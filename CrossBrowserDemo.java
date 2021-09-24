package testNGDemoPack;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserDemo {
	WebDriver driver;
	
  @BeforeClass
  @Parameters("browser")
  public void BeforeTest(String browser){
	  if(browser.equalsIgnoreCase("chrome")) {
	  System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
	  driver=new ChromeDriver();
   }
	  else if(browser.equalsIgnoreCase("edge")) {
		  System.setProperty("webdriver.edge.driver","D:\\browsers\\msedgedriver.exe");
		  driver=new EdgeDriver();
	  }
	  driver.get("https://www.facebook.com/");
	  driver.manage().window().maximize();
  }
  @AfterClass
  public void AfterTest(){
	  driver.close();
  }
  @Test
  public void login() throws InterruptedException{
	  WebElement logo=driver.findElement(By.xpath("//img[@class='fb_logo _8ilh img']"));
	  Assert.assertEquals(true, logo.isDisplayed());
	  String height=logo.getCssValue("height");
	  Assert.assertEquals(height,"106px");
	  
	  
	  driver.findElement(By.xpath("//*[contains(text(),'English (UK)')]")).click();
	  driver.findElement(By.id("email")).sendKeys("anand.kolapkar@gmail.com");
	  driver.findElement(By.id("pass")).sendKeys("Shrisairam123!");
	  driver.findElement(By.xpath("//button[@name='login']")).click();
	 
	  
	
	  
  }
}
