package com.babbel.auto.mobile.page;

import com.babbel.auto.mobile.MobileBasePage;
import com.babbel.auto.mobile.MobileCommonActions;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginAppPage extends MobileBasePage {

    private WebElement emailField;

    @AndroidFindBy(id = "com.github.fgoncalves.qa:id/password")
    private WebElement passwordField;

    @AndroidFindBy(id = "com.github.fgoncalves.qa:id/email_sign_in_button")
    private WebElement signInBtn;


    /**
     * LoginAppPage Constructor.
     */
    public LoginAppPage() {
        this.emailField = webDriverWait.until(ExpectedConditions
                .presenceOfElementLocated(MobileBy.id("com.github.fgoncalves.qa:id/email")));
    }

    /**
     * Fill out sign in form and click on SigIn button.
     *
     * @param userName email as String
     * @param password user password as String
     * @return HomeAppPage instance
     */
    public HomeAppPage sigInForm(String userName, String password) {
        setEmailField(userName);
        setPasswordField(password);
        return clickOnSignInBtn();
    }

    /**
     * Click on Sign in Button.
     *
     * @return new HomeAppPage
     */
    private HomeAppPage clickOnSignInBtn() {
        MobileCommonActions.clickElement(signInBtn);
        return new HomeAppPage();
    }

    /**
     * Fill out password in text field.
     *
     * @param password as String
     */
    private void setPasswordField(String password) {
        MobileCommonActions.setTextField(passwordField, password);
    }

    /**
     * Set email field.
     *
     * @param userName as String
     */
    private void setEmailField(String userName) {
        MobileCommonActions.setTextField(emailField, userName);
    }
}
