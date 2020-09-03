package com.babbel.auto.mobile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MobileCommonActions {

    /**
     * Private Constructor.
     */
    private MobileCommonActions() {}


    public static void setTextField(WebElement webElement, String text) {
        clearTextField(webElement);
        sendKeys(webElement, text);
    }

    private static void clearTextField(WebElement webElement) {
        MobileDriverManager.getInstance().getWaitDriver().until(ExpectedConditions.visibilityOf(webElement));
        webElement.clear();

    }


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
