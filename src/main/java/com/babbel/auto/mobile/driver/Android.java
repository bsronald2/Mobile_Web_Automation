package com.babbel.auto.mobile.driver;

import com.babbel.auto.AbstractDriverManager;
import com.babbel.auto.Driver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class Android extends MobileCapabilities implements Driver {
//
//    public Android() {
//        super();
//    }

    @Override
    public WebDriver initDriver() {
        try {
            return new AndroidDriver(new URL(mobile.getUrl()), this.caps);
        } catch (MalformedURLException ex) {
            ex.fillInStackTrace();
        }
        return null;
    }
}
