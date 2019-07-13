package selenium.pageobject.pages.atinfo.blocks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import selenium.pageobject.pages.atinfo.Page;

public class HeaderBlock extends Page {

    private final static By loginButton = By.cssSelector(".login-button");

    public HeaderBlock(WebDriver driver) {
        super(driver);
    }

    public WebElement getLoginButton(){
        return driver.findElement(loginButton);
    }


}
