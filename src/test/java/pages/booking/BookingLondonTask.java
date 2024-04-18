package pages.booking;

import driver.WebDrivers;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BookingLondonTask {
    String searchField = "//input[@name='ss']";

    WebDriver driver = WebDrivers.getDriver();

    @Test
    public void checkLondonHotel() throws InterruptedException {
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//*[@id='onetrust-accept-btn-handler']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@aria-label='Скрыть меню входа в аккаунт.']")).click();
        driver.findElement(By.xpath(searchField)).sendKeys("London");

        driver.findElement(By.xpath(searchField)).sendKeys(Keys.ENTER);

        WebElement tenHotel = driver.findElement(By.xpath("//div[@data-testid='property-card'][10]"));
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tenHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", tenHotel);
        byte[] asBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

        try {
            Files.write(Paths.get("hotels.png"), asBytes);
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

}

