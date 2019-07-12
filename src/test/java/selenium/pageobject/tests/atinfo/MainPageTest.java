package selenium.pageobject.tests.atinfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pageobject.pages.yandex.YaruPage;
import selenium.pageobject.tests.BaseTest;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class MainPageTest extends BaseTest {

    private static final Logger logger = LogManager.getLogger(YaruPage.class);

    @Before
    public void setUpTests(){
        driver.get(ATINFO_URL);
    }

    @Test
    public void loginButtonShouldBePresent() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".login-button"));
        assertThat(buttons.size(), equalTo(1));
    }

    @Test
    public void loginButtonOpensLoginForm(){
        driver.findElement(By.cssSelector(".login-button")).click();
        boolean visible = driver.findElement(By.cssSelector("#login-buttons")).isDisplayed();
        assertTrue(visible);
    }

    @Test
    public void iCanOpenTagsList(){
        driver.findElement(By.cssSelector("#toggle-hamburger-menu")).click();
        By tagsLink = By.cssSelector("a[href='/tags']");
        new WebDriverWait(driver, 10L).until(driver -> driver.findElement(tagsLink)).click();
        boolean visible = driver.findElement(By.cssSelector(".tag-list")).isDisplayed();
        assertTrue(visible);
    }

    @Test
    public void iCanOpenTopicPage(){
        List<WebElement> topics = driver.findElements(By.cssSelector("tr.topic-list-item"));
        String titleInList = topics.get(3).findElement(By.cssSelector("a.title")).getText();
        topics.get(3).click();
        String titleOnPage = driver.findElement(By.cssSelector("a.fancy-title")).getText();
        assertThat(titleOnPage, equalTo(titleInList));
    }
}
