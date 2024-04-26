package pages.w3schools;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class W3SchoolsJavaPage {
    public static final String TITLE_TUTORIAL_XPATH = "//span[text()='Tutorial']";
//    "//*[@id='accept-choices']"


    WebDriver driver = Driver.getWebDriver();


    public void openW3schools() {
        driver.get("https://www.w3schools.com/java/");
    }

    public void selectAndCopyTitleBy2Click() {
        Keys functionalBtn = Keys.LEFT_CONTROL;
        Actions make = new Actions(driver);
        WebElement title = driver.findElement(By.xpath("//*[@id='main']/h1/span"));
        make.doubleClick(title)
                .keyDown(functionalBtn)
                .sendKeys("c").clickAndHold()
                .keyUp(functionalBtn)
                .build()
                .perform();
    }

}
//Assert.assertTrue("Not all search results contain the word: " + searchWordToCheck, allResultsContainSearchWord);