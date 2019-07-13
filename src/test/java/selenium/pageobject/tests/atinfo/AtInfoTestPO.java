package selenium.pageobject.tests.atinfo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageobject.pages.atinfo.MainPage;
import selenium.pageobject.pages.atinfo.TopicPage;
import selenium.pageobject.pages.atinfo.blocks.LoginBlock;
import selenium.pageobject.pages.atinfo.blocks.MenuBlock;

import java.util.List;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class AtInfoTestPO extends BaseTest {
    private MainPage mainPage;
    private LoginBlock loginBlock;
    private MenuBlock menuBlock;
    private TopicPage topicPage;

    @Before
    public void setUpTests() {
        driver.get(ATINFO_URL);
        mainPage = new MainPage(driver);
        loginBlock = new LoginBlock(driver);
        menuBlock = new MenuBlock(driver);
        topicPage = new TopicPage(driver);
    }

    @Test
    public void loginButtonShouldBePresent() {
        WebElement buttons = mainPage.getHeader().getLoginButton();
        assertTrue(buttons.isDisplayed());
    }

    @Test
    public void loginButtonOpensLoginForm() {
        mainPage.getHeader().getLoginButton();
        String title = loginBlock.getHeader().getText();
        assertThat(title, equalTo("Войти"));
    }

    @Test
    public void iCanOpenGroupsList() {
        mainPage.getMenuButton().click();
        new WebDriverWait(driver, 10L).until(ExpectedConditions.elementToBeClickable(menuBlock.getGroupsLink()));
        menuBlock.getGroupsLink().click();
        assertThat(driver.getCurrentUrl(), endsWith("/groups"));
    }

    @Test
    public void iCanOpenTopicPage() {
        List<WebElement> topics = mainPage.getTopicsAsWE();
        String titleInList = topics.get(3).findElement(By.cssSelector("a.title")).getText();
        topics.get(3).click();
        String titleOnPage = topicPage.getTopicTitle().getText();
        assertThat(titleOnPage, equalTo(titleInList));
    }

    @Test
    public void searchButtonOpensInput() {
        mainPage.getSearchButton().click();
        new WebDriverWait(driver, 10L).until(driver -> mainPage.getSearchInput());

        boolean visible = mainPage.getSearchInput().isDisplayed();
        boolean enabled = mainPage.getSearchInput().isEnabled();
        assertTrue(visible);
        assertTrue(enabled);
    }
}
