package com.otus.cucumber.lesson2.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.context.annotation.*;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("com.otus.cucumber.lesson2")
@PropertySource("classpath:config/lesson2/config/habr-web.properties")
@Profile("web")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class BeanConfigWeb {

    public BeanConfigWeb() {
        System.out.println("mobile");
    }

    @Bean()
    public WebDriver driverServiceChrome() {
        WebDriverManager.firefoxdriver().setup();
        return new ChromeDriver();
    }

}
