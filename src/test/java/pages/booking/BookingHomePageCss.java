package pages.booking;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class BookingHomePageCss {

    public static final String ACCEPT_COOKIE_CSS = "#onetrust-accept-btn-handler";

    public static final String CLOSE_SIGN_IN_POPUP_CSS = "button[aria-label='Dismiss sign-in info.'] > span > span";
    public static final String DESTINATION_FIELD_CSS = "input[name='ss']";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE_CSS = "#autocomplete-result-0 > div > div > div > div.a3332d346a.d2f04c9037";
    public static final String ADULTS_CHILDREN_ROOMS_CSS = "//ul[@role='group']/li[1]";
    public static final String ADD_ADULTS_CSS = "div[data-testid='occupancy-popup'] > div > div:first-child > div > button~button > span";
    public static final String ADD_CHILDREN_CSS = "//input[@id='group_children']/parent::div//button[2]";
    public static final String ADD_ROOMS_CSS = "div[data-testid='occupancy-popup'] > div > div:nth-of-type(3) > div > button~button > span";
    public static final String CONFIRM_OCCUPANCY_CSS = "div[data-testid='occupancy-popup'] > button";
    public static final String CLICK_SEARCH_BUTTON_CSS = "button[type='submit']";


    WebDriver driver = Driver.getWebDriver();

    public void openBookingHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");

    }

    public void acceptCookies() {
        Driver.waitForElementAppearXPath(driver, ACCEPT_COOKIE_CSS);
        ;
        driver.findElement(By.xpath(ACCEPT_COOKIE_CSS)).click();
    }

    public void closeSignInPopup() {
        Driver.waitForElementAppearXPath(driver, CLOSE_SIGN_IN_POPUP_CSS);

        try {
            driver.findElement(By.xpath(CLOSE_SIGN_IN_POPUP_CSS)).click();
        } catch (
                NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }


    public void inputCityViaAutocomplete(String cityName) {
        driver.findElement(By.xpath(DESTINATION_FIELD_CSS)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(FIRST_AUTOCOMPLETE_SEARCH_VALUE_CSS)).click();
    }

    public void selectCityViaEnter(String cityName) {

        driver.findElement(By.xpath(DESTINATION_FIELD_CSS)).sendKeys(cityName);
        driver.findElement(By.xpath(DESTINATION_FIELD_CSS)).sendKeys(Keys.ENTER);
    }

    public void selectDaysForStay(int addDaysCheckIn, int addDaysCheckOut) {
        int checkInDay = LocalDate.now().plusDays(addDaysCheckIn).getDayOfMonth();
        int checkOutDay = LocalDate.now().plusDays(addDaysCheckOut).getDayOfMonth();
        String pathToDay = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
        driver.findElement(By.xpath(String.format(pathToDay, checkInDay))).click();
        driver.findElement(By.xpath(String.format(pathToDay, checkOutDay))).click();
    }

    public void selectAdultsChildrenRooms(int addAdultsNumber,
                                          int addChildrenNumber,
                                          int addRoomsNumber) {
        driver.findElement(By.xpath(ADULTS_CHILDREN_ROOMS_CSS)).click();
        for (int adults = 0; adults < addAdultsNumber; adults++) {
            driver.findElement(By.xpath(ADD_ADULTS_CSS)).click();
        }

        for (int children = 0; children < addChildrenNumber; children++) {
            driver.findElement(By.xpath(ADD_CHILDREN_CSS)).click();
        }

        for (int rooms = 0; rooms < addRoomsNumber; rooms++) {
            driver.findElement(By.xpath(ADD_ROOMS_CSS)).click();
        }

        driver.findElement(By.xpath(CONFIRM_OCCUPANCY_CSS)).click();
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath(CLICK_SEARCH_BUTTON_CSS)).click();
    }


}
