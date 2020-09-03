package com.babbel.auto.mobile;

import com.babbel.auto.AbstractDriverManager;
import com.babbel.auto.DriverFactory;
import com.babbel.auto.DriverManager;
import com.babbel.auto.utils.Configuration;
import com.babbel.auto.utils.Constants;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;

public class MobileDriverManager extends AbstractDriverManager implements DriverManager {

    private static MobileDriverManager instance = null;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private MobileDriverManager() {
        String driver = Configuration.getPropertyValue(Constants.DRIVER);
        webDriver = Objects.requireNonNull(DriverFactory.getDriver(driver)).initDriver();
        webDriverWait = new WebDriverWait(webDriver, this.envInfo.getMobile().getWaitTimeOut());
    }

    public static MobileDriverManager getInstance() {
        if (instance == null) {
            instance = new MobileDriverManager();
            return instance;
        }

        return instance;
    }

    @Override
    public WebDriver getDriver() {

        return webDriver;
    }

    @Override
    public WebDriverWait getWaitDriver() {
        return webDriverWait;
    }
}
