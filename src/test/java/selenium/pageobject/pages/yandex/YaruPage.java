package selenium.pageobject.pages.yandex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YaruPage {

    private WebDriver driver;
    private static final Logger logger = LogManager.getLogger(YaruPage.class);

    public YaruPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://ya.ru");

        if (!"Яндекс".equals(driver.getTitle())) {
            throw new IllegalStateException("This is not ya.ru page");
        }
    }

    private By goButton = By.xpath("//button[@type='submit']");
    private By searchField = By.cssSelector("#text");

    public YaruPage enterQuery(String query) {
        driver.findElement(searchField).sendKeys(query);
        logger.info("Searching: {}", query);
        return this;
    }

    public YaResultsPage clickSearch() {
        driver.findElement(goButton).click();
        logger.info("URL: {}", driver.getCurrentUrl());
        return new YaResultsPage(driver);
    }

    public YaResultsPage search(String query) {
        enterQuery(query);
        clickSearch();
        return new YaResultsPage(driver);
    }

}
