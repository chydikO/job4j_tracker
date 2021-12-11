package ru.job4j.tracker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (Item item: items) {
            if (item.getId() == id) {
                rsl = items.indexOf(item);
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        boolean result = false;
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items.set(index, item);
            result = true;
        }
        return result;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            items.remove(index);
            return true;
        }
        return false;
    }

     public Item[] findAll() {
         ArrayList<Item> itemsList = new ArrayList<>();
         for (Item item: items) {
             if (item != null && item.getName() != null) {
                 itemsList.add(item);
             }
         }
         return itemsList.toArray(new Item[0]);
    }

     public Item[] findByName(String key) {
        ArrayList<Item> itemsList = new ArrayList<>();
         for (Item item: items) {
             if (key.equals(item.getName())) {
                 itemsList.add(item);
             }
         }
         return itemsList.toArray(new Item[0]);
     }
}