package selenium.pageobject.pages.atinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private final WebDriver driver;

    By loginButton = By.cssSelector(".login-button");
    By menuButton = By.cssSelector("#toggle-hamburger-menu");
    By topicList = By.cssSelector("tr.topic-list-item");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
}
