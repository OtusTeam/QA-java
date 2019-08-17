package com.otus.cucumber.config;

import com.otus.cucumber.service.DriverService;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;

@Configuration
@ComponentScan("com.otus.cucumber")
@PropertySource("classpath:app.properties")
@DirtiesContext(methodMode = DirtiesContext.MethodMode.AFTER_METHOD)
public class Config {
    @Autowired
    private DriverService service;

    @Bean
    public WebDriver getDriver() {
        return service.initDriver();
    }

}
