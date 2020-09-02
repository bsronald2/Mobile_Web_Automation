package com.babbel.auto.web.page;

import com.babbel.auto.web.WebBasePage;

public class FactoryPage {

//    /**
//     * Private constructor.
//     */
//    private FactoryPage(){}

    public static WebBasePage getPage(String pageName) {
        switch (pageName.toUpperCase()) {
            case "HOMEPAGE":
                return new HomePage();
            case "QUESTIONPAGE":
                return new QuestionPage();
            default:
                throw new IllegalArgumentException(pageName + " was not yet developed.");
        }
    }
}
