package com.otus.api.step4.api;

import com.otus.api.step4.AppConfig;
import com.otus.api.step4.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsMapWithSize.aMapWithSize;
import static org.hamcrest.collection.IsMapWithSize.anEmptyMap;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class LoginTest {

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;


    @Autowired
    private UserService user;

    @Test
    public void authorizedUserCanGetRepo() {
        Map<String, String> cookies = user.login(userLogin, userPass);
        assertThat(cookies, aMapWithSize(3));
    }

    @Test
    public void badLoginHasAMessage() {
        Map<String, String> cookies = user.login(userLogin, userPass + "fail");
        assertThat(cookies, anEmptyMap());
    }
}
