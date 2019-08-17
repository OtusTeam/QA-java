package com.otus.cucumber.lesson2.step;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import com.otus.cucumber.lesson2.config.BeanConfigMobile;
import com.otus.cucumber.lesson2.config.BeanConfigWeb;
import com.otus.cucumber.lesson2.service.Driver;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {BeanConfigWeb.class,BeanConfigMobile.class})
public class BasePageStepDefs {

    public BasePageStepDefs() {

    }

    @Before
    public void before() {
        System.out.println("test");
    }

    @After
    public void after() {
        Driver.clearDriver();
    }
}
