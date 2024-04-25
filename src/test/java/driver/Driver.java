package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Collections;
import java.util.Optional;


public class Driver {
    public static WebDriver driver;


    protected static Config config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
                    Config.CHROME : Config.valueOf(System.getProperty("CONFIG"));

    public static WebDriver getWebDriver() {
        return switch (config) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        if (null == driver) {
            ChromeOptions browserOptions = new ChromeOptions();
            browserOptions.addArguments("--incognito");
            browserOptions.addArguments("--start-maximized");
            browserOptions.addArguments("--disable-infobars");
            browserOptions.setExperimentalOption("excludeSwitches",
                    Collections.singletonList("enable-automation"));
            driver = new ChromeDriver(browserOptions);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void destroyDriver() {
        driver.quit();
        driver = null;
    }

    private static WebDriver getFFDriver() {
        return null;
    }

    private static WebDriver getRemoteDriver() {
        return null;
    }

}
