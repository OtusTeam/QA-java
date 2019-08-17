package com.otus.api.step2.api;

import com.otus.api.step2.AppConfig;
import com.otus.api.step2.model.LoginReq;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class RepositoriesTest {

    @Value("${basepath.repository}")
    private String hubUri;

    @Value("${basepath.login}")
    private String loginUri;

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;

    @Value("${user.nickname}")
    private String userName;


    @Before
    public void setUp() {
        RestAssured.baseURI = hubUri;
        RestAssured.basePath = "repositories";
    }


    @Test
    public void asAuthorizedUserICanGetRepositories() {
        Map<String, String> cookies = logIn(userLogin, userPass);

        given().log().everything()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .queryParam("page", 1)
                .queryParam("ordering", "last_updated")
                .pathParam("name", userName)
                .when().get("{name}")
                .then().log().everything()
                .statusCode(200)
                .and().body("count", is(9))
                .and().body("summaries.size()", is(9));
    }

    private Map<String, String> logIn(String userLogin, String userPass) {
        return given().baseUri(loginUri).basePath("user/login")
                .contentType(ContentType.JSON)
                .body(new LoginReq(userLogin, userPass))
                .when().post()
                .then().statusCode(200).extract().cookies();
    }
}
