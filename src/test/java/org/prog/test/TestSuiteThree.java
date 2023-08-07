package org.prog.test;

import io.cucumber.java.ht.Epi;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteThree {
    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void myTestOne() {
        printString("One success!");
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    public void myTestTwo() {
        printString("Two success!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Link(name = "QA-56789", url = "https://google.com/")
    @Epic("E-456312")
    public void myTestThree() {
        printString("Three success!");
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Link(name = "QA-12345", url = "https://google.com/")
    public void myTestFour() {
        printString(null);
    }

    @Step("Print string {s}")
    public void printString(String s) {
        if (s != null) {
            System.out.println(s);
        } else {
            Assert.fail("String may not be emtpy");
        }
    }
}
