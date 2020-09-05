package com.babbel.auto.web.driver;

import com.babbel.auto.Driver;
import com.babbel.auto.utils.EnvironmentChecker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static com.babbel.auto.utils.Constants.WINDOWS_OS;
import static com.babbel.auto.utils.Constants.LINUX_OS;

public class Chrome implements Driver, EnvDriver {

    private static final String WEB_DRIVER_PATH_WINDOWS = "drivers/chromedriver.exe";
    private static final String WEB_DRIVER_PATH_LINUX = "drivers/chromedriver";
    private static final String WEB_DRIVER_KEY = "webdriver.chrome.driver";

    /**
     * This method init Chrome web driver
     * @return
     */
    @Override
    public WebDriver initDriver() {
        String driverPath = getDriverPath();
        System.setProperty(WEB_DRIVER_KEY, driverPath);
        return new ChromeDriver();
    }

    /**
     * Retrieve the driver path by OS.
     *
     * @return driver path.
     */
    @Override
    public String getDriverPath() {
        final String os = EnvironmentChecker.getInstance().getOsName();
        switch (os) {
            case WINDOWS_OS:
                return WEB_DRIVER_PATH_WINDOWS;
            case LINUX_OS:
                return WEB_DRIVER_PATH_LINUX;
            default:
                throw new IllegalArgumentException(os + " OS system is not supported yet.");
        }
    }
}
