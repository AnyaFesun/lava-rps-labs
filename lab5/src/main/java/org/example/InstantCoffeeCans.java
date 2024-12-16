package org.example;

/**
 * A class representing instant coffee in cans.
 */
class InstantCoffeeCans extends Coffee {
    private double canVolume;

    /**
     * Constructor for creating instant coffee in cans.
     *
     * @param name Name of coffee.
     * @param price Price of coffee per kg.
     * @param weight Weight of coffee with packaging.
     * @param quality Quality of coffee.
     * @param canVolume Volume of can (l).
     */
    public InstantCoffeeCans(String name, double price, double weight, double quality, double canVolume) {
        super(name, price, weight, quality);
        if (canVolume <= 0) {
            throw new IllegalArgumentException("The volume of the jar must be greater than zero.");
        }
        this.canVolume = canVolume;
    }

    /**
     * Returns the volume of the can.
     *
     * @return Volume of the can (l).
     */
    public double getCanVolume() {
        return canVolume;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Can Volume: %.2f L", canVolume);
    }
}

