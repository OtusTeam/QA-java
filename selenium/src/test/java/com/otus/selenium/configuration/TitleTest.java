package com.otus.selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class TitleTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TitleTest.class);

    @Test
    public void getTitle() {
        driver = new ChromeDriver();
        logger.info("Title on start: {}", driver.getTitle());
        driver.get("https://angular.io/");
        logger.info("Title on webpage: {}", driver.getTitle());
    }
}
