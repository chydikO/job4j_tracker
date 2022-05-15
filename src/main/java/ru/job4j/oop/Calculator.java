package ru.job4j.oop;

public class Calculator {
    private static final int X = 5;

    public static int sum(int y) {
        return X + y;
    }

    public static int multiply(int a) {
        return X * a;
    }

    public static int minus(int y) {
        return y - X;
    }

    public int divide(int y) {
        return y / X;
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

        Calculator calculator = new Calculator();
        rsl = calculator.divide(2);
        System.out.println(rsl);

        rsl = calculator.sumAllOperation(5);
        System.out.println(rsl);
    }
}
