package com.babbel.auto.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class WebBasePage {

    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait;

    public WebBasePage()  {
        webDriver = WebDriverManager.getInstance().getDriver();
        webDriverWait =  WebDriverManager.getInstance().getWaitDriver();
        PageFactory.initElements(webDriver, this);
    }
}
