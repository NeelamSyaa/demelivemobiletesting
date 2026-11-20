package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;

public class MobileTest  {

	
	    	
	    	
	    	private AppiumDriver driver;

	        @BeforeMethod
	        @Parameters({"platformName", "deviceName", "udid", "appiumPort", "systemPort"})
	        public void setup(
	                String platformName,
	                String deviceName,
	                String udid,
	                String appiumPort,
	                String systemPort) throws MalformedURLException, URISyntaxException {

	            DesiredCapabilities caps = new DesiredCapabilities();

	            caps.setCapability("platformName", platformName);
	            caps.setCapability("appium:deviceName", deviceName);
	            caps.setCapability("appium:udid", udid);

	            if (platformName.equalsIgnoreCase("Android")) {
	                caps.setCapability("appium:automationName", "UiAutomator2");
	                caps.setCapability("appium:systemPort",
	                        Integer.parseInt(systemPort));
	            } else {
	                caps.setCapability("appium:automationName", "XCUITest");
	            }

	            driver = new AppiumDriver(
	                    new URI("http://127.0.0.1:" + appiumPort).toURL(),
	                    caps
	            );
	           
	        }

	        @Test
	        public void loginTest() {

	            System.out.println(
	                    "Running on thread: " +
	                    Thread.currentThread().getId()
	            );
	               // Your Appium test steps
	            // driver.findElement(...).click();
	            
	           
	        }

	      
	        @AfterMethod
	        public void tearDown() {
	            if (driver != null) {
	                driver.quit();
	            }
	        }
	  
}
