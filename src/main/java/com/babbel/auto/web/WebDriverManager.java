package com.babbel.auto.web;

import com.babbel.auto.AbstractDriverManager;
import com.babbel.auto.DriverManager;
import com.babbel.auto.entities.env.Web;
import com.babbel.auto.utils.Configuration;
import com.babbel.auto.utils.Constants;
import com.babbel.auto.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class WebDriverManager extends AbstractDriverManager implements DriverManager {

    private static WebDriverManager instance = null;
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private WebDriverManager() {
        super();
        Web web = this.envInfo.getWeb();
        final String url = web.getUrl();
        final int timeOut = web.getTimeout();
        final int maxTimeOut = web.getWaitTimeOut();
        final String browser = Configuration.getPropertyValue(Constants.BROWSER);
        webDriver = Objects.requireNonNull(DriverFactory.getDriver(browser)).initDriver();
        webDriver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
        webDriverWait = new WebDriverWait(webDriver, maxTimeOut);
    }

    public static WebDriverManager getInstance() {
        if (instance == null) {
            instance = new WebDriverManager();
            return instance;
        }

        return instance;
    }

    public WebDriver getDriver() {
        return webDriver;
    }

    @Override
    public WebDriverWait getWaitDriver() {
        return webDriverWait;
    }
}
