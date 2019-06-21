package selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandlingTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(WindowHandlingTest.class);

    @Test
    public void getWindowHandle() {
        driver = new ChromeDriver();
        driver.get("https://angular.io/");

        String handle = driver.getWindowHandle();
        logger.info("Current window: {}", handle);
    }

    @Test
    public void windowHandlers() {
        driver = new ChromeDriver();
        driver.get("https://www.google.co.uk/services/?subid=ww-ww-et-g-awa-a-g_hpbfoot1_1!o2&fg=1#?modal_active=none");
        driver.findElement(By.cssSelector("a.button.cta-main")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(drvr -> drvr.getWindowHandles().size() > 1);

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
