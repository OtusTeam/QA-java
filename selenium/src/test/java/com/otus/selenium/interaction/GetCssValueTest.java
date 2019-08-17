package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetCssValueTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(GetCssValueTest.class);

    //session/{session id}/element/{element id}/css/{property name}
    @Test
    public void getCss() {
        driver.get("https://ya.ru/");
        WebElement find = driver.findElement(By.cssSelector("button"));
        logger.info("Src: {}", find.getCssValue("cursor")); //pointer
    }
}

