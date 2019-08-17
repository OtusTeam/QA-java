package com.otus.selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TargetLocatorTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(TargetLocatorTest.class);

    @Test
    public void defaultContent() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://ya.ru");
        driver.switchTo().activeElement().sendKeys("test");
    }
}
