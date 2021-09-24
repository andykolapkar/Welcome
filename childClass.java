package testNGDemoPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class childClass extends superClass {
	
	@Test(dependsOnMethods = "OpenBrowser")
	public void SignIn()
	{
		WebElement userID=driver.findElement(By.cssSelector("input#userid"));
		userID.sendKeys("HB5890");
		WebElement passWord= driver.findElement(By.cssSelector("input#password"));
		passWord.sendKeys("pransovi91!");
		WebElement LoginBtn=driver.findElement(By.xpath("//button[@class='button-orange wide']"));
		LoginBtn.click();
		System.out.println("SignIn Successfully");
	}
	@Test(dependsOnMethods = "SignIn")
	public void Logout()
	{
		driver.close();
	}
	
	
	

}
