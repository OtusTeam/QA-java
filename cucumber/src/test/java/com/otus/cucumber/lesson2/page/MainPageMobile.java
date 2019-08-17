package com.otus.cucumber.lesson2.page;

import com.otus.cucumber.lesson2.service.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;

@Component
public class MainPageMobile implements MainPage {

    @Value("${habr.url}")
    private String url;

    @Autowired
    @Qualifier("ff")
    private WebDriver driver;

    public MainPageMobile() {

    }

    public void open() {
        driver.get(url);
    }

    public String openPost(int i) {
        List<WebElement> posts =
                driver.findElements(By.cssSelector("article.tm-article>h2>a"));
        WebElement post = posts.get(i);
        String title = post.getText();

        post.click();
        return title;

    }

    public void verify(String postTitle) {
        assertThat(driver.getTitle(), startsWith(postTitle));
        assertThat(driver.getCurrentUrl(), startsWith(url));
    }


    public WebElement getPost(int i) {
        return driver.findElements(By.cssSelector("article.tm-article>h2>a")).get(i);
    }

}
