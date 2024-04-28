package pages.demoQATest;


import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.apache.logging.log4j.core.async.AsyncLoggerContextSelector.isSelected;
import static org.junit.Assert.assertTrue;

public class DemoQASelectMenuPage {
    private static final Logger LOGGER = LogManager.getLogger(DemoQASelectMenuPage.class);
    WebDriver driver = Driver.getWebDriver();
    public static final String CARS_MENU_XPATH = "//select[@id='cars']";
    public static final String AUDI_XPATH = "//option[text()='Audi']";
    public static final String OLD_STYLE_SELECT_MENU_XPATH = "//select[@id='oldSelectMenu']";
    public static final String BLACK_COLOR_XPATH = "//option[text()='Black']";


    public void openSelectMenuPage() {
        driver.get("https://demoqa.com/select-menu");
        LOGGER.info("The demoQA_com/select-menu is opened");

    }

    public void selectColor(String colorNumber) {
        WebElement oldStyleSelectMenu = driver.findElement(By.xpath(OLD_STYLE_SELECT_MENU_XPATH));
        Select s1 = new Select(oldStyleSelectMenu);
        s1.selectByValue(colorNumber);
        LOGGER.info("Color number {} was selected from the Old_Style_Select_Menu drop-down", colorNumber);

    }

    public boolean checkThatColorIsSelected(String color) {
        return driver.findElement(By.xpath(String.format(BLACK_COLOR_XPATH, color))).isSelected();
    }

    public void selectCar(String car) {
        WebElement standardMultiSelect = driver.findElement(By.xpath(CARS_MENU_XPATH));
        Select s2 = new Select(standardMultiSelect);
        s2.selectByValue(car);
        LOGGER.info("{} car was selected from the Standard_Multi_Select drop-down", car);

    }

    public boolean checkThatCarIsSelected(String car) {
        return driver.findElement(By.xpath(String.format(AUDI_XPATH, car))).isSelected();
    }
}
