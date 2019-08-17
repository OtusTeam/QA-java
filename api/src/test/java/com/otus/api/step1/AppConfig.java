package com.otus.api.step1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = {"com.otus.api.step1"})
@PropertySource({"ui.properties", "common.properties"})
public class AppConfig {
}