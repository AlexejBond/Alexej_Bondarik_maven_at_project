package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.demoQATest.DemoQASelectMenuPage;

public class DemoQASelectMenuPageTestNGTest {

    private DemoQASelectMenuPage demoQASelectMenuPage = new DemoQASelectMenuPage();

    @Test
    public void standardMultiSelectAudi() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.checkThatAudiIsSelected();
        Assert.assertTrue(demoQASelectMenuPage.checkThatAudiIsSelected(), "Audi is not selected");
    }

    @Test
    public void oldStyleSelectMenuBlack() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.selectBlackColor();
        Assert.assertTrue(demoQASelectMenuPage.checkThatBlackColorIsSelected(), "Selected color is not black");

    }


}
