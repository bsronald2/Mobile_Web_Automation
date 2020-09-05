package com.babbel.auto.mobile;


import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobileHooks {
    private static boolean envFlag = false;
    private final static Logger logger = LogManager.getLogger(MobileHooks.class);


    @Before
    public void setup() throws Exception {
        // Open web browser and navigate main page
        if (!envFlag) {
            envFlag = true;
            // Init Appium Driver
//            MobileDriverManager.getInstance();
        }
    }

    /**
     * Close driver after all test executions.
     */
    public void cleanEnvironment() {
        // After execution
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                try {
                    MobileDriverManager.getInstance().getDriver().close();
                    logger.info("Close Mobile App");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
