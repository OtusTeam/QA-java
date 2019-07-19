package ru.com.otus.step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.test.context.ContextConfiguration;
import ru.com.otus.config.Config;

@ContextConfiguration(classes = Config.class)
public class CommonStepdefs {


    @Before
    public void before() {

    }

    @After
    public void after() {
    }
}
