package utils;



	

	import io.appium.java_client.android.AndroidDriver;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import java.time.Duration;
	import java.util.Set;

	public class ContextManager {

	    private final AndroidDriver driver;

	    public ContextManager(AndroidDriver driver) {
	        this.driver = driver;
	    }

	    /**
	     * Dynamically switches the driver context to WebView.
	     * This method handles delayed WebView rendering by polling available contexts.
	     */
	    public void switchToWebView() {
	        // 1. Wait until a WebView context appears (polling for up to 10 seconds)
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(d -> driver.getContextHandles().size() > 1);

	        // 2. Fetch all available contexts
	        Set<String> contextNames = driver.getContextHandles();
	        System.out.println("Available Contexts Found: " + contextNames);

	        // 3. Loop and switch to the context containing "WEBVIEW"
	        for (String contextName : contextNames) {
	            if (contextName.contains("WEBVIEW")) {
	                driver.context(contextName);
	                System.out.println("Successfully switched to Context: " + contextName);
	                return;
	            }
	        }
	        throw new RuntimeException("CRITICAL: Target WEBVIEW context could not be located.");
	    }

	    /**
	     * Switches the driver context back to the native application view.
	     */
	    public void switchToNativeApp() {
	        driver.context("NATIVE_APP");
	        System.out.println("Successfully switched back to NATIVE_APP context.");
	    }
	}


