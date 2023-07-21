package org.prog.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.prog.dto.NameDto;
import org.prog.util.DataHolderV2;

public class BetterHolderSteps {

    @Given("Store Name object with alias {string}")
    public void storeName(String alias) {
        NameDto dto = new NameDto();
        dto.setFirst("John");
        dto.setLast("Doe");
        dto.setTitle("Mr");
        DataHolderV2.getInstance().add(alias, dto);
    }

    @Given("Store String object with alias {string}")
    public void storeString(String alias) {
        String testStr = "test string";
        DataHolderV2.getInstance().add(alias, testStr);
    }

    @Then("Print name object {string}")
    public void printName(String alias) {
        System.out.println(DataHolderV2.getInstance().get(alias, NameDto.class));
    }

    @Then("Print string object {string}")
    public void printString(String alias) {
        System.out.println(DataHolderV2.getInstance().get(alias, String.class));
    }
}
