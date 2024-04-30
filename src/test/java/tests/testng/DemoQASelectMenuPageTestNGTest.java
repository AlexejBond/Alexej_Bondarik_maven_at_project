package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoQATest.DemoQASelectMenuPage;

public class DemoQASelectMenuPageTestNGTest {

    private DemoQASelectMenuPage demoQASelectMenuPage = new DemoQASelectMenuPage();

    @Test
    public void standardMultiSelectAudi() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.selectCar("2");
        Assert.assertTrue(demoQASelectMenuPage.checkThatCarIsSelected("Audi"), "Audi is not selected");
    }

    @Test
    public void oldStyleSelectMenuBlack() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.selectColor("5");
        Assert.assertTrue(demoQASelectMenuPage.checkThatColorIsSelected("Black"), "Selected color is not Black");

    }


}
