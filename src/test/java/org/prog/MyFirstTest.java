package org.prog;

import org.prog.manager.Car;
import org.prog.manager.CodeDemo;
import org.prog.manager.PoliceStation;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class MyFirstTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("This is executed before all tests");
    }

    @Test(dataProvider = "data")
    public void myTest(String ownerName, int ownedCars) {
        CodeDemo codeDemo = new CodeDemo();
        codeDemo.init();
        PoliceStation policeStation = codeDemo.getStation();

        List<Car> aliceCars = policeStation.getCarsOwnedByPerson(ownerName);
        Assert.assertEquals(aliceCars.size(), ownedCars, "Number of owned cars did not match for owner Alice");
    }

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Alice", 2},
                {"Bob", 1},
                {"Susan", 0}
        };
    }

    @AfterSuite
    public void afterAll() {
        System.out.println("This is executed after all tests");
    }
}
