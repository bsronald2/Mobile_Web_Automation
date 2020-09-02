package com.babbel.auto.web;

import com.babbel.auto.web.page.PageNavigator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WebHooks {

    private static boolean envFlag = false;
    private final static Logger logger = LogManager.getLogger(WebHooks.class);

    public WebHooks() {

    }

    @Before
    public void setup() throws Exception {
        // Open web browser and navigate main page
        if (!envFlag) {
            envFlag = true;
            // Init Web Driver
            PageNavigator.getInstance().goHomePage();
            PageNavigator.getInstance().acceptCookies();
            cleanEnvironment();
        }
    }

    @After
    public void tearDown() {

    }

    @After(value = "@HomePage", order = 10)
    public void navigateToHomePage() {
        PageNavigator.getInstance().goHomePage();
    }

    /**
     * Close web browser after all test executions.
     */
    public void cleanEnvironment() {
        // After execution
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    WebDriverManager.getInstance().getDriver().close();
                    logger.info("Close Web Browser.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
