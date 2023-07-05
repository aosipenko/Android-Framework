package org.prog;

import org.testng.annotations.*;

public class MySecondTest {

    @BeforeTest
    public void beforeTest() {
        System.out.println("This is ran before each test module");
    }

    @BeforeMethod
    public void beforeEachTest() {
        System.out.println("================TEST START====================");
    }

    @Test
    public void myTest() {
        System.out.println("hello test!");
    }

    @Test
    public void myTest1() {
        System.out.println("hello test!");
    }

    @Test
    public void myTest2() {
        System.out.println("hello test!");
    }

    @Test
    public void myTest3() {
        System.out.println("hello test!");
    }

    @Test
    public void myTest4() {
        System.out.println("hello test!");
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println("================TEST END====================");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("This is ran after each test module");
    }
}
