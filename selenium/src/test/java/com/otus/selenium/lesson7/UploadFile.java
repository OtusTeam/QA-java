package com.otus.selenium.lesson7;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {


    @Test
    public void testUpload() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://codepen.io/rcass/pen/MmYwEp");

        driver.switchTo().frame(driver.findElement(By.id("result")));
        driver.findElement(By.cssSelector("input"));
    }

}
