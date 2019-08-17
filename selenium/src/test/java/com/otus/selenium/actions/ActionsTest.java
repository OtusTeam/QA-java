package com.otus.selenium.actions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


public class ActionsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ActionsTest.class);

    @Test
    public void move() {
        driver.get("https://www.ozon.ru/");
        WebElement myozon = driver.findElement(By.cssSelector(".my-ozon-menu"));

        action.moveToElement(myozon).perform();

        String content = driver.findElement(By.cssSelector(".m-usermenu")).getText();
        logger.info(content);
    }

    @Test
    public void draw() {
        driver.get("http://www.htmlcanvasstudio.com/");

        WebElement canvas = driver.findElement(By.cssSelector("#imageTemp"));

        Actions beforeBuild = action
                .clickAndHold(canvas)
                .moveByOffset(100, 100)
                .moveByOffset(-50, -10)
                .release();

        beforeBuild.perform();
     }

    @Test
    public void contextMenu() {
        driver.get("http://swimlane.github.io/ngx-datatable/#contextmenu");

        WebElement row = driver.findElement(By.cssSelector("datatable-row-wrapper"));
        String firstCellText = row.findElement(By.cssSelector("datatable-body-cell")).getText();

        action
                .contextClick(row)
                .build()
                .perform();

        String infoText = driver.findElements(By.cssSelector("contextmenu-demo .info p")).get(2).getText();

        assertThat(infoText, containsString(firstCellText));
    }

    @Test
    public void dnd() {
        driver.get("https://professorweb.ru/my/javascript/jquery/level4/files/test29.html");


        WebElement dragMe = driver.findElement(By.cssSelector("div.draggable.ui-state-error.ui-draggable"));
        WebElement snapper = driver.findElement(By.cssSelector("#snapper"));


        action
                .dragAndDropBy(dragMe, 0, 250)
                .pause(2000)
                .dragAndDropBy(dragMe, 0, -150)
                .pause(2000)
                .tick()
                .dragAndDrop(dragMe, snapper)
                .build()
                .perform();


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 5000)");

    }
}
