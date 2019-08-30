package com.otus.selenium.lesson7;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.net.URL;

public class TestRemoteDriver {

    @Test
    public void testAlert() throws Exception {

        System.setProperty("webdriver.chrome.driver","C:/Tools/grid/hub/chromedriver.exe");
        ChromeOptions cap = new ChromeOptions();
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.1.173:4444/wd/hub/"), cap);

        driver.get("https://htmlweb.ru/java/js1.php");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.cssSelector("code"));
        driver.quit();


    }
}
