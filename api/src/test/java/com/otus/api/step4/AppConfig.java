package com.otus.api.step4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.otus.api.step4"})
@PropertySource({"api.properties", "common.properties", "ui.properties"})
public class AppConfig {
}