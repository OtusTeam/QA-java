package com.otus.cucumber.lesson1.model;

public class Tech {
    private final int id;
    private final String name;

    public Tech(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
