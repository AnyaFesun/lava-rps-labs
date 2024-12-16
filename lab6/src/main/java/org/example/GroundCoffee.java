package org.example;

/**
 * A class representing ground coffee.
 */
class GroundCoffee extends Coffee {
    /**
     * Constructor to create a ground coffee object.
     *
     * @param name Name of coffee.
     * @param price Price of coffee per kg.
     * @param weight Weight of coffee.
     * @param quality Quality of coffee.
     */
    public GroundCoffee(String name, double price, double weight, double quality) {
        super(name, price, weight, quality);
    }
}