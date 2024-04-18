package driver.day16;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverTestTask1 {
    private static void sleep(int s) throws InterruptedException {
        Thread.sleep(s);
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        sleep(3000);
        driver.navigate().to("https://ya.ru");
        sleep(3000);
        driver.navigate().back();
        sleep(3000);
        driver.navigate().refresh();
        driver.quit();

    }
}
