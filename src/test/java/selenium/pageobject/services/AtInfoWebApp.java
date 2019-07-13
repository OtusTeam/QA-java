package selenium.pageobject.services;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import selenium.pageobject.pages.atinfo.MainPage;
import selenium.pageobject.pages.atinfo.blocks.LoginBlock;
import selenium.pageobject.pages.atinfo.blocks.MenuBlock;
import selenium.pageobject.pages.atinfo.blocks.SearchBlock;
import selenium.pageobject.pages.atinfo.blocks.TopicList;

public class AtInfoWebApp {
    private final WebDriver driver;
    private final MainPage mainPage;

    public AtInfoWebApp(WebDriver driver) {
        this.driver = driver;
        mainPage = new MainPage(driver);
    }

    public MainPage.Verifier getVerifier() {
        return mainPage.getVerifier();
    }

    public LoginBlock openLoginMenu() {
//        mainPage.getLoginButton().click();
      return new LoginBlock(driver);
    }

    public MenuBlock openMenu() {
        mainPage.getMenuButton().click();
        return PageFactory.initElements(driver, MenuBlock.class);
    }

    public AtInfoWebApp open() {
        driver.get("https://automated-testing.info/");
        return this;
    }

    public TopicList getTopics() {
        return mainPage.getTopics();
    }

    public SearchBlock openSerachInput() {
        mainPage.getSearchButton().click();
        return new SearchBlock(driver);
    }
}
