package demo;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class testing {

	public void setupmobileapp() throws MalformedURLException {
		UiAutomator2Options   opstion = new  UiAutomator2Options();
		opstion.setApp("apkpath");
		opstion.setDeviceName("adb-R9ZY60NJL9A-ScRJsF._adb-tls-connect._tcp");
		opstion.setPlatformName("andriod");
		opstion.setAutoGrantPermissions(true);
		opstion.setAutomationName("UiAutomator2");
		
		URL url = new URL("http://127.0.0.1:4723");
		AndroidDriver drvier = new AndroidDriver(url,opstion );

		//Verify application installation.
		// Install application
		drvier.installApp("apkpath");

		// Verify application installation
		if (drvier.isAppInstalled("com.example.app")) {
		    System.out.println("Application installed successfully");
		} else {
		    System.out.println("Application installation failed");
		}
		
		//Verify application uninstallation.
		
		// Uninstall application
		drvier.removeApp("com.example.app");

		// Verify application uninstallation
		if (!drvier.isAppInstalled("com.example.app")) {
		    System.out.println("Application uninstalled successfully");
		} else {
		    System.out.println("Application uninstallation failed");
		}
	}
}
