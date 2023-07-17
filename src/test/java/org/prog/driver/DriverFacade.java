package org.prog.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.appium.driver.DriverFactory;
import org.prog.appium.driver.DriverType;

import java.time.Duration;

public class DriverFacade {

    private final static DriverFacade instance = new DriverFacade();

    private final AndroidDriver driver;

    private DriverFacade() {
        this.driver = DriverFactory.getInstance().getDriver(DriverType.APPIUM_LOCAL);
    }

    public static DriverFacade getInstance() {
        return instance;
    }

    public AndroidDriver getDriver() {
        return this.driver;
    }

    public WebElement findBy(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
