package com.otus.selenium.lesson7;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.WebDriver;
import java.net.URL;

public class TestAlert {

    @Test
    public void testAlert() throws Exception {

        DesiredCapabilities capability = DesiredCapabilities.chrome();
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capability);

        driver.get("https://htmlweb.ru/java/js1.php");
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
        driver.findElement(By.cssSelector("code"));
        driver.quit();

// либо alert.dismiss();
    }
}

/*
public void unhide(WebDriver driver, WebElement element) {
  String script = "arguments[0].style.opacity=1;"
    + "arguments[0].style['transform']='translate(0px, 0px) scale(1)';"
    + "arguments[0].style['MozTransform']='translate(0px, 0px) scale(1)';"
    + "arguments[0].style['WebkitTransform']='translate(0px, 0px) scale(1)';"
    + "arguments[0].style['msTransform']='translate(0px, 0px) scale(1)';"
    + "arguments[0].style['OTransform']='translate(0px, 0px) scale(1)';"
    + "return true;";
  ((JavascriptExecutor) driver).executeScript(script, element);
}

public void attachFile(WebDriver driver, By locator, String file) {
  WebElement input = driver.findElement(locator);
  unhide(driver, input);
  input.sendKeys(file);
}
 */