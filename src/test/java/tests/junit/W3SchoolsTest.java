package tests.junit;

import org.junit.Test;
import pages.w3schools.W3SchoolsTask;

public class W3SchoolsTest {

    W3SchoolsTask w3SchoolsTask = new W3SchoolsTask();

    @Test
    public void w3SchoolsTest() {
        w3SchoolsTask.openW3schoolsSite();
        w3SchoolsTask.selectAndCopyTitleBy2Click();
        w3SchoolsTask.closeBrowser();

    }


}
