package selenium.screenshot;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Screenshot {

    private static final Logger logger = LogManager.getLogger(Screenshot.class);
    private WebDriver driver;

    @BeforeClass
    public static void setUpClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void tekeScreenshot() {
        driver.get("https://ya.ru");

        driver.findElement(By.cssSelector("#text")).sendKeys("base64");
        String base64 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        saveBase64(base64);

        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys("bytes");
        byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        saveBytes(bytes);

        driver.findElement(By.cssSelector("#text")).clear();
        driver.findElement(By.cssSelector("#text")).sendKeys("file");
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        saveFile(file);
    }

    private void saveBase64(String data) {
        File file = OutputType.FILE.convertFromBase64Png(data);
        saveFile(file);
    }

    private void saveBytes(byte[] data) {
        File file = OutputType.FILE.convertFromPngBytes(data);
        saveFile(file);
    }

    private void saveFile(File file) {
        String fileName = "target/" + System.currentTimeMillis() + ".png";
        try {
            FileUtils.copyFile(file, new File(fileName));
        } catch (IOException e) {
            logger.error(e);
        }
    }


    @Test
    public void elementShot() {
        driver.get("https://ya.ru");

        driver.findElement(By.cssSelector("#text")).sendKeys("element");
        File file = driver.findElement(By.cssSelector("#text")).getScreenshotAs(OutputType.FILE);
        saveFile(file);
    }
}
