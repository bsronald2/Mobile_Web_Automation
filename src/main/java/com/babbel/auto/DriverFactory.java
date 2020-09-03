package com.babbel.auto;

import com.babbel.auto.Driver;
import com.babbel.auto.mobile.driver.Android;
import com.babbel.auto.web.driver.Chrome;

import static com.babbel.auto.utils.Constants.*;
import static com.babbel.auto.utils.Constants.IOS;

public class DriverFactory {


    private DriverFactory() {
        // Default constructor
    }

    public static Driver getDriver(String driver) {
        switch (driver) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return null;
            case ANDROID:
                return new Android();
            case IOS:
                return null;
            default:
                throw new IllegalArgumentException(driver + " is not supported.");
        }
    }
}
