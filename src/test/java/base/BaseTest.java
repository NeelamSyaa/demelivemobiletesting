package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import driver.DriverFactory;
import driver.DriverManager;
import io.appium.java_client.android.AndroidDriver;

public class BaseTest {

    protected AndroidDriver driver;


    @BeforeMethod
    public void setUp() throws Exception {

        System.out.println(
                "========== SETUP START =========="
        );


        driver =
                DriverFactory.createDriver();


        DriverManager.setDriver(driver);


        System.out.println(
                "Application launched successfully"
        );


        System.out.println(
                "========== SETUP END =========="
        );
    }


    @AfterMethod
    public void tearDown() {

        System.out.println(
                "========== TEARDOWN =========="
        );


        DriverManager.quitDriver();


        System.out.println(
                "Driver closed"
        );
    }
}