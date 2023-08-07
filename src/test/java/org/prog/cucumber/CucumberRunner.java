package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.prog.driver.DriverFacade;
import org.prog.util.DataHolder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(features = "src/test/resources/features",
        glue = "org.prog",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        })
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeMethod
    public void resetApp() {
        DataHolder.getInstance().reset();
//        DriverFacade.getInstance().getDriver().resetApp();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("test after");
    }
}
