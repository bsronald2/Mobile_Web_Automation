package com.babbel.auto.web.page;

import com.babbel.auto.entities.env.EnvInfo;
import com.babbel.auto.utils.Constants;
import com.babbel.auto.utils.EnvInfoHandler;
import com.babbel.auto.web.WebBasePage;

public class PageNavigator extends WebBasePage {

    private static PageNavigator instance = null;
    public EnvInfo envInfo;

    private PageNavigator() {
        this.envInfo = new EnvInfoHandler(Constants.ENV_INFO_PATH).getEnvInfo();;
    }

    public static PageNavigator getInstance() {
        if (instance == null) {
            return new PageNavigator();
        }

        return instance;
    }

    /**
     * Navigate to Magazine Home Page.
     *
     * @return new MagazineHomePage instance
     */
    public HomePage goHomePage() {
        webDriver.get(this.envInfo.getWeb().getUrl());
        return new HomePage();
    }

    /**
     * True if we are in homepage, otherwise false.
     *
     * @return Boolean value
     */
    public boolean isHomePage() {
        String currentUrl = webDriver.getCurrentUrl();

        return currentUrl.equals(envInfo.getWeb().getUrl());
    }

    /**
     * Accept Cookies.
     */
    public void acceptCookies() {
        new CookiesBanner().clickOnAcceptCookies();
    }
}
