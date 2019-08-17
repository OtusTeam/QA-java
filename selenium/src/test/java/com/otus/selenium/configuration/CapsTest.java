package com.otus.selenium.configuration;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class CapsTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CapsTest.class);

    //https://w3c.github.io/webdriver/#capabilities

    @Test
    public void capsChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addExtensions(new File("C:\\Program Files (x86)\\Google\\CHROME\\Application\\74.0.3729.169\\default_apps\\youtube.crx"));
        options.addArguments("start-maximized");
//
//      bookmarks, history, settings, extensions, and more – in a profile
        options.addArguments("user-data-dir=/path/to/your/custom/profile");
        options.setHeadless(false);
        options.setPageLoadStrategy(PageLoadStrategy.NONE);

        driver = new ChromeDriver(options);

        Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
        logger.info(capabilities);

        driver.get("https://ya.ru");
    }

    @Test
    public void capsFirefox() {
        WebDriverManager.firefoxdriver().setup();

        FirefoxOptions options = new FirefoxOptions();
        options.setHeadless(true);

        driver = new FirefoxDriver(options);

        Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
        logger.info(capabilities);

        driver.get("https://ya.ru");
        logger.warn("About caps: https://firefox-source-docs.mozilla.org/testing/geckodriver/Capabilities.html");
    }

    @Test
    public void capsEdge() {
        WebDriverManager.edgedriver().setup();

        logger.error("io.github.bonigarcia.wdm.WebDriverManagerException: io.github.bonigarcia.wdm.WebDriverManagerException");
        logger.warn("Check https://github.com/bonigarcia/webdrivermanager/issues/308");

        EdgeOptions options = new EdgeOptions();
        options.setCapability("ms:startPage", "https://otus.ru");

        driver = new EdgeDriver(options);

        Capabilities capabilities = ((HasCapabilities) driver).getCapabilities();
        logger.info(capabilities);

        driver.get("https://ya.ru");
        logger.warn("About caps: https://docs.microsoft.com/en-us/microsoft-edge/webdriver");
    }
}
