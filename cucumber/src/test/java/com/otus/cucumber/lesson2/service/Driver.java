package com.otus.cucumber.lesson2.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    static {
        WebDriverManager.chromedriver().setup();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        }
        return driver;
    }


    public static void clearDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
