package com.babbel.auto.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class MobileCommonValidations {

    /**
     * Private Constructor.
     */
    private MobileCommonValidations() {

    }

    /**
     * This method verifies if the driver can find a web element.
     *
     * @param by used to locate element
     * @return true if the element was found, otherwise false.
     */
    public static Boolean isElementPresent(By by) {
        try {
            MobileDriverManager.getInstance().getDriver().findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
