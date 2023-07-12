package org.prog.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class FirstPage extends AbstractPage {

    public FirstPage(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public void clickNextButton() {
        WebElement btnNext = driver.findElement(By.id("bnt_next"));
        Assert.assertTrue(btnNext.isDisplayed(), "Button from page 2 is missing!");
        Assert.assertTrue(btnNext.isEnabled(), "Button from page 2 is not interactive!");
        btnNext.click();
    }

    public String getTextContent() {
        return driver.findElement(By.id("textview_first")).getText();
    }

//    public void loginToPortmone(String username, String password){
//        WebElement userNameElement;
//        userNameElement.sendKeys(username);
//        WebElement passwordElement;
//        passwordElement.sendKeys(password);
//        WebElement loginButton;
//        loginButton.click();
//        new WebDriverWait(null, Duration.ofSeconds(30L))
//                .until(ExpectedConditions.presenceOfElementLocated(By.id("loadingThing")));
//        new WebDriverWait(null, Duration.ofSeconds(30L))
//                .until(ExpectedConditions.invisibilityOfElementLocated(By.id("loadingThing")));
//    }

}
