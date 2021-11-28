package ru.job4j.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Вам нужно будет преобразовать список с массивом чисел в список чисел.
 * Метод convert должен пройтись по всем элементам всех массивов в списке list и добавить их в список rsl.
 * Массивы в списке list могут быть разного размера.
 */
public class ConvertList {
        public static List<Integer> convert(List<int[]> list) {
            List<Integer> rsl = new ArrayList<>();
            for (int[] row : list) {
                for (int col: row) {
                    rsl.add(col);
                }
            }
            return rsl;
        }
}
