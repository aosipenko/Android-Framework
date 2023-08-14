package org.prog.cucumber;

import io.cucumber.spring.CucumberContextConfiguration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;


@EnableTransactionManagement
@EnableJpaRepositories("org.prog")
@CucumberContextConfiguration
@TestPropertySource("classpath:application.properties")
@ContextConfiguration(locations = "classpath*:spring/spring-context.xml")
@ComponentScan(basePackages = {"org.prog"})
@CucumberOptions(features = "src/test/resources/features",
        glue = "org.prog",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html",
                "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
        })
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite
    public void beforeSuite() {

    }

    @BeforeMethod
    public void resetApp() {
//        dataHolder.reset();
//        DriverFacade.getInstance().getDriver().resetApp();
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("test after");
    }
}
