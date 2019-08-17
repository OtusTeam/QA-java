package com.otus.cucumber.lesson1.model;

public class User {
    private final int id;
    private final String login;
    private final Tech tech;

    public User(int id, String login, int techId, String techName) {
        this.id = id;
        this.login = login;
        this.tech = new Tech(techId, techName);
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public Tech getTech() {
        return tech;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", tech=" + tech +
                '}';
    }
}
