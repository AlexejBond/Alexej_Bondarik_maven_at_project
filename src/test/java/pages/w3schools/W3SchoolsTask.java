package pages.w3schools;

import driver.Driver;
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
    WebDriver driver = Driver.getWebDriver();


    public void openW3schoolsSite() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.xpath("//*[@id='accept-choices']")).click();
    }


    public void selectAndCopyTitleBy2Click() {
        Keys functionalBtn = Keys.LEFT_CONTROL;
        Actions make = new Actions(driver);
        WebElement title = driver.findElement(By.xpath("//*[@id='main']/h1/span"));
        make.doubleClick(title)
                .keyDown(functionalBtn)
                .sendKeys("c").clickAndHold()
                .keyUp(functionalBtn)
                .build()
                .perform();

        driver.get("https://google.com");
        driver.findElement(By.xpath("//*[@id='W0wltc']/div")).click();
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(functionalBtn, "v");
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(
                By.xpath("//div[contains(@data-async-context, 'query:')]/div[.//img[@data-csiid] and .//h3]"));
        String wordToCheck = "tutorial";


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


    public void closeBrowser() {
        driver.close();
    }
}

