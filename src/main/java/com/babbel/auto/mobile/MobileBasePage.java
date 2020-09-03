package com.babbel.auto.mobile;

import com.babbel.auto.entities.env.Mobile;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class MobileBasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;
    private static int DEFAULT_WAIT_TIME = 15;

    public MobileBasePage() {
        webDriver = MobileDriverManager.getInstance().getDriver();
        webDriverWait = MobileDriverManager.getInstance().getWaitDriver();
        PageFactory.initElements(new AppiumFieldDecorator(webDriver, Duration.ofSeconds(DEFAULT_WAIT_TIME)), this);
    }

    public Boolean isElementPresent(By by) {
        try {
            webDriver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
