package ru.com.otus.config;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.annotation.DirtiesContext;
import ru.com.otus.service.DriverService;

@Configuration
@ComponentScan("ru.com.otus")
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
