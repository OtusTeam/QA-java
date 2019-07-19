package ru.com.otus.model;

public class Tech {
    private int id;
    private String name;

    public Tech(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tech{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
