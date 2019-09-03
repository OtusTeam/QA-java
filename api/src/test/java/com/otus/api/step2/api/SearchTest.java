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
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.text.IsEmptyString.emptyString;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class SearchTest {

    @Value("${basepath.hub}")
    private String hubUri;

    @Value("${basepath.login}")
    private String loginUri;

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.pass}")
    private String userPass;


    @Before
    public void setUp() {
        RestAssured.baseURI = hubUri;
    }


    @Test
    public void asAuthorizedUserICanSearchImages() {
        Map<String, String> cookies = logIn(userLogin, userPass);

        given().log().everything()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .basePath("products")
                .queryParam("q", "log")
                .queryParam("type", "image")
                .when().get("search")
                .then().log().everything()
                .statusCode(200)
                .and().body("next", emptyString())
                .and().body("count", is(8))
                .and().body("summaries.size()", is(8));
    }

    @Test
    public void asAuthorizedUserICanSearchPlugins() {
        Map<String, String> cookies = logIn(userLogin, userPass);

        given().log().everything()
                .cookies(cookies)
                .basePath("products")
                .contentType(ContentType.JSON)
                .queryParam("category", "logging")
                .queryParam("type", "plugin")
                .queryParam("q", "log")
                .when().get("search")
                .then().log().everything()
                .statusCode(200)
                .and().body("count", is(3))
                .and().body("summaries.size()", is(3));
    }

    private Map<String, String> logIn(String userLogin, String userPass) {
        return given()
                .baseUri(loginUri)
                .basePath("user/login")
                .log().everything()
                .contentType(ContentType.JSON)
                .body("{\"password\":\"" + userPass + "\",\"username\":\"" + userLogin + "\"}")
                .when().post()
                .then().statusCode(200).extract().cookies();
    }
}
