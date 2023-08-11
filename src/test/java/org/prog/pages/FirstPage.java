package org.prog.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.appium.driver.DriverFactory;
import org.prog.pages.elements.AndroidElement;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import java.time.Duration;

@Component
public class FirstPage extends AbstractPage {

    private final WidgetOne widgetOne;
    private final WidgetTwo widgetTwo;

    public FirstPage(DriverFactory driverFactory) {
        super(driverFactory);
        this.widgetOne = new WidgetOne(driver);
        this.widgetTwo = new WidgetTwo(driver);
    }

    public void clickNextButton() {
        WebElement btnNext = driver.findElement(By.id("bnt_next"));
        Assert.assertTrue(btnNext.isDisplayed(), "Button from page 2 is missing!");
        Assert.assertTrue(btnNext.isEnabled(), "Button from page 2 is not interactive!");
        btnNext.click();
    }

    public boolean isPageLoaded() {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("bnt_next"))).isDisplayed();
    }

    public String getTextContent() {
        return driver.findElement(By.id("textview_first")).getText();
    }

    public WidgetOne onWidgetOne() {
        return this.widgetOne;
    }

    public WidgetTwo onWidgetTwo() {
        return this.widgetTwo;
    }

    public void setFieldValue(AndroidElement element, String value) {
        setInputText(element.getLocator(), value);
    }

    public void clickLoginBtn() {
        driver.findElement(By.id("btn_login")).click();
    }
}
