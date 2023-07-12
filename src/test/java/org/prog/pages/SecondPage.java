package org.prog.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SecondPage extends AbstractPage {

    public SecondPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickBackButton() {
        WebElement btnBack = driver.findElement(By.id("bnt_previous"));
        Assert.assertTrue(btnBack.isDisplayed(), "Button from page 2 is missing!");
        Assert.assertTrue(btnBack.isEnabled(), "Button from page 2 is not interactive!");
        btnBack.click();
    }

    public String getTextContent() {
        return driver.findElement(By.id("textview_second")).getText();
    }
}
