package selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

public class ClickTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ClickTest.class);
    private static final String NOTE_CLICK = "The Element Click command scrolls into view the element if it is not already pointer-interactable,\n" +
            "    and clicks its in-view center point.\n" +
            "    If the element’s center point is obscured by another element, an element click intercepted error is returned.\n" +
            "    If the element is outside the viewport, an element not interactable error is returned.";

    ///session/{session id}/element/{element id}/click
    @Test
    public void click() {
        driver.get("https://habr.com/ru/");
        driver.findElement(By.cssSelector(".footer")).click();
        logger.info("Q. Where are we? Why?");
        logger.warn(NOTE_CLICK);
    }
}
