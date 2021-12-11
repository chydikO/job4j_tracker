package ru.job4j.collection;

import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        int count = 0;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String str: origin) {
            check.add(str);
        }
        for (String str: text) {
            boolean areEquals = check.contains(str);
            if (areEquals) {
                count++;
            }
        }
        if (count != check.size()) {
            rsl = false;
        }
        return rsl;
    }
}
