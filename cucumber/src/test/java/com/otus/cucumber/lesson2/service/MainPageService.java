package com.otus.cucumber.lesson2.service;

import com.otus.cucumber.lesson2.page.MainPage;
import com.otus.cucumber.lesson2.page.MainPageMobile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class MainPageService {
    @Autowired
    private MainPageMobile page;

    @Autowired
    private Environment environment;


    public void openPage() {
        page.open();
    }

    public String openPost(int i) {
        return page.openPost(i);
    }

    public void verify(String postTitle) {
        page.verify(postTitle);
    }
}
