package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class IsDisplayedTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(IsDisplayedTest.class);

    //session/{session id}/element/{element id}/displayed.
    @Test
    public void isDisplayed() {
        driver.get("https://github.com/join");
        WebElement btn = driver.findElement(By.cssSelector("#signup_button"));
        logger.info("Disabled: {}", btn.isDisplayed());
        logger.warn("More: https://www.w3.org/TR/webdriver1/#element-displayedness");
    }

    //session/{session id}/element/{element id}/enabled
    @Test
    public void isEnabled() {
        driver.get("https://github.com/join");
        WebElement btn = driver.findElement(By.cssSelector("#signup_button"));
        logger.info("Enabled: {}", btn.isEnabled());
    }

    //session/{session id}/element/{element id}/selected
    @Test
    public void isSelected() {
        driver.get("https://otus.ru/");
        driver.findElement(By.cssSelector("button[data-modal-id='new-log-reg']")).click();
        driver.findElement(By.cssSelector("div[data-tab-id='register']")).click();

        boolean student = driver.findElement(By.cssSelector("#type-student")).isSelected();
        boolean teacher = driver.findElement(By.cssSelector("#type-teacher")).isSelected();
        boolean b2b = driver.findElement(By.cssSelector("#type-b2b")).isSelected();

        logger.info("Student {} - Teacher {} - B2B {}", student, teacher, b2b);

        boolean termsAgree = driver.findElement(By.cssSelector("input[name='terms_agree']")).isSelected();
        boolean subscribe = driver.findElement(By.cssSelector("input[name='subscribe']")).isSelected();
        logger.info("Terms agree {} - Subscribe {}", termsAgree, subscribe);
    }
}

