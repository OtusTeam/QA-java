package com.otus.selenium.wait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

import static java.util.concurrent.TimeUnit.SECONDS;

public class ImplicitlyWait extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ImplicitlyWait.class);

    @Test
    public void implicit() {
        driver.get("https://www.booking.com/index.ru.html");

        driver.manage().timeouts().implicitlyWait(4, SECONDS);

        driver.findElement(By.cssSelector(".header-signin-prompt__body a.b-button")).click();
        logger.info(driver.getTitle());
    }
}
