package utils;



import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumDriver;


public class GestureUtil {

	

	    private final AppiumDriver driver;

	    public GestureUtil(AppiumDriver driver) {
	        this.driver = driver;
	    }

	    /**
	     * Reusable W3C Swipe Method
	     */
	    public void performSwipe(int startX, int startY, int endX, int endY) {
	        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	        Sequence swipeSequence = new Sequence(finger, 1);

	        swipeSequence.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
	        swipeSequence.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	        swipeSequence.addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY));
	        swipeSequence.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

	        driver.perform(Collections.singletonList(swipeSequence));
	    }

	    /**
	     * Helper method to automatically scroll DOWN by calculating device dimensions
	     */
	    public void scrollDown() {
	        Dimension size = driver.manage().window().getSize();
	        
	        // Calculate X and Y coordinates dynamically
	        int startX = size.width / 2;          // Center of the screen horizontally
	        int startY = (int) (size.height * 0.8); // 80% from the top of the screen
	        int endY = (int) (size.height * 0.2);   // 20% from the top of the screen

	        // Call the core swipe method
	        performSwipe(startX, startY, startX, endY);
	    }


}
