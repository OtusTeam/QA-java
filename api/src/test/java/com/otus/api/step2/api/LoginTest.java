package com.otus.api.step2.api;

import com.otus.api.step2.AppConfig;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class LoginTest {
    @Value("${basepath.login}")
    private String basePath;

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;

    @Before
    public void setUpBasePath() {
        RestAssured.baseURI = basePath;
    }


    @Test
    public void authorizedUserCanGetRepo() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"password\":\"" + userPass + "\",\"username\":\"" + userLogin + "\"}")
                .when().post("user/login")
                .then();
    }

    @Test
    public void badLoginHasAMessage() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"password\":\"failed_" + userPass + "\",\"username\":\"" + userLogin + "\"}")
                .when().post("user/login")
                .then().statusCode(401)
                .and().body("detail", equalTo("Incorrect authentication credentials."))
                .and().cookies(Collections.<String, Object>emptyMap());
    }
}
