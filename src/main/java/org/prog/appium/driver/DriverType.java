package org.prog.appium.driver;

import io.appium.java_client.remote.AutomationName;

public enum DriverType {
    APPIUM_LOCAL(AutomationName.ANDROID_UIAUTOMATOR2),
    APPIUM_REMOTE(AutomationName.ESPRESSO);

    private final String automationName;

    DriverType(String automationName) {
        this.automationName = automationName;
    }

    public String getAutomationName() {
        return automationName;
    }
}
