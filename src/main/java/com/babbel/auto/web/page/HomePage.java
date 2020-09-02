package com.babbel.auto.web.page;

import com.babbel.auto.web.WebBasePage;
import com.babbel.auto.web.WebCommonActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends WebBasePage {

    @FindBy(css = "div.language-picker-component >* button.language-picker-button")
    private WebElement languagePickerBtn;

    @FindBy(css = "div.language-picker-wrapper >* a.babbel-button")
    private WebElement startLearningBtn;

    private HomePageHeader homePageHeader;

    public HomePage() {
        this.homePageHeader = new HomePageHeader();
    }

    public QuestionPage startLearning(String language) {
        clickOnLanguagePicker();
        selectLanguagePickerDropDown(language);
        clickOnStartLearningBtn();

        return new QuestionPage();
    }

    private void clickOnStartLearningBtn() {
        WebCommonActions.clickElement(startLearningBtn);
    }

    private void selectLanguagePickerDropDown(String language) {
        String cssSelector = String
                .format("div.language-picker-dropdown-container.visible >* [data-language-code='%s']",
                        Language.valueOf(language.toUpperCase()).getCode());
        By languagePicker = By.cssSelector(cssSelector);
        WebElement languageBtn = webDriver.findElement(languagePicker);
        WebCommonActions.clickElement(languageBtn);
    }

    private void clickOnLanguagePicker() {
        WebCommonActions.clickElement(languagePickerBtn);
        // Verify drop down is visible
        By isDropDownVisible = By.cssSelector("div.language-picker-dropdown-container.visible");
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(isDropDownVisible));
    }
}
