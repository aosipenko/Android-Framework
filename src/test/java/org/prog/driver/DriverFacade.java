package org.prog.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.appium.driver.DriverFactory;
import org.prog.appium.driver.DriverType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
public class DriverFacade {

    private AndroidDriver driver;

    public DriverFacade(DriverFactory driverFactory) {
//        this.driver = driverFactory.getDriver(DriverType.APPIUM_LOCAL);
    }

    public AndroidDriver getDriver() {
        return this.driver;
    }

    public WebElement findBy(By locator) {
        return new WebDriverWait(driver, Duration.ofSeconds(30L))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
