package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

public class SubmitTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(SubmitTest.class);

    @Test
    public void submit() {
        driver.get("https://account.habr.com/login/");

        driver.findElement(By.cssSelector("#email_field")).submit();

        logger.info("Error text: {}", driver.findElement(By.cssSelector(".s-error")).getText());
        logger.warn("No info on W3C ¯\\_(ツ)_/¯");
    }
}

