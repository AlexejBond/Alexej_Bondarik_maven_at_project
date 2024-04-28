package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.demoQATest.DemoQASelectMenuPage;

public class DemoQASelectMenuPageJUnitTest {

    private DemoQASelectMenuPage demoQASelectMenuPage = new DemoQASelectMenuPage();

    @Test
    public void standardMultiSelectAudi() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.selectCar("2");
        Assert.assertTrue("Audi is not selected", demoQASelectMenuPage.checkThatCarIsSelected("Audi"));
    }

    @Test
    public void oldStyleSelectMenuBlack() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.selectColor("5");
        Assert.assertTrue("Selected color is not black", demoQASelectMenuPage.checkThatColorIsSelected("Black"));

    }


}
