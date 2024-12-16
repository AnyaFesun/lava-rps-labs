package org.example;

/**
 * A class representing instant coffee in sachets.
 */
class InstantCoffeePackets extends Coffee {
    private int packetCount;

    /**
     * Constructor for creating instant coffee in sachets.
     *
     * @param name Name of coffee.
     * @param price Price of coffee per kg.
     * @param weight Weight of coffee with packaging.
     * @param quality Quality of coffee.
     * @param packetCount Number of sachets in the package.
     */
    public InstantCoffeePackets(String name, double price, double weight, double quality, int packetCount) {
        super(name, price, weight, quality);
        if (packetCount <= 0) {
            throw new IllegalArgumentException("The number of bags must be greater than zero.");
        }
        this.packetCount = packetCount;
    }

    /**
     * Returns the number of bags in the package.
     *
     * @return Number of bags.
     */
    public int getPacketCount() {
        return packetCount;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(", Packet Count: %d", packetCount);
    }
}