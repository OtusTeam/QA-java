package com.otus.selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageSourceTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(PageSourceTest.class);

    @Test
    public void getPAgeSource() {
        driver = new ChromeDriver();
        driver.get("https://www.w3.org/TR/webdriver1");
        String src = driver.getPageSource();
        logger.warn("There's no info in w3c");
        logger.info("Page source:\n{}", src);
    }
}
