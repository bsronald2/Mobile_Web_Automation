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

    /**
     * Initiate mobile web driver.
     */
    private MobileDriverManager() {
        String driver = Configuration.getPropertyValue(Constants.DRIVER);
        webDriver = Objects.requireNonNull(DriverFactory.getDriver(driver)).initDriver();
        webDriverWait = new WebDriverWait(webDriver, this.envInfo.getMobile().getWaitTimeOut());
    }

    /**
     * Creates a singleton MobileDriverManager instance.
     * @return instance
     */
    public static MobileDriverManager getInstance() {
        if (instance == null) {
            instance = new MobileDriverManager();
            return instance;
        }

        return instance;
    }

    /**
     * This method return Mobile driver.
     *
     * @return webDriver
     */
    @Override
    public WebDriver getDriver() {
        return webDriver;
    }

    /**
     * This method return webDriverWait.
     *
     * @return webDriverWait
     */
    @Override
    public WebDriverWait getWaitDriver() {
        return webDriverWait;
    }
}
