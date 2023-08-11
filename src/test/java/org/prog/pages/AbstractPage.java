package org.prog.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.appium.driver.DriverFactory;
import org.prog.appium.driver.DriverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import javax.annotation.PreDestroy;
import java.time.Duration;

public abstract class AbstractPage {

    protected AppiumDriver driver;

    protected AbstractPage(DriverFactory driverFactory) {
//        this.driver = driverFactory.getDriver(DriverType.APPIUM_LOCAL);
    }

    public void clickEmail() {
        WebElement mailIcon = driver.findElement(By.id("fab"));
        mailIcon.click();
    }

    public void waitForPopup(String popupText) {
        WebElement popupWindow = new WebDriverWait(driver, Duration.ofSeconds(10L))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(String.format("//*[@text='%s']", popupText))));
        Assert.assertTrue(popupWindow.isDisplayed());
    }

    public WebElement getElementWithText(String elementType, String elementText) {
        return driver.findElement(By.xpath(String.format("//%s[@text='%s']", elementType, elementText)));
    }

    public void setInputText(By locator, CharSequence value) {
        new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.presenceOfElementLocated(locator)).sendKeys(value);
    }

    @PreDestroy
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
