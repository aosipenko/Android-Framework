package org.prog.steps;

import io.appium.java_client.AppiumDriver;
import org.prog.appium.driver.DriverFactory;
import org.prog.appium.driver.DriverType;
import org.prog.pages.FirstPage;
import org.prog.pages.SecondPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MySecondTest {

    @Autowired
    private FirstPage firstPage;

    @Autowired
    private SecondPage secondPage;

//    @Test
    public void clickNextAndBackButtons() {
        firstPage.clickNextButton();
        secondPage.clickBackButton();
        Assert.assertEquals(firstPage.getTextContent(), "First text fragment");
    }

//    @Test
    public void popupTest() {
        firstPage.clickEmail();
        firstPage.waitForPopup("Replace with your own action");
    }
}
