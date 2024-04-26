package tests.junit;

import org.junit.Assert;
import org.junit.Test;
import pages.demoQATest.DemoQASelectMenuPage;

public class DemoQASelectMenuPageJUnitTest {

    private DemoQASelectMenuPage demoQASelectMenuPage = new DemoQASelectMenuPage();

    @Test
    public void standardMultiSelectAudi() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.checkThatAudiIsSelected();
        Assert.assertTrue("Audi is not selected", demoQASelectMenuPage.checkThatAudiIsSelected());
    }

    @Test
    public void oldStyleSelectMenuBlack() {
        demoQASelectMenuPage.openSelectMenuPage();
        demoQASelectMenuPage.selectBlackColor();
        Assert.assertTrue("Selected color is not black", demoQASelectMenuPage.checkThatBlackColorIsSelected());

    }


}
