package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("gucodauzinnau-5540@yopmail.com ", "Кузнецов Даниэль Сергеевич");
        hashMap.put("veuppeifiddeifrau-9642@yopmail.com ", "Кудрявцев Иван Александрович");
        hashMap.put("frannazotretra-9119@yopmail.com ", "Зубова Валерия Никитична");

        for (Map.Entry<String, String> entry: hashMap.entrySet()) {
            String key = entry.getKey();
            System.out.println("e-mail: " + key + " Name: " + hashMap.get(key));
        }
    }
}
