package tests.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.demoQATest.DemoQASelectMenuPage;

public class DemoQASelectMenuPageCucTest {
    private DemoQASelectMenuPage demoQASelectMenuPage = new DemoQASelectMenuPage();

    @Given("I open DemoQA_Select_Menu page")
    public void openDemoQASelectPage() {
        demoQASelectMenuPage.openSelectMenuPage();
    }

    @When("I select BLACK color {string} from Old_Style_Select_Menu")
    public void selectColor(String colorNumber){

    }



    @Then("I see that {string} color is selected")
    public void checkThatColorIsSelected(String color) {
        demoQASelectMenuPage.checkThatColorIsSelected(color);
    }

    @When("I select {string} car from select list")
    public void selectCarFromTheList(String car) {
        demoQASelectMenuPage.selectCar(car);
    }

    @Then("I see that {string} car is selected")
    public void checkThatCarIsSelected(String car) {
        demoQASelectMenuPage.checkThatCarIsSelected(car);
    }
}
