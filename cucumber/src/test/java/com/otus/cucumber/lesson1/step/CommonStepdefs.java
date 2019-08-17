package com.otus.cucumber.lesson1.step;


import com.otus.cucumber.lesson1.config.Config;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Config.class)
public class CommonStepdefs {
    @Before
    public void before() {
    }

    @After
    public void after() {
    }
}
