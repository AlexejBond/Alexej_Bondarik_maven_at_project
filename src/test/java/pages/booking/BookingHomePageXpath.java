package pages.booking;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class BookingHomePageXpath {
    private static final Logger LOGGER = LogManager.getLogger(BookingHomePageXpath.class);

    public static final String ACCEPT_COOKIE_XPATH = "//*[@id='onetrust-accept-btn-handler']";

    public static final String CLOSE_SIGN_IN_POPUP_XPATH = "//button[@aria-label='Скрыть меню входа в аккаунт.']";
    public static final String DESTINATION_FIELD_XPATH = "//input[@name='ss']";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE_XPATH = "//ul[@role='group']/li[1]";
    public static final String ADULTS_CHILDREN_ROOMS_XPATH = "//button[@data-testid='occupancy-config']";
    public static final String ADD_ADULTS_XPATH = "//input[@id='group_adults']/parent::div//button[2]";
    public static final String ADD_CHILDREN_XPATH = "//input[@id='group_children']/parent::div//button[2]";
    public static final String ADD_ROOMS_XPATH = "//input[@id='no_rooms']/parent::div//button[2]";
    public static final String CONFIRM_OCCUPANCY_XPATH = "//button/span[text()='Done']";
    public static final String CLICK_SEARCH_BUTTON_XPATH = "//button/span[text()='Search']";
    public static final String SIGN_IN_BUTTON_XPATH = "//span[text()='Sign in']";
    public static final String CALENDAR_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']";
    public static final String CALENDAR_DATE_XPATH = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";


    WebDriver driver = Driver.getWebDriver();

    public void openBookingHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");
        LOGGER.info("Booking home page is opened");
    }

    public void SignIn() {
        driver.findElement(By.xpath(SIGN_IN_BUTTON_XPATH)).click();
        LOGGER.info("Sign in button was clicked");
    }

    public void acceptCookies() {
        Driver.waitForElementAppearXPath(driver, ACCEPT_COOKIE_XPATH);
        driver.findElement(By.xpath(ACCEPT_COOKIE_XPATH)).click();
        LOGGER.info("Site cookies are accepted");
    }

    public void closeSignInPopup() {
        Driver.waitForElementAppearXPath(driver, CLOSE_SIGN_IN_POPUP_XPATH);
        try {
            driver.findElement(By.xpath(CLOSE_SIGN_IN_POPUP_XPATH)).click();
            LOGGER.info("SignIn popup is closed");
        } catch (
                NoSuchElementException e) {
            LOGGER.error(Arrays.toString(e.getStackTrace()));
        }
    }


    public void inputCityViaAutocomplete(String cityName) {
        driver.findElement(By.xpath(DESTINATION_FIELD_XPATH)).sendKeys(cityName);
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(DESTINATION_FIELD_XPATH)))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LOGGER.info("City {} was selected via autocomplete", cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(FIRST_AUTOCOMPLETE_SEARCH_VALUE_XPATH)).click();
    }

    public void inputAndSelectCityViaEnter(String cityName) {
        driver.findElement(By.xpath(DESTINATION_FIELD_XPATH)).sendKeys(cityName);
        LOGGER.info("City {} was entered into the destination field", cityName);
        driver.findElement(By.xpath(DESTINATION_FIELD_XPATH)).sendKeys(Keys.ENTER);
        LOGGER.info("After entering the city {} in destination field, the Enter button is pressed", cityName);
    }

    public void selectDaysForStay(int checkInDay, int checkOutDay) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CALENDAR_XPATH)));
        driver.findElement(By.xpath(String.format(CALENDAR_DATE_XPATH, checkInDay))).click();
        LOGGER.info("CheckIn date {} was selected", checkInDay);
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format(CALENDAR_DATE_XPATH, checkOutDay))))
                .click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        LOGGER.info("CheckOut date {} was selected", checkOutDay);
    }

    public void selectAdultsChildrenRooms(int addAdultsNumber,
                                          int addChildrenNumber,
                                          int addRoomsNumber) {
        driver.findElement(By.xpath(ADULTS_CHILDREN_ROOMS_XPATH)).click();
        for (int adults = 0; adults < addAdultsNumber; adults++) {
            driver.findElement(By.xpath(ADD_ADULTS_XPATH)).click();
        }
        LOGGER.info("{} adults were added", addAdultsNumber);

        for (int children = 0; children < addChildrenNumber; children++) {
            driver.findElement(By.xpath(ADD_CHILDREN_XPATH)).click();
        }
        LOGGER.info("{} children were added", addChildrenNumber);


        for (int rooms = 0; rooms < addRoomsNumber; rooms++) {
            driver.findElement(By.xpath(ADD_ROOMS_XPATH)).click();
        }
        LOGGER.info("{} rooms were added", addRoomsNumber);


        driver.findElement(By.xpath(CONFIRM_OCCUPANCY_XPATH)).click();
        LOGGER.info("Adults, Children, Rooms was introduced");
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath(CLICK_SEARCH_BUTTON_XPATH)).click();
        LOGGER.info("The search button was pressed");
    }


    //TODO
    public String checkCurrencyPicker() {
        WebElement currencyBtn = driver.findElement
                (By.xpath("//button[@data-testid='header-currency-picker-trigger']/span"));
        Actions checkAltTextCurrency = new Actions(driver);
        checkAltTextCurrency.moveToElement(currencyBtn);
        checkAltTextCurrency.perform();
        return currencyBtn.findElement
                (By.xpath("//div[text()='Select your currency']")).getText();
    }

    //TODO
    public String checkLanguagePicker() {
        WebElement languageBtn = driver.findElement
                (By.xpath("//button[@data-testid='header-language-picker-trigger']/span"));
        Actions checkAltTextLanguage = new Actions(driver);
        checkAltTextLanguage.moveToElement(languageBtn);
        checkAltTextLanguage.perform();
        return languageBtn.findElement(By.xpath("//div[text()='Select your language']")).getText();
    }

}
