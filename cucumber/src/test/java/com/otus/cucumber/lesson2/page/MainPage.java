package com.otus.cucumber.lesson2.page;

public interface MainPage {
    void open();
    String openPost(int i);

    void verify(String postTitle);
}
