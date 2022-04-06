package ru.job4j.collection;

public class Task {
    private final String number;

    public Task(String number, String description) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }
}
