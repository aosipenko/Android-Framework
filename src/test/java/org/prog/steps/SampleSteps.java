package org.prog.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.prog.pages.elements.AndroidTable;

public class SampleSteps {

    @Given("Print list content")
    public void printList(DataTable table) {
        table.asList().forEach(entry -> System.out.println(">>>>>" + entry));
    }

    @Given("Test Cucumber map")
    public void printMapKeyValue(DataTable table) {
        table.asMap().entrySet().forEach(
                entry -> System.out.println(entry.getKey() + " : " + entry.getValue())
        );
    }

    @Given("Get cell {} value in row {int}")
    public void getCellPath(AndroidTable androidTable, int rowIndex) {
        System.out.println(androidTable.getPath(rowIndex));
    }
}
