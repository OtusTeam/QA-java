package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

public class GetTextTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(GetTextTest.class);

    //session/{session id}/element/{element id}/text
    @Test
    public void getText() {
        driver.get("https://seleniumhq.github.io/selenium/docs/api/java/org/openqa/selenium/WebElement.html");
        String h2 = driver.findElement(By.cssSelector("h2")).getText();
        logger.info("h2 content: {}", h2);

        String header = driver.findElement(By.cssSelector(".header")).getText();
        logger.info("header content: {}", header);
        logger.info("returns an element’s text 'as rendered'");
    }

    @Test
    public void getInputText() {
        driver.get("https://ya.ru");
        String text = driver.findElement(By.cssSelector("#text")).getText();
        logger.info("Content: {}", text);

        driver.findElement(By.cssSelector("#text")).sendKeys("  o", "t", "u", "s", " test  ");
        text = driver.findElement(By.cssSelector("#text")).getText();
        logger.info("Content: {}", text);
        logger.warn("Why it;s still empty?");
    }
}

