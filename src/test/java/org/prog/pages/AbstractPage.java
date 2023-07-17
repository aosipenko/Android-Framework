package org.prog.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public abstract class AbstractPage {

    protected final AppiumDriver driver;

    protected AbstractPage(AppiumDriver driver) {
        this.driver = driver;
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
        driver.findElement(locator).sendKeys(value);
    }
}
