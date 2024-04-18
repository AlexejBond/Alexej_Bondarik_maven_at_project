package pages.booking;


import driver.WebDrivers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BookingParisTask {
    WebDriver driver = WebDrivers.getDriver();

    public void clickByXpath(String Xpath) {
//        WebElement element = driver.findElement(By.xpath(Xpath));
//            element.click();
        try {
            System.out.println("Exception e");

            WebElement element = driver.findElement(By.xpath(Xpath));
            element.click();
        } catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
            clickByXpath("//button[@aria-label='Скрыть меню входа в аккаунт.']");
            WebElement element = driver.findElement(By.xpath(Xpath));
            element.click();


        }
    }

        public void openBooking() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");
//        clickByXpath("//button[@aria-label='Dismiss sign-in info.']/span");

    }

    public void inputCity() {
        clickByXpath("//*[@id='onetrust-accept-btn-handler']");
        driver.findElement(By.xpath("//input[@name='ss']"))
                .sendKeys("Париж, Иль-де-Франс, Франция");
        clickByXpath("//ul[@role='group']/li[1]");
    }

    public void inputPersons() {
        clickByXpath("//button[@data-testid='occupancy-config']");

        for (int numberOfAdults = 1; numberOfAdults <= 2; numberOfAdults++) {
            clickByXpath("//label[@for='group_adults']/../following-sibling::div//button[2]");
        }

        clickByXpath("//label[@for='no_rooms']/../following-sibling::div//button[2]");
        clickByXpath("//div[@data-testid='occupancy-popup']/button");

    }

    public void inputDate() {
        driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
        LocalDate dateStartRent = LocalDate.parse(LocalDate.now().plusDays(3)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        LocalDate dateFinishRent = LocalDate.parse(dateStartRent.plusDays(7)
                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", dateStartRent))).click();
        driver.findElement(By.xpath(String.format("//span[@data-date='%s']", dateFinishRent))).click();
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void checkboxRatingEnable() {
        WebElement checkBoxRating = driver.findElement(By.xpath("//input[@value='review_score=60' and contains(@id,'r1')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkBoxRating);
        checkBoxRating.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        new WebDriverWait(driver, Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='skeleton-loader-card'][1]"))
                );

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void sortingEnable() {
        WebElement sortButton = driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", sortButton);
        sortButton.click();
        driver.findElement(By.xpath("//span[text()='Property rating (low to high)']")).click();
    }

    public String getRating() {
        return driver.findElement(By.xpath("//div[@data-testid='property-card'][1]//div[@data-testid='review-score']/div[1]/div"))
                .getText();
    }

}




