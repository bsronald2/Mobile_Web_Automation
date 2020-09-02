package com.babbel.auto.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static boolean envFlag = false;
    private final static Logger logger = LogManager.getLogger(Hooks.class);

    public Hooks() {

    }

    @Before
    public void setup() {
        if (!envFlag) {
            envFlag = true;
        }
    }

    @After
    public void tearDown() {

    }
}
