package selenium.interaction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.By;

public class ClearTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ClearTest.class);

    public static void main(String[] args) {
        logger.error("err");
    }

    ///session/{session id}/element/{element id}/clear
    @Test
    public void clear() {
        driver.get("https://account.habr.com/login/");
        driver.findElement(By.cssSelector("#email_field")).sendKeys("test@otus.ru");
        driver.findElement(By.cssSelector("#email_field")).clear();
    }
}

