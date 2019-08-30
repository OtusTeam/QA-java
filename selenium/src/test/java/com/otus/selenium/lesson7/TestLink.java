package com.otus.selenium.lesson7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestLink {
    private static final Logger logger = LogManager.getLogger(TestLink.class);
    private static final String HOST = "http://ya.ru";
    private static WebDriver driver;
    private static final long TIMEOUT = 3;

    @BeforeClass
    public static void generalSetup(){
        String browser = System.getProperty("browser").trim().toUpperCase();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        driver = WebDriverFactory.createDriver(WebDriverType.valueOf(browser), options);
        driver = WebDriverFactory.createDriver(WebDriverType.valueOf(browser));
        if (driver != null) {
            driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        }
    }

    @AfterClass
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void pageTitleNotEmptyTest(){
        driver.get(HOST);
        String pageTitle = driver.getTitle();
        logger.info(pageTitle);
        Assert.assertNotEquals("", pageTitle);
    }
}