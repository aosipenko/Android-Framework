package org.prog.pages;

import io.appium.java_client.AppiumDriver;

public abstract class AbstractWidget {

    private final AppiumDriver driver;

    protected AbstractWidget(AppiumDriver driver) {
        this.driver = driver;
    }
}
