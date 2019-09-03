package com.otus.cucumber.lesson2.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("com.otus.cucumber.lesson2")
@PropertySource("classpath:config/lesson2/config/habr-mobile.properties")
@Profile("mobile")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class BeanConfigMobile {

    public BeanConfigMobile() {
        System.out.println("mobile");
    }

    @Bean(value = "ff")
    public WebDriver driverServiceFF() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


    @Bean(value = "chrome")
    public WebDriver driverServiceChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

}
