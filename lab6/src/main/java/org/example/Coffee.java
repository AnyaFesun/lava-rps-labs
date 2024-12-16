package org.example;

/**
 * Abstract class that describes the general properties of coffee.
 */
abstract class Coffee {
    private String name;
    private double price;
    private double weight;
    private double quality;

    /**
     * Constructor for creating a coffee object.
     *
     * @param name Name of coffee.
     * @param price Price of coffee per kg.
     * @param weight Weight of coffee with packaging (kg).
     * @param quality Quality of coffee (0-100).
     */
    public Coffee(String name, double price, double weight, double quality) {
        if (price <= 0) {
            throw new IllegalArgumentException("The price of coffee must be greater than zero!");
        } else if (weight <= 0) {
            throw new IllegalArgumentException("The weight of the coffee must be greater than zero!");
        } else if (quality < 0 || quality > 100) {
            throw new IllegalArgumentException("Quality values must be between 0 and 100");
        }
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.quality = quality;
    }

    /**
     * Returns the name of the coffee.
     *
     * @return The name of the coffee.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of coffee per kg.
     *
     * @return Price of coffee.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the weight of the coffee with packaging.
     *
     * @return Weight of the coffee.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the coffee quality.
     *
     * @return Coffee quality (0-100).
     */
    public double getQuality() {
        return quality;
    }

    /**
     * Calculate the price-to-weight ratio.
     *
     * @return Price/weight ratio.
     */
    public double getPriceToWeightRatio() {
        return price / weight;
    }

    /**
     * Returns a text representation of a coffee object.
     *
     * @return A string containing information about the coffee: name, price, weight, and quality.
     */
    @Override
    public String toString() {
        return String.format("Coffee: %s, Price: %.2f, Weight: %.2f, Quality: %.1f", name, price, weight, quality);
    }
}