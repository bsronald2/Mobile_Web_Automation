package com.babbel.auto.mobile.driver;

import com.babbel.auto.AbstractDriverManager;
import com.babbel.auto.entities.env.Capabilities;
import com.babbel.auto.entities.env.EnvInfo;
import com.babbel.auto.entities.env.Mobile;
import com.babbel.auto.mobile.App;
import com.babbel.auto.utils.Configuration;
import com.babbel.auto.utils.Constants;
import com.babbel.auto.utils.EnvInfoHandler;
import org.openqa.selenium.remote.DesiredCapabilities;

public abstract class MobileCapabilities extends AbstractDriverManager  {

    protected String driver;
    protected DesiredCapabilities caps;
    protected Mobile mobile;

    public MobileCapabilities() {
        setCapabilities();
    }

    /**
     * Set up Desired Capabilities.
     */
    private void setCapabilities() {
        this.mobile = this.envInfo.getMobile();
        this.driver = Configuration.getPropertyValue(Constants.DRIVER);
        caps = new DesiredCapabilities();
        Capabilities capabilities = mobile.getCapabilities(driver);
        caps.setCapability("platformName",capabilities.getPlatformName());
        caps.setCapability("platformVersion", capabilities.getPlatformVersion());
        caps.setCapability("deviceName", capabilities.getDeviceName());
        caps.setCapability("automationName", capabilities.getAutomationName());
        caps.setCapability("app", App.valueOf(driver.toUpperCase()).getAppPath());
    }
}
