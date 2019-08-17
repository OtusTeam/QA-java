package com.otus.selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetLocationValueTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(GetLocationValueTest.class);

    //session/{session id}/element/{element id}/rect
    @Test
    public void getRect() {
        driver.get("https://ya.ru/");
        WebElement searchButton = driver.findElement(By.cssSelector("button"));

        Rectangle rectangle = searchButton.getRect();
        logger.info("Button rectangle: {}", rectangle);
    }

    @Test
    public void comparing() {
        driver.get("https://ya.ru/");
        WebElement srchBtn = driver.findElement(By.cssSelector("button"));

        Point location = srchBtn.getLocation();
        Dimension dimension = srchBtn.getSize();
        Rectangle rectangle = srchBtn.getRect();

        assertThat(rectangle.getX(), equalTo(location.getX()));
        assertThat(rectangle.getY(), equalTo(location.getY()));

        assertThat(rectangle.getHeight(), equalTo(200));
        assertThat(rectangle.getWidth(), equalTo(dimension.getWidth()));

        assertThat(rectangle.getPoint(), equalTo(location));
        assertThat(rectangle.getDimension(), equalTo(dimension));

        logger.warn("I can't see info for getLocation and getSize methods in W3C doc. So..?");
    }
}

