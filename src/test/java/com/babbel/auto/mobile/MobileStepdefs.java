package com.babbel.auto.mobile;

import com.babbel.auto.entities.env.EnvInfo;
import com.babbel.auto.entities.env.Mobile;
import com.babbel.auto.entities.env.User;
import com.babbel.auto.mobile.page.HomeAppPage;
import com.babbel.auto.mobile.page.LoginAppPage;
import com.babbel.auto.utils.Constants;
import com.babbel.auto.utils.EnvInfoHandler;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MobileStepdefs {

    private LoginAppPage loginAppPage;
    private Mobile mobile;
    private HomeAppPage homeAppPage;

    public MobileStepdefs() {
        this.loginAppPage = new LoginAppPage();
        EnvInfo envInfo = new EnvInfoHandler(Constants.ENV_INFO_PATH).getEnvInfo();
        envInfo.loadInitParam();
        this.mobile = envInfo.getMobile();
    }

    @When("I login successfully to App under test")
    public void iLoginSuccessfullyToAppUnderTest() {
        User user = this.mobile.getUser();
        this.homeAppPage = this.loginAppPage.sigInForm(user.getUserName(), user.getPassword());
    }

    @Then("The HomePage should be displayed")
    public void theHomePageShouldBeDisplayed() {
        boolean actual = this.homeAppPage.isClickMeBtnPresent();
    }
}
