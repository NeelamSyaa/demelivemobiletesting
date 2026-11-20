      package tests;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Page.Loginpage;
import base.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.GestureUtil;

public class loginTest  extends BaseTest {

	 private GestureUtil gestureUtil;
	    @Test
	    public void validLoginTest() throws InterruptedException {

	        Loginpage loginPage =
	                new Loginpage(driver);

	      try {
	   	
	           Thread.sleep(4000);
	        loginPage.sendkeyusename();
	        Thread.sleep(4000);
	        loginPage.sendkeypass();
	        Thread.sleep(4000);
	        loginPage.checkboxclick1();
	        Thread.sleep(4000);
	        loginPage.login1();
	        Thread.sleep(4000);
	        loginPage.textdeshboad();


	        // Verify login was successful
	        String currentPackage =
	                driver.getCurrentPackage();

	        System.out.println(
	                "Current package: "
	                        + currentPackage
	        );
	        gestureUtil.scrollDown();

	        Assert.assertEquals(
	                currentPackage,
	                "com.saucelabs.mydemoapp.android",
	                "Application package is incorrect"
	        );
	    }
	    catch (Exception e) {

	        // Take screenshot
	        File screenshot = driver.getScreenshotAs(
	            OutputType.FILE
	        );

	        System.out.println(
	            "Test failed: " + e.getMessage()
	        );

	        e.printStackTrace();

	        throw e;
	    }
	
	    }
}
