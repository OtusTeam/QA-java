package selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GetTagNameTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(GetTagNameTest.class);

    //session/{session id}/element/{element id}/name
    @Test
    public void getTagName() {
        driver.get("https://ya.ru/");
        WebElement searchButton = driver.findElement(By.cssSelector("button"));
        logger.info("Tag: {}", searchButton.getTagName());
        logger.warn("Not the value of the name attribute: will return 'input' for the element <input name='foo'/>");
    }
}

