package driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Optional;

import static driver.WebDriverConfig.FF;
import static driver.WebDriverConfig.REMOTE;

public class WebDrivers {
    static WebDriver driver = null;

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = getWebDriver();
        }
        return driver;
    }

    protected static WebDriverConfig config =
            Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
                    WebDriverConfig.CHROME : WebDriverConfig.valueOf(System.getProperty("CONFIG"));

    private static WebDriver getWebDriver() {
        return switch (config) {
            case FF -> getFFDriver();
            case REMOTE -> getRemoteDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
//        browserOptions.addArguments("--incognito");
        browserOptions.addArguments("--start-maximized");
        return new ChromeDriver(browserOptions);
    }

    private static WebDriver getFFDriver() {
        return null;
    }

    private static WebDriver getRemoteDriver() {
        return null;
    }
}
