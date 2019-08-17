package com.otus.cucumber.step;

import com.otus.cucumber.config.Config;
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
