package org.prog;

import io.appium.java_client.AppiumDriver;
import org.prog.appium.driver.DriverFactory;
import org.prog.appium.driver.DriverType;
import org.prog.pages.FirstPage;
import org.prog.pages.SecondPage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MySecondTest {
    private AppiumDriver driver;
    private FirstPage firstPage;
    private SecondPage secondPage;

    @BeforeSuite
    public void setupDriver() throws MalformedURLException {
        driver = DriverFactory.getInstance().getDriver(DriverType.APPIUM_LOCAL);
        firstPage = new FirstPage(driver);
        secondPage = new SecondPage(driver);
    }

    @Test
    public void clickNextAndBackButtons() {
        firstPage.clickNextButton();
        secondPage.clickBackButton();
        Assert.assertEquals(firstPage.getTextContent(), "First text fragment");
    }

    @Test
    public void popupTest() {
        firstPage.clickEmail();
        firstPage.waitForPopup("Replace with your own action");
    }

    public void smth(){
        System.out.println("test!");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
