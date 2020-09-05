package com.babbel.auto.web;

import com.babbel.auto.web.page.HomePage;
import com.babbel.auto.web.page.PageNavigator;
import com.babbel.auto.web.page.QuestionPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class WebStepDefs {

    private HomePage homePage;
    private QuestionPage questionPage;

    public WebStepDefs() {
        this.homePage = new HomePage();
    }

    @Given("I am in homepage")
    public void iAmInHomepage() {
        if (!PageNavigator.getInstance().isHomePage()) {
            this.homePage = PageNavigator.getInstance().goHomePage();
        }
    }

    @When("I select the language to start learning {string}")
    public void iSelectTheLanguageToStartLearning(String language) {
        this.questionPage = this.homePage.startLearning(language);
    }

    @Then("I verify that QuestionPage is displayed {string}")
    public void iVerifyThatQuestionPageIsDisplayed(String expectedQuestion) {
        String actualQuestion = this.questionPage.getContainerQuestion();
        Assert.assertEquals("Expected and Actual Questions are not equals: ", expectedQuestion, actualQuestion);
    }
}
