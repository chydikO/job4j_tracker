package ru.job4j.oop.io;

import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        int answer = random.nextInt(3);
        switch (answer) {
            case (0) -> System.out.println("Да");
            case (1) -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
    }
}
