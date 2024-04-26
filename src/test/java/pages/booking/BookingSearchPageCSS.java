package pages.booking;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static driver.Driver.getWebDriver;

public class BookingSearchPageCSS {

    public static final String REVIEW_SCORE_6_PLUS_CSS = "//input[@value='review_score=60' and contains(@id,'r1')]";
    public static final String SORT_BY_BUTTON_CSS = ".d4924c9e74 > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div > div ~ div > div > div > a >span > div .ac4a7896c7";
    public static final String SORT_BY_LOW_TO_HIGH_CSS = "ul.ad7c39949a > li:nth-child(6) > button > div span";
    public static final String RATING_FIRST_ON_LIST_CSS = ".d4924c9e74 > div:nth-of-type(3) > div > div:nth-of-type(2) > div > div > div ~ div > div > div > a >span > div .ac4a7896c7";




    WebDriver driver = getWebDriver();

    public void selectReviewScore6Plus() {
        WebElement reviewScore6Plus = driver.findElement
                (By.xpath(REVIEW_SCORE_6_PLUS_CSS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", reviewScore6Plus);
        driver.findElement(By.xpath("(//div[@data-filters-item='review_score:review_score=60'])[1]")).click();
    }

    public void sortingLowToHigh() {
        WebElement sortByButton = driver.findElement(By.xpath(SORT_BY_BUTTON_CSS));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sortByButton);
        sortByButton.click();
        driver.findElement(By.xpath(SORT_BY_LOW_TO_HIGH_CSS)).click();
//        sleepUntil("//div[@data-testid='skeleton-loader-card'][1]");
    }

    public String getRatingFirstOnList() {
        return driver.findElement(By.xpath(RATING_FIRST_ON_LIST_CSS)).getText();
    }
}
}
