package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static driver.Driver.getWebDriver;

public class BookingSearchPageXPath {
    public static final String REVIEW_SCORE_6_PLUS_XPATH = "//input[@value='review_score=60' and contains(@id,'r1')]";
    public static final String SORT_BY_BUTTON_XPATH = "//button[@data-testid='sorters-dropdown-trigger']";

    public static final String SORT_BY_LOW_TO_HIGH_XPATH = "//span[text()='Property rating (low to high)']";
    public static final String RATING_FIRST_ON_LIST = "//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div";




    WebDriver driver = getWebDriver();

    public void selectReviewScore6Plus() {
        WebElement reviewScore6Plus = driver.findElement
                (By.xpath(REVIEW_SCORE_6_PLUS_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewScore6Plus);
        driver.findElement(By.xpath("(//div[@data-filters-item='review_score:review_score=60'])[1]")).click();
    }

    public void sortingLowToHigh() {
        WebElement sortByButton = driver.findElement(By.xpath(SORT_BY_BUTTON_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sortByButton);
        sortByButton.click();
        driver.findElement(By.xpath(SORT_BY_LOW_TO_HIGH_XPATH)).click();
//        sleepUntil("//div[@data-testid='skeleton-loader-card'][1]");
    }

    public String getRatingFirstOnList() {
        return driver.findElement(By.xpath(RATING_FIRST_ON_LIST)).getText();
    }
}
