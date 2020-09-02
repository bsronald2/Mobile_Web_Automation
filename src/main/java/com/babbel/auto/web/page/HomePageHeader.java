package com.babbel.auto.web.page;

import com.babbel.auto.web.WebBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageHeader extends WebBasePage {

    @FindBy(css = "img.babbel-logo")
    private WebElement babbelLogo;

    public HomePageHeader(){
        webDriverWait.until(ExpectedConditions.visibilityOf(babbelLogo));
    }


}
