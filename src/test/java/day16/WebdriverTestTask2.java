package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class WebdriverTestTask2 {
    private static void sleep(int s) throws InterruptedException {
        Thread.sleep(s);
    }

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.google.com");
        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'W0wltc\']/div")).click();
        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'APjFqb\']")).sendKeys("погода минск weather.com");
        sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'jZ2SBf\']/div[1]/span")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        System.out.println("Temperature for tomorrow at 12:00 will be about " + driver.findElement(By.xpath("//*[@id='wob_tm']")).getText() + "°C");



    }
}
