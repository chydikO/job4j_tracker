package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;

public class ItemAscByNameTest {
    @Test
    public void compare() {
        Item item1 = new Item(1, "Connect printer to computer");
        Item item2 = new Item(2, "A Mouse problem");
        Item item3 = new Item(3, "Reboot server");

        List<Item> items = new ArrayList<>(List.of(item1, item2, item3));
        List<Item> expected = new ArrayList<>(List.of(item2, item1, item3));

        Collections.sort(items, new ItemAscByName());
        assertTrue(items.containsAll(expected));
    }
}