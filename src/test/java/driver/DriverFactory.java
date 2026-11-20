package driver;

import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import utils.ConfigReader;

public class DriverFactory {

    public static AndroidDriver createDriver()
            throws Exception {  

    	UiAutomator2Options options = new UiAutomator2Options();

    	options.setPlatformName(
    			ConfigReader.getProperty("platformName")
    	);

    	options.setAutomationName(
    	    ConfigReader.getProperty("automationName")
    	);

    	options.setDeviceName(
    	    ConfigReader.getProperty("deviceName")
    	);

    	options.setPlatformVersion(
    	    ConfigReader.getProperty("platformVersion")
    	);

    	options.setApp(
    	    ConfigReader.getProperty("appPath")
    	);

    	options.setAppPackage(
    	    ConfigReader.getProperty("appPackage")
    	);

    	options.setAppActivity(
    	    ConfigReader.getProperty("appActivity")
    	);

    	options.autoGrantPermissions();

    	options.setSystemPort(
    	    Integer.parseInt(
    	        ConfigReader.getProperty("systemPort")
    	    )
    	);
		return null;
    }
}