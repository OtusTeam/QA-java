package com.otus.selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class CookieTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CookieTest.class);

    @Test
    public void getCookies() {
        createDriver();
        openTestLink();
        loginAs("user", "bitnami");

        Set<Cookie> cookies = driver.manage().getCookies();
        cookies.forEach(logger::info);
        driver.quit();

        openAsAuth(cookies);
    }

    private void openAsAuth(Set<Cookie> cookies) {
        createDriver();
        openTestLink();

        driver.manage().getCookies().forEach(logger::info);
        driver.manage().deleteAllCookies();

        cookies.forEach(cookie -> driver.manage().addCookie(cookie));

        openTestLink();
    }

    private void createDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private void openTestLink() {
        driver.get("http://localhost:80");
        logger.info("Title: {}", driver.getTitle());
    }

    private void loginAs(String user, String pass) {
        logger.info("Login with credentials {}:{}", user, pass);
        driver.findElement(By.cssSelector("#tl_login")).sendKeys(user);
        driver.findElement(By.cssSelector("#tl_password")).sendKeys(pass);
        driver.findElement(By.cssSelector("#login")).submit();
    }
}
