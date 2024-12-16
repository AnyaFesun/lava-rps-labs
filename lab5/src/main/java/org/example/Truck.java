package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Class describing the management of loading a coffee van.
 */
class Truck {
    private double capacity;
    private List<Coffee> cargo;

    /**
     * Constructor for creating a van object.
     *
     * @param capacity Maximum capacity of the van (kg).
     */
    public Truck(double capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("The volume of the van must be greater than zero.");
        }
        this.capacity = capacity;
        this.cargo = new ArrayList<>();
    }

    /**
     * Returns the maximum volume of the van.
     *
     * @return The volume of the van.
     */
    public double getCapacity() {
        return capacity;
    }

    /**
     * Returns a list of items in the van.
     *
     * @return List of items.
     */
    public List<Coffee> getCargo() {
        return cargo;
    }

    /**
     * Load coffee into the van.
     *
     * @param coffee The coffee object to load.
     * @throws IllegalStateException If the van is overloaded.
     */
    public void loadCoffee(Coffee coffee) {
        double currentWeight = cargo.stream().mapToDouble(Coffee::getWeight).sum();
        if (currentWeight + coffee.getWeight() > capacity) {
            throw new IllegalStateException("The van is overloaded.");
        }
        cargo.add(coffee);
    }

    /**
     * Sorting cargo in a van by price/weight ratio (in descending order).
     */
    public void sortCargoByPriceToWeightRatio() {
        Collections.sort(cargo, Comparator.comparingDouble(Coffee::getPriceToWeightRatio).reversed());
    }

    /**
     * Search for products in the van that match the given quality range.
     *
     * @param minQuality Minimum quality value.
     * @param maxQuality Maximum quality value.
     * @return List of products that match the quality range.
     * @throws IllegalArgumentException If the quality range is invalid.
     */
    public List<Coffee> findCoffeeByQualityRange(double minQuality, double maxQuality) {
        if (minQuality < 0 || maxQuality > 100 || minQuality > maxQuality) {
            throw new IllegalArgumentException("Incorrect quality range.");
        }
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : cargo) {
            if (coffee.getQuality() >= minQuality && coffee.getQuality() <= maxQuality) {
                result.add(coffee);
            }
        }
        return result;
    }

    /**
     * Display the contents of the van on the screen.
     */
    public void printCargo() {
        for (Coffee coffee : cargo) {
            System.out.println(coffee);
        }
    }
}
