package com.otus.api.step5.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.otus.api.step5.model.LoginReq;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.openqa.selenium.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

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


    public void saveCookies(Set<Cookie> cookies) {
        try (Writer writer = new FileWriter("cookies.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(cookies, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Set<Cookie> getUiCookies() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("cookies.json")) {
            Type listType = new TypeToken<Set<Cookie>>() {
            }.getType();
            Set<Cookie> cookies = gson.fromJson(reader, listType);

            return cookies;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
