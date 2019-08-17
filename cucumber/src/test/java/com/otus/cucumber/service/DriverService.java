package com.otus.cucumber.service;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class DriverService {
    private static final Logger logger = LogManager.getLogger(DriverService.class);

    private final WebDriver driver = new ChromeDriver();

    static {
        WebDriverManager.chromedriver().setup();
    }

    public WebDriver initDriver() {
        driver.manage().timeouts().implicitlyWait(4L, TimeUnit.SECONDS);
        ((HasCapabilities) driver).getCapabilities().asMap().entrySet().forEach(logger::debug);
        return driver;
    }
}
