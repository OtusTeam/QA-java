package com.otus.cucumber.lesson1.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TopicPage {
    @Autowired
    private WebDriver driver;

    @FindBy(css = "#topic-title a.fancy-title")
    private WebElement topicTitle;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public String getTopicTitle() {
        return topicTitle.getText();
    }
}
