package org.example;

/**
 * A class representing coffee beans.
 */
class CoffeeBeans extends Coffee {
    /**
     * Constructor to create a coffee bean object.
     *
     * @param name Name of coffee.
     * @param price Price of coffee per kg.
     * @param weight Weight of coffee.
     * @param quality Quality of coffee.
     */
    public CoffeeBeans(String name, double price, double weight, double quality) {
        super(name, price, weight, quality);
    }
}