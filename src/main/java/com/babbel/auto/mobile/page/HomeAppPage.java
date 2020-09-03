package com.babbel.auto.mobile.page;

import com.babbel.auto.mobile.MobileBasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeAppPage extends MobileBasePage {

    private WebElement mainImage;
    private final By outOfHomeBtnBy;

    public HomeAppPage() {
        this.mainImage = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy
                        .AccessibilityId("Picture of a house")));
        this.outOfHomeBtnBy = MobileBy.id("com.github.fgoncalves.qa:id/OutOfHomeBtn");
    }


    public boolean isClickMeBtnPresent() {
        return isElementPresent(this.outOfHomeBtnBy);
    }
}
