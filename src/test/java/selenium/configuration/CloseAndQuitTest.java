package selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class CloseAndQuitTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(CloseAndQuitTest.class);

    @Test
    public void close() {
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&fg=1#?modal_active=none");
        driver.findElement(By.cssSelector("a.button.cta-main")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(drvr -> drvr.getWindowHandles().size() > 1);

        Set<String> handles = driver.getWindowHandles();
        logger.info("Total tabs: {}", handles.size());
        String tab = driver.getWindowHandle();
        logger.info("Current tab: {}", tab);

        driver.close();

        handles.remove(tab);
        driver.switchTo().window(handles.iterator().next());
        logger.info("Current tab: {}", driver.getWindowHandle());

        logger.warn("Close only current tab");
        logger.warn("Need to change handle manually");
    }

    @Test
    public void quit() {
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&fg=1#?modal_active=none");
        driver.findElement(By.cssSelector("a.button.cta-main")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(drvr -> drvr.getWindowHandles().size() > 1);

        Set<String> handles = driver.getWindowHandles();
        logger.info("Total tabs: {}", handles.size());
        String tab = driver.getWindowHandle();
        logger.info("Current tab: {}", tab);

        driver.quit();

        try {
            logger.info(driver.getWindowHandle());
        } catch (Exception ex) {
            logger.error(ex);
        }
    }
}
