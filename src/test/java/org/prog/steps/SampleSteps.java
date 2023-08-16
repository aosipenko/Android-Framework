package org.prog.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.prog.beans.AnnotationTest;
import org.prog.pages.elements.AndroidTable;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class SampleSteps {

    @Autowired
    private AnnotationTest myBean;

    private ThreadLocal<String> someString = new ThreadLocal<>();

    private final static Random random = new Random();
    private static final Logger LOG = LogManager.getLogger(SqlSteps.class);

    @Given("Print list content")
    public void printList(DataTable table) {
        someString.set("");
        someString.get();
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

    @Given("Wait for random time and print {string}")
    public void waitForRandomTimeAndPrint(String s) throws InterruptedException {
        Thread.sleep(random.nextInt(8) * 1000);
        if (s.equals("myString")) {
            myBean.smth(s);
            myBean.anotherMethod(s);
        } else {
            myBean.smth(null);
            myBean.anotherMethod(null);
        }
        LOG.info("Test is done");
    }
}
