package selenium.pageobject.pages.atinfo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import selenium.pageobject.pages.atinfo.blocks.HeaderBlock;
import selenium.pageobject.pages.atinfo.blocks.TopicList;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class MainPage extends Page {
    private final Verifier verifier = new Verifier();

    private final static By menuButton = By.cssSelector("#toggle-hamburger-menu");
    private final static By searchButton = By.cssSelector("#search-button");
    private final static By searchTerm = By.cssSelector("input.search.search-query");

    private final HeaderBlock headerBlock;

    public MainPage(WebDriver driver) {
        super(driver);
        headerBlock = new HeaderBlock(driver);
    }

    public HeaderBlock getHeader() {
        return headerBlock;
    }

    public WebElement getMenuButton() {
        return driver.findElement(menuButton);
    }

    public WebElement getSearchButton() {
        return driver.findElement(searchButton);
    }

    public WebElement getSearchInput() {
        return driver.findElement(searchTerm);
    }

    public TopicList getTopics() {
        return PageFactory.initElements(driver, TopicList.class);
    }

    public Verifier getVerifier() {
        return verifier;
    }

    public List<WebElement> getTopicsAsWE() {
        return driver.findElements(By.cssSelector("tr.topic-list-item"));
    }

    public class Verifier {
        public void verifyLoginButtonDisplayed() {
            assertTrue(headerBlock.getLoginButton().isDisplayed());
        }
    }


}
