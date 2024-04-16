package day17;

package webdriver.practice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class W3schoolsTask {
    private WebDriver driver;

    @Before
    public void openBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }

    @Test
    public void searchResultsCompareTest() {

        driver.get("https://www.w3schools.com/java/");
        Actions make = new Actions(driver);
        WebElement title = driver.findElement(By.xpath("//span[text()='Tutorial']"));
        make.doubleClick(title)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.LEFT_CONTROL, "v");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//a[text()='Change to English']")).click();

        List<WebElement> searchResults = driver.findElements(By.xpath("//div/h1[text()='Search Results']/../div/div"));
        String wordToCheck = "tutorial";


    }

    @After
    public void closeBrowser() {
        driver.close();
    }
}

