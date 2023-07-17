package org.prog.cucumber;

import io.appium.java_client.AppiumDriver;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.prog.driver.DriverFacade;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

@CucumberOptions(features = "src/test/resources/features",
        glue = "org.prog",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        })
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeMethod
    public void resetApp() {
        AppiumDriver driver = DriverFacade.getInstance().getDriver();
        DriverFacade.getInstance().getDriver().resetApp();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("test after");
    }
}
