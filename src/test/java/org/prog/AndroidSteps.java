package org.prog;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AndroidSteps {

    @Given("First Page is loaded")
    public void firstPageIsLoaded() {
        System.out.println("I want to load my app");
    }

    @When("I click on {string} button")
    public void iClickOnButton(String buttonName) {
        System.out.println("I want to click " + buttonName);
    }

    @Then("I see second text with value {string}")
    public void iSeeSecondTextWithValue(String textValue) {
        System.out.println("I expect to see text " + textValue);
    }

    @Then("I see first text with value {string}")
    public void iSeeFirstTextWithValue(String textValue) {
        System.out.println("I expect to see text " + textValue);
    }

    @Then("I see popup with text {string}")
    public void iSeePopupWithText(String popupValue) {
        System.out.println("I expect to see popup text " + popupValue);
    }
}
