package com.otus.api.step3.service;

import com.otus.api.step3.model.SearchResult;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

import static io.restassured.RestAssured.given;

@Service
public class SearchService {
    @Value("${basepath.hub}")
    private String hubUri;

    private Map<String, String> cookies;

    public void withCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    public SearchResult searchImage(String searchTerm , String type) {
        RestAssured.baseURI = hubUri;

        return given().log().everything()
                .cookies(cookies)
                .contentType(ContentType.JSON)
                .basePath("products")
                .queryParam("q", searchTerm)
                .queryParam("type", type)
                .when().get("search")
                .then().log().everything()
                .extract().as(SearchResult.class);
    }

    public SearchResult searchPlugin(String searchTerm, String type, String category) {
        RestAssured.baseURI = hubUri;
        return given().log().everything()
                .cookies(cookies)
                .basePath("products")
                .contentType(ContentType.JSON)
                .queryParam("category", category)
                .queryParam("type", type)
                .queryParam("q", searchTerm)
                .when().get("search")
                .then().log().everything()
                .extract().as(SearchResult.class);
    }
}
