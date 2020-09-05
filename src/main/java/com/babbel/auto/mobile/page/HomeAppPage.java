package com.babbel.auto.mobile.page;

import com.babbel.auto.mobile.MobileBasePage;
import com.babbel.auto.mobile.MobileCommonActions;
import com.babbel.auto.mobile.MobileCommonValidations;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeAppPage extends MobileBasePage {

    private WebElement mainImage;
    private final By outOfHomeBtnBy;

    /**
     * HomeAppPage constructor.
     */
    public HomeAppPage() {
        this.mainImage = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy
                        .AccessibilityId("Picture of a house")));
        this.outOfHomeBtnBy = MobileBy.id("com.github.fgoncalves.qa:id/OutOfHomeBtn");
    }

    /**
     *  Verify id the ClickMe button is present.
     * @return true if element was found, otherwise false.
     */
    public boolean isClickMeBtnPresent() {
        return MobileCommonValidations.isElementPresent(this.outOfHomeBtnBy);
    }
}
