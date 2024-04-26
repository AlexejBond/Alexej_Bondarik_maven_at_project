package tests;

import driver.Driver;
import org.junit.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    @BeforeTest
    public void getConfig() {
        System.out.println(System.getProperty("CONFIG"));
    }

    @AfterTest
    public static void closeDriver() {

        Driver.destroyDriver();
    }
}