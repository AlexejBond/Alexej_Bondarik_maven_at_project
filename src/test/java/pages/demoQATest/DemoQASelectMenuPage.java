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

public class DemoQASelectMenuPage {

    WebDriver driver = Driver.getWebDriver();
    public static final String OLD_STYLE_SELECT_MENU_XPATH = "//select[@id='oldSelectMenu']";
    public static final String BLACK_COLOR_XPATH = "//option[text()='Black']";
    public static final String CARS_MENU_XPATH = "//select[@id='cars']";
    public static final String AUDI_XPATH = "//option[text()='Audi']";

    public void openSelectMenuPage() {
        driver.get("https://demoqa.com/select-menu");
    }

    public void selectBlackColor() {
        WebElement oldStyleSelectMenu = driver.findElement(By.xpath(OLD_STYLE_SELECT_MENU_XPATH));
        Select s1 = new Select(oldStyleSelectMenu);
        s1.selectByValue("5");
    }

    public boolean checkThatBlackColorIsSelected() {
        return driver.findElement(By.xpath(BLACK_COLOR_XPATH)).isSelected();
    }

    public void StandardMultiSelectAudi() {
        WebElement selectMenu2 = driver.findElement(By.xpath(CARS_MENU_XPATH));
        Select s2 = new Select(selectMenu2);
        s2.selectByValue("Audi");
    }

    public boolean checkThatAudiIsSelected() {
        return driver.findElement(By.xpath(AUDI_XPATH)).isSelected();
    }
}
