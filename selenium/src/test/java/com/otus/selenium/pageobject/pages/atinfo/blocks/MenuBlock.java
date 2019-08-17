package com.otus.selenium.pageobject.pages.atinfo.blocks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.otus.selenium.pageobject.pages.atinfo.Page;

public class MenuBlock extends Page {
    @FindBy(css = "a[href='/groups']")
    private WebElement groupsLink;

    public MenuBlock(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getGroupsLink() {
        return groupsLink;
    }

}
