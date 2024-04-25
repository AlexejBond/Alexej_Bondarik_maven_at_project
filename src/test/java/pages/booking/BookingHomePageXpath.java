package pages.booking;

import driver.Driver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.NoSuchElementException;

public class BookingHomePageXpath {

    public static final String CLOSE_SIGN_IN_POPUP_XPATH = "//button[@aria-label='Dismiss sign-in info.']/span";
    public static final String DESTINATION_FIELD_XPATH = "//input[@name='ss']";
    public static final String FIRST_AUTOCOMPLETE_SEARCH_VALUE_XPATH = "//ul[@role='group']/li[1]";
    public static final String ADULTS_CHILDREN_ROOMS_XPATH = "//ul[@role='group']/li[1]";
    public static final String ADD_ADULTS_XPATH = "//input[@id='group_adults']/parent::div//button[2]";
    public static final String ADD_CHILDREN_XPATH = "//input[@id='group_children']/parent::div//button[2]";
    public static final String ADD_ROOMS_XPATH = "//input[@id='no_rooms']/parent::div//button[2]";
    public static final String CONFIRM_OCCUPANCY_XPATH = "//button/span[text()='Done']";
    public static final String CLICK_SEARCH_BUTTON_XPATH = "//button/span[text()='Search']";


    WebDriver driver = Driver.getWebDriver();

    public void openBookingHomePage() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");
        try {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath(CLOSE_SIGN_IN_POPUP_XPATH)))
                    .click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        } catch (NoSuchElementException e) {
            System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }

    public void inputCityViaAutocomplete(String cityName) {
        driver.findElement(By.xpath(DESTINATION_FIELD_XPATH)).sendKeys(cityName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(FIRST_AUTOCOMPLETE_SEARCH_VALUE_XPATH)).click();
    }

    public void selectCityViaEnter(String cityName) {

        driver.findElement(By.xpath(DESTINATION_FIELD_XPATH)).sendKeys(cityName);
        driver.findElement(By.xpath(DESTINATION_FIELD_XPATH)).sendKeys(Keys.ENTER);
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
        driver.findElement(By.xpath(ADULTS_CHILDREN_ROOMS_XPATH)).click();
        for (int adults = 0; adults < addAdultsNumber; adults++) {
            driver.findElement(By.xpath(ADD_ADULTS_XPATH)).click();
        }

        for (int children = 0; children < addChildrenNumber; children++) {
            driver.findElement(By.xpath(ADD_CHILDREN_XPATH)).click();
        }

        for (int rooms = 0; rooms < addRoomsNumber; rooms++) {
            driver.findElement(By.xpath(ADD_ROOMS_XPATH)).click();
        }

        driver.findElement(By.xpath(CONFIRM_OCCUPANCY_XPATH)).click();
    }

    public void clickSearchButton() {
        driver.findElement(By.xpath(CLICK_SEARCH_BUTTON_XPATH)).click();
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
