package selenium.pageobject.tests.yandex;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import selenium.interaction.BaseTest;
import static java.util.concurrent.TimeUnit.SECONDS;

public class YandexSearch extends BaseTest {

    private static final Logger logger = LogManager.getLogger(YandexSearch.class);

    @Test
    public void search() {
        driver.get("https://ya.ru");
        logger.info("URL: {}", driver.getCurrentUrl());

        driver.findElement(By.cssSelector("#text")).sendKeys("Otus");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(4, SECONDS);
        logger.info("URL: {}", driver.getCurrentUrl());

        WebElement serp = driver.findElement(By.xpath("//div[@class='main__content']"));
        WebElement first = serp.findElement(By.xpath("//li[@class='serp-item'][1]"));
        WebElement title = first.findElement(By.xpath("//div[@class='organic__url-text']"));
        logger.info("Item: {}", title.getText());

        Assert.assertEquals("OTUS - Онлайн-образование – Профессиональные курсы", title.getText());
    }

}
