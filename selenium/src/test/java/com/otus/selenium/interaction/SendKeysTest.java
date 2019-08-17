package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SendKeysTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(SendKeysTest.class);

    @Test
    public void sendKeys() {
        driver.get("https://ya.ru");

        driver.findElement(By.cssSelector("#text")).sendKeys("  o", "t", "u", "s", " test  ");
        String text = driver.findElement(By.cssSelector("#text")).getAttribute("value");
        logger.info("Content: {}", text);

        driver.findElement(By.cssSelector("#text")).sendKeys("  ADDITIONAL TEXT");
        text = driver.findElement(By.cssSelector("#text")).getAttribute("value");
        logger.info("Content: {}", text);

        driver.findElement(By.cssSelector("#text")).sendKeys(Keys.ENTER);

        logger.warn("U better to go deeper inside sendkeys method");
    }
}

