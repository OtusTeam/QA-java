package com.otus.api.step3.service;

import com.otus.api.step3.model.Repositories;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Service
public class RepoService {
    @Value("${basepath.repository}")
    private String hubUri;

    private Map<String, String> cookies;

    public void withCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public Repositories getRepositories(String ordering, int page, String userName) {
        RestAssured.baseURI = hubUri;
        RestAssured.basePath = "repositories";

        return given().log().everything()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .queryParam("page", page)
                .queryParam("ordering", ordering)
                .pathParam("name", userName)
                .when().get("{name}")
                .then().log().everything()
                .extract().as(Repositories.class);
    }
}
