package org.prog.test;

import io.qameta.allure.Link;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
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
    @Link("QA-56789")
    public void myTestThree() {
        printString("Three success!");
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    @Link("QA-12345")
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
