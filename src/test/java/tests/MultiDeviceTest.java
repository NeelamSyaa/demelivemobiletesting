package tests;



	

	import java.net.URL;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
	import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionStateBuilder;
import io.appium.java_client.android.options.UiAutomator2Options;
//@Test
	public class MultiDeviceTest {
		  AndroidDriver realDriver ;

	   // @Test
	    public void realDeviceTest() throws Exception {

	        UiAutomator2Options options =
	                new UiAutomator2Options();

	        options.setPlatformName("Android");

	        options.setAutomationName("UiAutomator2");

	        options.setDeviceName("Real Android");

	        options.setUdid(
	            "adb-R9ZY60NJL9A-ScRJsF._adb-tls-connect._tcp"
	        );

	        options.setPlatformVersion("14");

	        options.setApp(
	            "C:\\Users\\Admin\\Downloads\\app-release 71.apk"
	        );

	        options.setAppPackage(
	            "com.saucelabs.mydemoapp.android"
	        );

	        options.setAppActivity(
	            ".view.activities.SplashActivity"
	        );
	        

	        options.setAutoGrantPermissions(true);

	     // Force the install even if a version downgrade or signature mismatch is detected
	        options.setCapability("appium:enforceAppInstall", true);

	        // Completely uninstalls the existing app before installing the new one
	        options.setCapability("appium:fullReset", true); 


	         realDriver =
	                new AndroidDriver(
	                    new URL(
	                        "http://127.0.0.1:4723"
	                    ),
	                    options
	                );


	        System.out.println(
	            "REAL DEVICE STARTED"
	        );


	        Assert.assertTrue(
	            realDriver.isAppInstalled(
	                "com.saucelabs.mydemoapp.android"
	            )
	        );
	        //wifi on
	        realDriver.setConnection(new ConnectionStateBuilder().withWiFiEnabled().build());
	        //wifi off
	        realDriver.setConnection(new ConnectionStateBuilder().withWiFiDisabled().build());
	        //Mobile Data ON
           realDriver.setConnection(new ConnectionStateBuilder().withDataEnabled().build());
           //No Internet/ aroplan mode
           
            realDriver.setConnection(new ConnectionStateBuilder().withAirplaneModeEnabled().build());
            
       
			//     17. OTP automation   String otp = realDriver.getotp   otpPage.enterOtp(otp);
            
          //  Background/foreground
            realDriver.runAppInBackground(Duration.ofSeconds(20));
            realDriver.activateApp("com.sml.saarthipro");
            
            
            
            
            

            // --- 2. GENERATE USER DATA IN V1.0 ---
            // Example: Log in or save a profile setting
            realDriver.findElement(By.id(":id/username_input")).sendKeys("test_user");
            realDriver.findElement(By.id(":id/save_profile_button")).click();
            
            // Verify data was successfully created in v1.0
            String storedUserV1 = realDriver.findElement(By.id(":id/profile_display_name")).getText();
            Assert.assertEquals(storedUserV1, "test_user");

            // --- 3. UPGRADE TO VERSION 2.0 ---
            // Terminate the app safely before pushing the upgrade file
            realDriver.terminateApp("com.sml.saarthipro");

            // Tell Appium to force install the new APK over the existing one without clearing data
            options.setCapability("appium:enforceAppInstall", true);
            
            // This installs version 2.0 directly onto the active device context
            realDriver.installApp("C:\\apps\\version_2.0.apk");

            // --- 4. VERIFY USER DATA PERSISTS IN V2.0 ---
            // Launch the upgraded application back into focus
            realDriver.activateApp("appium:enforceAppInstall");

            // Retrieve the data element from the new v2.0 UI layout
            String storedUserV2 = realDriver.findElement(By.id(":id/profile_display_name")).getText();
            
            // Core Assertion: The user data should match exactly across the upgrade lifecycle
            Assert.assertEquals(storedUserV2, "test_user", "Error: User data was wiped during the app upgrade!");
            
            // Clean up session
	        realDriver.quit();
	    }


	    @Test
	    public void backapp() {
	    	realDriver.runAppInBackground(Duration.ofSeconds(10));
	    }
	    
	    @Test
	    public void deeplink() {
	   

	    	// Execute deep link execution command
	    	realDriver.executeScript("mobile: deepLink", ImmutableMap.of(
	    	    "url", "myapp://products/item-123", 
	    	    "package", "com.example.myapp"
	    	));

	    	// Validation checkpoint: Verify you are on the target product page
	    	WebElement productTitle = realDriver.findElement(By.id("product_title"));
	    	Assert.assertEquals(productTitle.getText(), "Wireless Headphones");

	    }
	    @Test
	    public void Keyboard() {
	    if(	realDriver.isKeyboardShown()) {
	    	realDriver.hideKeyboard();
	    };
	    	
	    }
	    
	    @Test
	    public void switchToWebView() {
	    	WebDriverWait  wait = new WebDriverWait(realDriver, Duration.ofSeconds(30)) ;
	    	// 2. Fetch all available contexts  
	      Set<String> contextname = realDriver.getContextHandles();
	   
	      for(String onecontext:contextname) {
	    	  if(contextname.contains("webweiv")) {
	    		  realDriver.context(onecontext);
	    		  
	      }}
	    	  
	    }
	      
	    @Test
	      public void switchToNativeApp() {
    		  realDriver.context("NATIVE_APP");
    	        System.out.println("Successfully switched back to NATIVE_APP context.");
    	        ((MultiDeviceTest) realDriver.switchTo()).switchToWebView();
    	        ((MultiDeviceTest) realDriver.switchTo()).switchToNativeApp();
    	    }
	    
//	 //  @Test
//	    public void emulatorTest() throws Exception {
//
//	        UiAutomator2Options options =
//	                new UiAutomator2Options();
//
//	        options.setPlatformName("Android");
//
//	        options.setAutomationName("UiAutomator2");
//
//	        options.setDeviceName("Emulator");
//
//	        options.setUdid(
//	            "emulator-5554"
//	        );
//
//	        options.setPlatformVersion("14");
//
//	        options.setApp(
//	            "C:\\Users\\Admin\\Downloads\\app-release 68.apk"
//	        );
//
//	        options.setAppPackage(
//	            "com.saucelabs.mydemoapp.android"
//	        );
//
//	        options.setAppActivity(
//	            ".view.activities.SplashActivity"
//	        );
//
//	        options.setAutoGrantPermissions(true);
//
//
//	        AndroidDriver emulatorDriver =
//	                new AndroidDriver(
//	                    new URL(
//	                        "http://127.0.0.1:4725"
//	                    ),
//	                    options
//	                );
//
//
//	        System.out.println(
//	            "EMULATOR STARTED"
//	        );
//
//
//	        Assert.assertTrue(
//	            emulatorDriver.isAppInstalled(
//	                "com.saucelabs.mydemoapp.android"
//	            )
//	        );
//
//
//	        emulatorDriver.quit();
//	    }
	
}
