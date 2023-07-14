package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

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

    @AfterSuite
    public void afterSuite() {
        System.out.println("test after");
    }
}
