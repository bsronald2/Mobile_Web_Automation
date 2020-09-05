package com.babbel.auto.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MobileCommonActions {

    /**
     * Private Constructor.
     */
    private MobileCommonActions() {}

    /**
     * This method set a text field.
     *
     * @param webElement UI element
     * @param text plain text
     */
    public static void setTextField(WebElement webElement, String text) {
        clearTextField(webElement);
        sendKeys(webElement, text);
    }

    /**
     * This method waits and clear the element.
     *
     * @param webElement Element to wait and clear.
     */
    private static void clearTextField(WebElement webElement) {
        MobileDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();
    }

    /**
     * This method waits and fill the element.
     *
     * @param webElement Element to wait and fill.
     * @param text text to fill.
     */
    public static void sendKeys(final WebElement webElement, final String text) {
        MobileDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.visibilityOf(webElement));
        webElement.sendKeys(text);
    }

    /**
     * This method waits and clickElement the element.
     *
     * @param webElement Element to wait and clickElement.
     */
    public static void clickElement(final WebElement webElement) {
        MobileDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }
}
