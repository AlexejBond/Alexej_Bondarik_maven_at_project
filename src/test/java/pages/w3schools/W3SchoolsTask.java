package pages.w3schools;

import driver.WebDrivers;
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

public class W3SchoolsTask {
    WebDriver driver = WebDrivers.getDriver();


    @Before
    public void openW3schoolsSite() {
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.xpath("//*[@id='accept-choices']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

    }


    @Test
    public void selectAndCopyTitleBy2Click() {
        Actions make = new Actions(driver);
        WebElement title = driver.findElement(By.xpath("//*[@id='main']/h1/span"));
        make.doubleClick(title)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build()
                .perform();

        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id='W0wltc']/div")).click();
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.LEFT_CONTROL, "v");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);
//        driver.findElement(By.xpath("//a[text()='Change to English']")).click();

        List<WebElement> searchResults = driver.findElements(By.xpath("//div/h1[text()='Search Results']/../div/div"));
        String wordToCheck = "tutorial";


       //TODO
        boolean allResultsContainSearchWord = true;
        for (WebElement result : searchResults) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(wordToCheck)) {
                allResultsContainSearchWord = false;
                break;
            }
        }
        Assert.assertTrue("Not all search results contain the word: "
                + wordToCheck, allResultsContainSearchWord);
    }


    @After
    public void closeBrowser() {
        driver.close();
    }
}

