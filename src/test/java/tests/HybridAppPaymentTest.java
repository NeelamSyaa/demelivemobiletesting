package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import io.appium.java_client.android.AndroidDriver;
import utils.ContextManager;

public class HybridAppPaymentTest extends BaseTest {

	private  AndroidDriver driver;
    private ContextManager contextManager;

    

    @Test
    public void testWebViewCheckoutFlow() {
        // --- 1. NATIVE ACTIONS ---
        // Click the native checkout button inside the native app frame
        driver.findElement(By.id("com.example.hybridapp:id/btn_checkout")).click();

        // --- 2. SWITCH CONTEXT TO WEBVIEW ---
        // The app now opens an embedded web container payment portal
        contextManager.switchToWebView();

        // --- 3. WEB ACTIONS (Standard Selenium locators match here) ---
        // Type into the web input fields inside the WebView frame
        driver.findElement(By.cssSelector("input#card-number")).sendKeys("4111222233334444");
        driver.findElement(By.id("submit-payment-btn")).click();

        // Validate the success message generated inside the web document frame
        String statusText = driver.findElement(By.className("success-msg")).getText();
        Assert.assertEquals(statusText, "Payment Successful!");

        // --- 4. RETURN TO NATIVE ---
        // Switch back to close out the native flow
        contextManager.switchToNativeApp();
        
        // Click the native back-to-home dashboard navigation button
        driver.findElement(By.id("com.example.hybridapp:id/btn_home")).click();
    }

  
}
