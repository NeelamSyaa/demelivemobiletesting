package Page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.DriverManager;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Loginpage {

	    private AndroidDriver driver;


	    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Username\"]")
	    WebElement username;

	    @AndroidFindBy(xpath = "//android.widget.EditText[@text=\"Password\"]")
	    WebElement password;

	    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\\\"\\\"]")
	    WebElement checkbox1;
	    
	    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\\\"Login\\\"]")
	    WebElement  login1;
	    
	    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\\\"Fleet Status\\\"]")
	    WebElement  textdeshboad;
	    
	    public Loginpage(AndroidDriver driver) {
	    	 this.driver = driver;
	         PageFactory.initElements(driver, this); 
	    }
	    
 public void sendkeyusename() {
	 username.sendKeys("8296574063"); 
 }
 public void sendkeypass() {
	 password.sendKeys("8296574063"); 
 }

  public void checkboxclick1() {
	  checkbox1.click();
  }
	   
  public void login1() {
	  login1.click();
  }
 
  public void textdeshboad() {
	  textdeshboad.click();
  }

	}
  
