package com.otus.cucumber.lesson1.config;

import com.otus.cucumber.lesson1.service.DriverInitService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("com.otus.cucumber.lesson1")
@PropertySource("classpath:config/lesson1/app.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class Config {
    @Autowired
    private DriverInitService service;

    @Bean
    public WebDriver getDriver() {
        return service.initDriver();
    }

}
