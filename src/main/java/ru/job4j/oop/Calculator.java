package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int multiply(int a) {
        return x * a;
    }

    public static int minus(int y) {
        return x - y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(multiply(y) + minus(y) + new Calculator().divide(y));
    }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);

        int rsl = multiply(5);
        System.out.println(rsl);

        rsl = minus(3);
        System.out.println(rsl);

        rsl = new Calculator().divide(2);
        System.out.println(rsl);

        rsl = new Calculator().sumAllOperation(5);
        System.out.println(rsl);
    }
}
