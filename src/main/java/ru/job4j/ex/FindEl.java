package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        /* цикл fori, поскольку нам надо найти индекс искомого элемента в массиве */
        for (int i = 0; i < value.length; i++) {
            if (key.equals(value[i])) {
                rsl = i;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("index of '" + key + "' not found");
        }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            System.out.println(indexOf(new String[]{"1", "4", "q", "5"}, "p"));
        } catch (ElementNotFoundException e) {
            System.out.println(e.toString());
        }
    }
}
