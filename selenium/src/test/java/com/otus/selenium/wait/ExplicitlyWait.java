package com.otus.selenium.wait;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExplicitlyWait extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ExplicitlyWait.class);

    @Test
    public void explicit() {
        driver.get("https://www.aviasales.ru/search/MOW0109LED1");

        WebDriverWait wait = new WebDriverWait(driver, 10L);


        wait
                .ignoring(ElementClickInterceptedException.class)
                .pollingEvery(Duration.ofMillis(200))
                .withTimeout(Duration.ofSeconds(15))
                .withMessage("Not found ¯\\_(ツ)_/¯")
                .until(drv -> drv.findElements(By.cssSelector(".fade-enter-done")).size() > 10);
    }

    @Test
    public void conditions() {
        By locator = By.cssSelector("");
        WebElement element = driver.findElement(locator);

        ExpectedConditions.visibilityOfAllElementsLocatedBy(locator);
        ExpectedConditions.stalenessOf(element);
        ExpectedConditions.invisibilityOfElementLocated(locator);
        ExpectedConditions.elementToBeClickable(element);
        ExpectedConditions.elementSelectionStateToBe(element, true);
        ExpectedConditions.alertIsPresent();

    }

    private Alert acceptAlert(Alert alert) {
        alert.accept();
        return alert;
    }


    @Test
    public void windowHandlers() {
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&fg=1#?modal_active=none");
        driver.findElement(By.cssSelector("a.button.cta-main")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> handles = driver.getWindowHandles();
        List<String> tabs = new ArrayList<>(handles);
        tabs.forEach(logger::info);

        String currentTab = driver.getWindowHandle();
        logger.info("Current tab: {}", currentTab);
        tabs.remove(currentTab);
        String anotherTab = tabs.get(0);
        logger.info("Another: {}", anotherTab);
        logger.info("Switch");
        driver.switchTo().window(anotherTab);
        logger.info("Current: {}", driver.getWindowHandle());
    }
}
