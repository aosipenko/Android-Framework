package org.prog.appium.driver;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.federatedcredentialmanagement.HasFederatedCredentialManagement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

import java.io.File;
import java.net.URL;

@Component
public class DriverFactory {

    private final String appPackage;
    private final String appActivity;
    private final String appFileName;

    public DriverFactory() {
        this.appPackage = System.getProperty("package", "com.example.basicactivity");
        this.appActivity = System.getProperty("activity", "MainActivity");
        this.appFileName = System.getProperty("appFile", "app-debug.apk");
    }

    public AndroidDriver getDriver(DriverType driverType) {
        DesiredCapabilities capabilities = capabilities(driverType);
        try {
            if (DriverType.APPIUM_LOCAL.equals(driverType)) {
                capabilities.acceptInsecureCerts();
                return new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            } else {
                capabilities.setPlatform(Platform.ANY);
                return new AndroidDriver(new URL("http://remote.appium.com:4723/"), capabilities);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private DesiredCapabilities capabilities(DriverType driverType) {
        File appFile = new File(appFileName);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appPackage", appPackage);
        capabilities.setCapability("appActivity", appPackage + "." + appActivity);
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", driverType.getAutomationName());
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        capabilities.setCapability("app", appFile.getAbsolutePath());
        return capabilities;
    }
}
