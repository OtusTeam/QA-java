package com.otus.selenium.pageobject.pages.atinfo;

import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.WebDriver;

public abstract class Page {
    private final static String ATINFO_URL = "https://automated-testing.info/";
    protected final WebDriver driver;

    protected Page(WebDriver driver) {
        this.driver = driver;
    }

    public void login() {
        throw new NotImplementedException("");
    }

    public void logout() {
        throw new NotImplementedException("");
    }

    public MainPage open() {
        driver.get(ATINFO_URL);
        return new MainPage(driver);
    }
}
