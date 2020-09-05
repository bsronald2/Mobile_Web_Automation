package com.babbel.auto.mobile.driver;

import com.babbel.auto.Driver;
import com.babbel.auto.web.driver.Chrome;

import static com.babbel.auto.utils.Constants.ANDROID;
import static com.babbel.auto.utils.Constants.IOS;

public class MobileDriverFactory {

    /**
     * Private Constructor.
     */
    private MobileDriverFactory() {
        // Default constructor
    }

    /**
     * This function return an specific Mobile Driver.
     *
     * @param driver to return instance
     * @return Driver instance
     */
    public static Driver getDriver(String driver) {
        switch (driver.toLowerCase()) {
            case ANDROID:
                return new Android();
            case IOS:
                return null;
            default:
                throw new IllegalArgumentException(driver + " is not supported.");
        }
    }
}
