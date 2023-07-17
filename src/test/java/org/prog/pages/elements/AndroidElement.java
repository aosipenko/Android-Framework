package org.prog.pages.elements;

import org.openqa.selenium.By;

public enum AndroidElement {

    LOGIN_INPUT(By.id("login")),
    PASSWORD_INPUT(By.id("password"));

    private final By locator;

    AndroidElement(By locator) {
        this.locator = locator;
    }

    public By getLocator() {
        return this.locator;
    }
}
