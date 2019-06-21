package selenium.configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ManageTest extends BaseTest {
    private static final Logger logger = LogManager.getLogger(ManageTest.class);

    @Test
    public void windowSize() {
        driver = new ChromeDriver();
        logger.info(driver.manage().window().getSize());
        driver.manage().window().setSize(new Dimension(700, 700));

        //window.outerWidth
        //window.outerHeight
    }

    @Test
    public void windowPosition() {
        driver = new ChromeDriver();
        logger.info(driver.manage().window().getPosition());
        driver.manage().window().setPosition(new Point(700, 700));

        //window.screenX
        //window.screenY
    }

    @Test
    public void maximize() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
    }


    @Test
    public void minimize() {
        driver = new ChromeDriver();
//        driver.manage().window().minimize();
        logger.warn("The Minimize Window command invokes the window manager-specific “minimize” operation, if any, on the window containing the current top-level browsing context. This typically hides the window in the system tray.");
    }

    @Test
    public void timeouts() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }
}
