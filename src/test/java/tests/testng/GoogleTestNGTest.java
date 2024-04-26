package tests.testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.google.GoogleMainPage;
import pages.w3schools.W3SchoolsJavaPage;

public class GoogleTestNGTest {

    private GoogleMainPage googleMainPage = new GoogleMainPage();
    private W3SchoolsJavaPage w3SchoolsJavaPage = new W3SchoolsJavaPage();

    @Test
    public void searchForTitleFromW3InGoogle() {
        w3SchoolsJavaPage.openW3schools();
        w3SchoolsJavaPage.selectAndCopyTitleBy2Click();
        googleMainPage.openGoogle();
        googleMainPage.pasteInSearchFieldAndFind();
        Assert.assertTrue(googleMainPage.allResultsContainsSearchWord("tutorial"), "Not all search results contain search value 'tutorial");
    }
}

