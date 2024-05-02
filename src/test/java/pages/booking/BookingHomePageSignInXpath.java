package pages.booking;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class BookingHomePageSignInXpath {
    private static final Logger LOGGER = LogManager.getLogger(BookingHomePageSignInXpath.class);
    WebDriver driver = Driver.getWebDriver();
    public static final String EMAIL_INPUT_XPATH = "//input[@type='email']";
    public static final String PASSWORD_INPUT_XPATH = "//input[@type='password']";
    public static final String SUBMIT_BUTTON_XPATH = "//button[@type='submit']";
    public static final String PRESS_AND_HOLD_XPATH = "//span[text()='Press and hold this button to pass the security check']/parent::div/p";
    public static final String CLOSE_GENIUS_POPUP_XPATH = "//div[@role='dialog']//button[@aria-label='Dismiss']";

    public void enterEmailToLogin(String email) {
        driver.findElement(By.xpath(EMAIL_INPUT_XPATH)).sendKeys(email);
        driver.findElement(By.xpath(EMAIL_INPUT_XPATH)).sendKeys(Keys.ENTER);
        LOGGER.info("Email entered successfully");
    }

    public void enterPasswordToLogin(String password) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        new WebDriverWait(driver, Duration.ofSeconds(40))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(By.xpath(PASSWORD_INPUT_XPATH)))
                .sendKeys(password);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(By.xpath(PASSWORD_INPUT_XPATH)).sendKeys(Keys.ENTER);
        LOGGER.info("Password entered successfully");
    }

    public void submitLoginButton() {
        driver.findElement(By.xpath(SUBMIT_BUTTON_XPATH)).click();
        LOGGER.info("Login was submitted");
    }

    public void switchToHumanConfirmationFrame() {
        driver.switchTo().frame(0);
        LOGGER.info("Frame was switched");
    }

    public void clickAndHoldHumanConfirmButton() {
        WebElement clickAndHoldButton = driver.findElement(By.xpath(PRESS_AND_HOLD_XPATH));
        Actions actions = new Actions(driver);
        actions.clickAndHold(clickAndHoldButton);
        LOGGER.info("Click and Hold button for human verification was pressed and hold");
    }

    public void closeGeniusPopup() {
        driver.findElement(By.xpath(CLOSE_GENIUS_POPUP_XPATH)).click();
    }







}
