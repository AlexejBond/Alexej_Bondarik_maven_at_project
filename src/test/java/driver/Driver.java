package driver;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.Optional;


public class Driver {
    public static WebDriver driver;
    private static int screenshotCounter = 1;


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

    public static void waitForElementAppearXPath(WebDriver driver, String elToWaitForXPath) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elToWaitForXPath)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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


    public static void makeScreenshot(WebDriver driver) {
        byte[] asBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        String screenshotName = String.format("Screenshot_%d.png", screenshotCounter);

        try {
            Files.write(Paths.get("D:\\Projects\\Java\\Screenshots\\" + screenshotName), asBytes);
            screenshotCounter++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
