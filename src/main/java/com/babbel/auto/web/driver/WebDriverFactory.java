package com.babbel.auto.web.driver;

import static com.babbel.auto.utils.Constants.CHROME;
import static com.babbel.auto.utils.Constants.FIREFOX;

public class WebDriverFactory {


    private WebDriverFactory() {
        // Default constructor
    }

    public static WDriver getDriver(String browser) {
        switch (browser) {
            case CHROME:
                return new Chrome();
            case FIREFOX:
                return null;
            default:
                throw new IllegalArgumentException(browser + " browser is not supported.");
        }
    }
}
