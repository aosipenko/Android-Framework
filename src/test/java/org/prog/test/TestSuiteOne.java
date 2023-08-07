package org.prog.test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSuiteOne {

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void myTestOne() {
        printString("One success!");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void myTestTwo() {
        printString("Two success!");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void myTestThree() {
        printString("Three success!");
    }

    @Test
    @Severity(SeverityLevel.CRITICAL)
    public void myTestFour() {
        printString(null);
    }

    @Step("Print string {s}")
    private void printString(String s) {
        if (s != null) {
            System.out.println(s);
        } else {
            Assert.fail("String may not be emtpy");
        }
    }
}
