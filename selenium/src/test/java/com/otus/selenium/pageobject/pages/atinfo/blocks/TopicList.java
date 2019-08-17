package com.otus.selenium.pageobject.pages.atinfo.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.otus.selenium.pageobject.pages.atinfo.Page;

import java.util.List;

public class TopicList extends Page {

    @FindBy(css = "tr.topic-list-item")
    private List<WebElement> topicList;


    public TopicList(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public Topic get(int index) {
        WebElement topic = topicList.get(index);
        return new Topic(topic, driver);
    }
}
