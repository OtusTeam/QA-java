package com.otus.selenium.pageobject.pages.atinfo.blocks;

import com.lazerycode.selenium.util.Query;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.otus.selenium.pageobject.pages.atinfo.Page;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoginBlock extends Page {

    private final static Query header = new Query().defaultLocator(By.cssSelector(".modal-header"));
    private final static Query loginButtons = new Query().defaultLocator(By.cssSelector("#login-buttons"));
    private final Verifier verifier = new Verifier();

    public LoginBlock(WebDriver driver) {
        super(driver);
        header.usingDriver((RemoteWebDriver) driver);
        loginButtons.usingDriver((RemoteWebDriver) driver);
    }

    public WebElement getHeader() {
        return header.findWebElement();
    }

    public WebElement getLoginButtons() {
        return loginButtons.findWebElement();
    }

    public Verifier getVerifier() {
        return verifier;
    }

    public class Verifier {
        public void verifyHeaderTextIs(String textToBe) {
            String textAsIs = header.findWebElement().getText();
            assertThat(textAsIs, equalTo(textToBe));
        }
    }

}
