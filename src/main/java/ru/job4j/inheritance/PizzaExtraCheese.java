package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    @Override
    public String name() {
        return super.name() + " + Extra Cheese";
    }
}
