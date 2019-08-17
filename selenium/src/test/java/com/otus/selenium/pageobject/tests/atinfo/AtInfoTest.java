package com.otus.selenium.pageobject.tests.atinfo;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class AtInfoTest extends BaseTest {

    @Before
    public void setUpTests() {
        driver.get(ATINFO_URL);
    }

    @Test
    public void checkSignUpButtonIsPresent() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".sign-up-button"));
        assertThat(buttons.size(), equalTo(1));
    }

    @Test
    public void loginButtonShouldBePresent() {
        List<WebElement> buttons = driver.findElements(By.cssSelector(".login-button"));
        assertThat(buttons.size(), equalTo(1));
    }

    @Test
    public void loginButtonOpensLoginForm() {
        driver.findElement(By.cssSelector(".login-button")).click();
        boolean visible = driver.findElement(By.cssSelector("#login-buttons")).isDisplayed();
        assertTrue(visible);
    }

    @Test
    public void iCanOpenGroupsList() {
        driver.findElement(By.cssSelector("#toggle-hamburger-menu")).click();
        new WebDriverWait(driver, 10L).until(driver -> driver.findElement(By.cssSelector("a[href='/groups']"))).click();
        assertThat(driver.getCurrentUrl(), endsWith("/groups"));
    }

    @Test
    public void iCanOpenTopicPage() {
        List<WebElement> topics = driver.findElements(By.cssSelector("tr.topic-list-item"));
        String titleInList = topics.get(3).findElement(By.cssSelector("a.title")).getText();
        topics.get(3).click();
        String titleOnPage = driver.findElement(By.cssSelector("a.fancy-title")).getText();
        assertThat(titleOnPage, equalTo(titleInList));
    }

    @Test
    public void searchButtonOpensInput() {
        By searchInput = By.cssSelector("input.search.search-query");

        driver.findElement(By.cssSelector("#search-button")).click();
        new WebDriverWait(driver, 10L).until(driver -> driver.findElement(searchInput));

        boolean visible = driver.findElement(searchInput).isDisplayed();
        boolean enabled = driver.findElement(searchInput).isEnabled();
        assertTrue(visible);
        assertTrue(enabled);
    }
}
