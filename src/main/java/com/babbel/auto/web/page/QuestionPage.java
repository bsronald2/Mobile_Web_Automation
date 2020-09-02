package com.babbel.auto.web.page;

import com.babbel.auto.web.WebBasePage;
import com.babbel.auto.web.WebCommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class QuestionPage extends WebBasePage {

    @FindBy(css = "section.questions-page-container")
    private WebElement sectionQuestion;

    @FindBy(css = "section.questions-page-container > h1.heading")
    private WebElement headerQuestion;

    private HomePageHeader homePageHeader;

    public QuestionPage() {

    }

    public String getContainerQuestion() {

        return WebCommonActions.getText(headerQuestion).trim();
    }
}
