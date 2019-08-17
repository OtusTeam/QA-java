package com.otus.api.step3.service;

import com.otus.api.step3.model.LoginReq;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Service
public class UserService {
    @Value("${basepath.login}")
    private String basePath;

    private Map<String, String> cookies;

    public Map<String, String> getCookies(String userLogin, String userPass) {
        if (cookies == null) {
            cookies = login(userLogin, userPass);
        }
        return cookies;
    }

    public Map<String, String> login(String userLogin, String userPass) {
        RestAssured.baseURI = basePath;
        LoginReq req = new LoginReq(userLogin, userPass);
        cookies = given().contentType(ContentType.JSON)
                .body(req)
                .when().post("user/login")
                .then().extract().cookies();
        return cookies;
    }


}
