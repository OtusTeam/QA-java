package com.otus.selenium.lesson7;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestPrompt {
    @Test
    public void testAlert() throws Exception {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("unexpectedAlertBehaviour", "accept");
        ChromeDriver driver = new ChromeDriver(capabilities);
        driver.get("https://htmlweb.ru/java/js1.php");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.cssSelector("code"));
        Alert confirm = driver.switchTo().alert();
        confirm.dismiss();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Hello");
        driver.quit();

    }
}