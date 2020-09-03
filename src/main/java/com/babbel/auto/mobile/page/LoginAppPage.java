package com.babbel.auto.mobile.page;

import com.babbel.auto.mobile.MobileBasePage;
import com.babbel.auto.mobile.MobileCommonActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginAppPage extends MobileBasePage {

//    @AndroidFindBy(id = "com.github.fgoncalves.qa:id/email")
    private WebElement emailField;

    @AndroidFindBy(id = "com.github.fgoncalves.qa:id/password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.github.fgoncalves.qa:id/email_sign_in_button")
    private WebElement signInBtn;


    public LoginAppPage() {
        this.emailField = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.id("com.github.fgoncalves.qa:id/email")));
    }

    public HomeAppPage sigInForm(String userName, String password) {
        setEmailField(userName);
        setPasswordField(password);
        return clickOnSignInBtn();
    }

    private HomeAppPage clickOnSignInBtn() {
        MobileCommonActions.clickElement(signInBtn);
        return new HomeAppPage();
    }

    private void setPasswordField(String password) {
        MobileCommonActions.setTextField(passwordField, password);
    }

    private void setEmailField(String userName) {
        MobileCommonActions.setTextField(emailField, userName);
    }
}
