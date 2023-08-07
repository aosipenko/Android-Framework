package org.prog.test;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

public class TestSuiteTwo {

    @Test
    @Severity(SeverityLevel.BLOCKER)
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
    public void myTestThree() {
        printString("Three success!");
    }

    @Test
    @Severity(SeverityLevel.NORMAL)
    public void myTestFour() {
        printString(null);
    }

    @Test
    @Severity(SeverityLevel.TRIVIAL)
    public void myTestFive() {
        printString(null);
    }

    @Step("Print string {s}")
    public void printString(String s) {
        if (s != null) {
            System.out.println(s);
        } else {
            throw new RuntimeException();
        }
    }
}
