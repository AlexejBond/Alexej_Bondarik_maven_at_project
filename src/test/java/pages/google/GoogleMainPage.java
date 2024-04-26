package pages.google;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class GoogleMainPage {
    public static final String SEARCH_FIELD_XPATH = "//*[@name='q']";
    public static final String SEARCH_RESULTS_XPATH = "//div[contains(@data-async-context, 'query:')]/div[.//img[@data-csiid] and .//h3]";


    WebDriver driver = Driver.getWebDriver();

    public void openGoogle() {
        driver.get("https://google.com");
    }


    public void pasteInSearchFieldAndFind() {
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(Keys.LEFT_CONTROL, "v");
        driver.findElement(By.xpath(SEARCH_FIELD_XPATH)).sendKeys(Keys.ENTER);
    }

    public boolean allResultsContainsSearchWord(String searchWord) {
        List<WebElement> searchResults = driver.findElements(By.xpath(SEARCH_RESULTS_XPATH));
        String searchWordToCheck = searchWord;

        boolean allResultsContainSearchWord = true;
        for (WebElement result : searchResults) {
            String resultText = result.getText();
            if (!resultText.contains(searchWordToCheck)) {
                allResultsContainSearchWord = false;
                break;
            }
        }
        return allResultsContainSearchWord;
    }


    public void getWeatherForTomorrowAtTwelveTime() {
        driver.findElement(By.xpath("//*[@id='W0wltc']/div")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='APjFqb']")).sendKeys("погода минск weather.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='jZ2SBf']/div[1]/span")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        System.out.println("Temperature for tomorrow at 12:00 will be about "
                + driver.findElement(By.xpath("//*[@id='wob_tm']")).getText() + "°C");
    }
}



