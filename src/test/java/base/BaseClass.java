
package base;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.http.ClientConfig;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;

public class BaseClass {

    AndroidDriver driver;

    String appPackage = "com.sml.saarthipro";

    @BeforeTest
    public void setupData() throws MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setPlatformName("Android");
        options.setDeviceName("Android Device");
        // options.setUdid("YOUR_DEVICE_ID");

        options.setApp("C:\\APK\\saarthi.apk");
        options.setAutoGrantPermissions(true);

        URL url = new URL("http://127.0.0.1:4723");

        driver = new AndroidDriver(url, options);
    }

    @Test(priority = 1)
    public void deviceHandle() {

        // Put application in background for 10 seconds
        driver.runAppInBackground(Duration.ofSeconds(10));

        // Activate application
        driver.activateApp("com.sml.sharthpro");

        // Check whether application is installed
        boolean installed = driver.isAppInstalled("com.sml.sharthpro");

        System.out.println("App installed: " + installed);

        // Check application state
        ApplicationState state = driver.queryAppState(appPackage);

        System.out.println("Application state: " + state);

        // Uninstall application
        // driver.removeApp(appPackage);
    }
    
    @Test(priority = 2)
    public void  notivictionmobileapp() {
       driver.openNotifications();
    	WebElement textclick = driver.findElement(AppiumBy.androidUIAutomator(""));
    System.out.print(textclick.getText());
    
    }
    

    @AfterTest(alwaysRun = true)
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}
