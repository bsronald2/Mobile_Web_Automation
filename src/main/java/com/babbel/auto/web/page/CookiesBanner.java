package com.babbel.auto.web.page;

import com.babbel.auto.web.WebBasePage;
import com.babbel.auto.web.WebCommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CookiesBanner extends WebBasePage {

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElement acceptCookiesBtn;

    @FindBy(css = "div#onetrust-banner-sdk[style='bottom: 0px']")
    private WebElement banner;

    CookiesBanner() {
        webDriverWait.until(ExpectedConditions.visibilityOf(banner));
    }
    public void clickOnAcceptCookies() {
        WebCommonActions.clickElement(acceptCookiesBtn);
    }
}
