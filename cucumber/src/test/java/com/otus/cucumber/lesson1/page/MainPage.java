package com.otus.cucumber.lesson1.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class MainPage {
    private final Map<String, WebElement> buttons = new HashMap<>();

    @Autowired
    private WebDriver driver;

    @Autowired
    private LoginBlock loginBlock;

    @Autowired
    private Environment env;

    @FindBy(css = "tr.topic-list-item")
    private List<WebElement> topicList;

    @FindBy(css = ".btn-primary.btn-small.login-button")
    private WebElement loginButton;

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
        buttons.put("войти", loginButton);
    }

    public void open() {
        String url = env.getProperty("sut.url");
        driver.get(url);
    }

    public void openTopic(int i) {
        topicList.get(i).findElement(By.cssSelector("a")).click();
    }

    public void click(String buttonName) {
        buttons.get(buttonName.toLowerCase()).click();
    }

    public LoginBlock getLoginBlock() {
        return loginBlock;
    }
}
