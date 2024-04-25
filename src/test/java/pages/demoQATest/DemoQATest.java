package pages.demoQATest;


import driver.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertTrue;

public class DemoQATest {

    private final static String SELECT_VALUE = "//*[@id='withOptGroup']/div/div[1]";
    private final static String SELECT_ONE = "//*[@id='selectOne']/div/div[1]";
    private final static String OLD_STYLE_SELECT_MENU = "//*[@id='oldSelectMenu']";

    private final static String MULTISELECT_DROP_DOWN = "//*[@id=\"selectMenuContainer\"]/div[7]/div/div/div/div[1]";

    private final static String STANDARD_MULTI_SELECT = "//select[@name='cars']";

    WebDriver driver = Driver.getWebDriver();


    @Test
    public void colorSelectorTestSelectAnyColor() {
        driver.get("https://demoqa.com/select-menu ");
        WebElement element = driver.findElement(By.xpath(OLD_STYLE_SELECT_MENU));

        Select select = new Select(element);
        select.selectByValue("3");
        assertTrue("Magenta is not selected", driver.findElement(By.xpath("//option[text()='Magenta']")).isSelected());
    }

    @Test
    public void carSelectorTestSelectAnyColor() {
        driver.get("https://demoqa.com/select-menu ");
        WebElement element = driver.findElement(By.xpath(STANDARD_MULTI_SELECT));

        Select select = new Select(element);
        select.selectByValue("Saab");
        assertTrue("Magenta is not selected", driver.findElement(By.xpath("//option[text()='Saab']")).isSelected());
    }

//    @After
//    public void afterBookingComTest() {
//        driver.quit();
//
//    }
}
