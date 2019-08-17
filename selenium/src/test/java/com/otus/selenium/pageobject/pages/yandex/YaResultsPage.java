package com.otus.selenium.pageobject.pages.yandex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YaResultsPage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(YaResultsPage.class);


    public YaResultsPage(WebDriver driver) {
        this.driver = driver;
        logger.info("URL: {}", driver.getCurrentUrl());
    }

    private By searchField =  By.xpath("//div[@class='search2__input']//input[@name='text']");
    private By serp = By.xpath("//div[@class='main__content']");
    private By first = By.xpath("//li[@class='serp-item'][1]");
    private By title = By.xpath("//div[@class='organic__url-text']");

    public String getFirstResultTitle() {
        WebElement serpEl = driver.findElement(serp);
        WebElement serpFirstEl = serpEl.findElement(first);
        WebElement serpFirstElTitle = serpFirstEl.findElement(title);
        return serpFirstElTitle.getText();
    }

}
