package tests;

import driver.Driver;
import org.junit.AfterClass;

public class BaseTest {

    @AfterClass
    public static void closeDriver() {

        Driver.destroyDriver();
    }
}