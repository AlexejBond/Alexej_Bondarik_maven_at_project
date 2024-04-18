package driver.day15;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestChromeWebDriver {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();


    }


}
