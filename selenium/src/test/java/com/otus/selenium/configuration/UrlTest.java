package com.otus.selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringEndsWith.endsWith;

public class UrlTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(UrlTest.class);

    @Test
    public void get() {
        driver = new ChromeDriver();

        try {
            driver.get("yandex.ru");
        } catch (Exception ex) {
            logger.error(ex);
        }

        driver.get("https://ya.ru");

        logger.warn("Use with protocol only. http(s)://");
        logger.warn("This will follow redirects");
        logger.warn("Synonym for WebDriver.Navigation.to(String)");
    }

    @Test
    public void getCurrentUrl() {
        driver = new ChromeDriver();
        driver.get("https://angular.io/");
        driver.findElement(By.cssSelector("a.button.hero-cta")).click();
        String url = driver.getCurrentUrl();
        logger.info("Current url: {}", url);
        assertThat(url, endsWith("angular.io/start"));
    }
}
