package org.prog;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class MySecondTest {
    private AppiumDriver driver;

    @BeforeSuite
    public void setupDriver() throws MalformedURLException {
        String appPackage = System.getProperty("package", "com.example.basicactivity");
        String appActivity = System.getProperty("activity", "MainActivity");
        String appFileName = System.getProperty("appFile", "app-debug.apk");
        File appFile = new File(appFileName);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appPackage + "." + appActivity);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", AutomationName.ANDROID_UIAUTOMATOR2);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability("app", appFile.getAbsolutePath());

        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/"), capabilities);
    }

    //    @Test
    public void clickNextAndBackButtons() {
        WebElement btnNext = driver.findElement(By.id("bnt_next"));
        btnNext.click();
        WebElement btnBack = driver.findElement(By.id("bnt_previous"));
        Assert.assertTrue(btnBack.isDisplayed(), "Button from page 2 is missing!");
        Assert.assertTrue(btnBack.isEnabled(), "Button from page 2 is not interactive!");
        btnBack.click();
        WebElement textContainer = driver.findElement(By.id("textview_first"));
        Assert.assertTrue(textContainer.isDisplayed(), "Text container from page 1 is missing!");
        Assert.assertEquals(textContainer.getText(), "First text fragment");
    }

    //    @Test
    public void popupTest() {
        WebElement mailIcon = driver.findElement(By.id("fab"));
        mailIcon.click();
        WebElement popupWindow = new WebDriverWait(driver, Duration.ofSeconds(10L))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text='Replace with your own action']")));
        Assert.assertTrue(popupWindow.isDisplayed());
    }

    public void smth(){

    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
