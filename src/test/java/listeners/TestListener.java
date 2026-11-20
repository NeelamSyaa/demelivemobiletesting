package listeners;




	import java.io.File;
	import java.io.IOException;
	import java.nio.file.Files;
	import java.nio.file.Path;
	import java.nio.file.Paths;
	import java.time.LocalDateTime;
	import java.time.format.DateTimeFormatter;

	import org.testng.ITestListener;
	import org.testng.ITestResult;

	import driver.DriverManager;
	import io.appium.java_client.android.AndroidDriver;

	import org.openqa.selenium.OutputType;

	public class TestListener implements ITestListener {


	    @Override
	    public void onTestFailure(
	            ITestResult result) {


	        try {

	            AndroidDriver driver =
	                    DriverManager.getDriver();


	            if (driver == null) {
	                return;
	            }


	            File source =
	                    driver.getScreenshotAs(
	                            OutputType.FILE
	                    );


	            String time =
	                    LocalDateTime.now()
	                            .format(
	                                    DateTimeFormatter
	                                            .ofPattern(
	                                                    "yyyyMMdd_HHmmss"
	                                            )
	                            );


	            String fileName =
	                    result.getName()
	                            + "_"
	                            + time
	                            + ".png";


	            Path directory =
	                    Paths.get(
	                            "test-output",
	                            "screenshots"
	                    );


	            Files.createDirectories(directory);


	            Path destination =
	                    directory.resolve(fileName);


	            Files.copy(
	                    source.toPath(),
	                    destination
	            );


	            System.out.println(
	                    "Screenshot saved: "
	                            + destination
	            );


	        } catch (IOException e) {

	            e.printStackTrace();
	        }
	    }
	}

