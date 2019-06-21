package selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FindElementTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(FindElementTest.class);

    //session/{session id}/element/{element id}/element
    @Test
    public void findElements() {
        driver.get("https://www.google.com/search?source=hp&ei=QFkDXdu5POHFrgSDvZroAw&q=selenium&oq=seleniu&gs_l=psy-ab.3.0.0l10.1135.2750..4142...0.0..0.430.2527.2-1j5j1......0....1..gws-wiz.....0..0i131.f1AHtH5RWTc");
        WebElement searchContainer = driver.findElement(By.cssSelector("#search"));
        logger.info("WebElement extends SearchContext");
        logger.info("WebDriver -> Let start node be the current browsing context’s document element.");
        logger.info("WebElement -> Let start node be the result of trying to get a known connected element with url variable element id.");

        List<WebElement> results = searchContainer.findElements(By.cssSelector(".g"));
        logger.info("Count results: {}", results.size());
    }
}

