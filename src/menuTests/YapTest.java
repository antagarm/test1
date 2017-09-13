package menuTests;

import org.testng.annotations.Test;

import com.sun.jna.platform.win32.Wdm.KEY_INFORMATION_CLASS;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.TransducedAccessor_field_Double;
import com.thoughtworks.selenium.Wait;

import sun.awt.SunHints.Key;

import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;


public class YapTest {
	FirefoxDriver driver;
	WebDriverWait wait;
	String user="iGUEST";
	String pass="Ayrtonsenna199!";
  
  @BeforeClass
	  public void beforeClass() {
		  
		  driver=new FirefoxDriver();
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  
	  }	
  private void login() {
	  
	  WebElement login= driver.findElementByCssSelector("#welcome-box a:last-child");
	  login.click();
	  WebElement username=driver.findElementById("nickname");
	  username.sendKeys(user);
	  WebElement password= driver.findElementById("password");
	  password.sendKeys(pass);
	  password.sendKeys(Keys.ENTER); 
  }
	
  @Test
  
  public void loginTest() throws InterruptedException {
	  wait= new WebDriverWait(driver, 10);
	  driver.get("https://yaplakal.com");
	  login();
	  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#top-logo")));
	  WebElement mainPage=driver.findElement(By.cssSelector("#top-logo a"));
	  mainPage.click();
	  WebElement topRatedFirst=driver.findElement(By.cssSelector("#list-rank li:first-child .subtitle"));
	  System.out.println(topRatedFirst.getText());

	  topRatedFirst.click();
	  int currentRate= Integer.parseInt(driver.findElement(By.cssSelector(".rating-value")).getText());
	  System.out.println(currentRate);
	  try {
		  WebElement pushPlus=driver.findElement(By.cssSelector(".postcolor [title='+']"));
		  pushPlus.click();
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("alredy voted");
	}

	  
	  
  }
  

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
