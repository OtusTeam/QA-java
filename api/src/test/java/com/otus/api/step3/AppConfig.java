package com.otus.api.step3;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.otus.api.step3"})
@PropertySource({"api.properties", "common.properties"})
public class AppConfig {
}