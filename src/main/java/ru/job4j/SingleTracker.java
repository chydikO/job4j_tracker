package ru.job4j;

import ru.job4j.tracker.Tracker;

public final class SingleTracker {
    private final static Tracker tracker = new Tracker();

    private SingleTracker() {

    }

    public static Tracker getTracker() {
        return tracker;
    }
}