package com.babbel.auto.web;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WebCommonActions {

    /**
     * Constructor private.
     */
    private WebCommonActions() {
    }

    /**
     * This method waits and clear the element.
     *
     * @param webElement Element to wait and clear.
     */
    public static void clearTextField(final WebElement webElement) {
        WebDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * This method waits and fill the element.
     *
     * @param webElement Element to wait and fill.
     * @param text       text to fill.
     */
    public static void sendKeys(final WebElement webElement, final String text) {
        WebDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
        webElement.sendKeys(text);
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param webElement Element to wait and clickElement.
     */
    public static void clickElement(final WebElement webElement) {
        WebDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param webElement Element to wait and clickElement.
     * @return text to element.
     */
    public static String getText(final WebElement webElement) {
        WebDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    /**
     * This method set a text field.
     *
     * @param webElement UI element
     * @param text plain text
     */
    public static void setTextField(WebElement webElement, final String text) {
        clearTextField(webElement);
        sendKeys(webElement, text);
    }
}
