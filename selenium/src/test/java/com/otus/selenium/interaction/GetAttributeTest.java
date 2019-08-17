package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetAttributeTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(GetAttributeTest.class);

    //session/{session id}/element/{element id}/attribute/{name}
    @Test
    public void getAttribute() {
        driver.get("https://automated-testing.info/");
        WebElement logo = driver.findElement(By.cssSelector("#site-logo"));
        logger.info("Src: {}", logo.getAttribute("src"));
        logger.info("Name: {}", logo.getAttribute("localName"));
        WebElement header = driver.findElement(By.cssSelector("header"));
        logger.info("HTML: {}", header.getAttribute("outerHTML"));
    }

    @Test
    public void getHref() {
        driver.get("https://market.yandex.ru/");
        WebElement logo = driver.findElement(By.cssSelector("div.n-w-tab_type_navigation-menu > a"));
        String href = logo.getAttribute("href");
        logger.info("HREF: {}", href);
        assertThat(href, startsWith("https://market.yandex.ru"));
    }

    @Test
    public void getBooleanAttribute() {
        driver.get("https://github.com/join");
        WebElement logo = driver.findElement(By.cssSelector("#signup_button"));
        logger.info("Disabled: {}", logo.getAttribute("disabled"));
        logger.info("Readonly: {}", logo.getAttribute("readonly"));
        logger.info("It's 'true' or null only");
    }


}

