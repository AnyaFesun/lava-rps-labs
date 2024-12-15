package org.example;
import java.util.Objects;

/**
 * Represents an airplane with details such as model, year of production, wingspan, weight, and capacity.
 */
class Airplane {
    private final String model;
    private final int year;
    private final double wingspan;
    private final double weight;
    private final int capacity;

    /**
     * Constructs an Airplane object with the specified details.
     *
     * @param model    the model of the airplane
     * @param year     the year the airplane was manufactured
     * @param wingspan the wingspan of the airplane in meters
     * @param weight   the weight of the airplane in kilograms
     * @param capacity the passenger capacity of the airplane
     */
    public Airplane(String model, int year, double wingspan, double weight, int capacity) {
        this.model = model;
        this.year = year;
        this.wingspan = wingspan;
        this.weight = weight;
        this.capacity = capacity;
    }

    /**
     * Returns the model of the airplane.
     *
     * @return the airplane model
     */
    public String getModel() {
        return model;
    }

    /**
     * Returns the year the airplane was manufactured.
     *
     * @return the year of manufacture
     */
    public int getYear() {
        return year;
    }

    /**
     * Returns the wingspan of the airplane in meters.
     *
     * @return the wingspan
     */
    public double getWingspan() {
        return wingspan;
    }

    /**
     * Returns the weight of the airplane in kilograms.
     *
     * @return the weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the passenger capacity of the airplane.
     *
     * @return the passenger capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Generates a string representation of the airplane.
     *
     * @return a string representation of the airplane
     */
    @Override
    public String toString() {
        return "Airplane{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", wingspan=" + wingspan +
                ", weight=" + weight +
                ", capacity=" + capacity +
                '}';
    }

    /**
     * Checks if this airplane is equal to another object.
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Airplane airplane = (Airplane) obj;
        return year == airplane.year &&
                Double.compare(airplane.wingspan, wingspan) == 0 &&
                Double.compare(airplane.weight, weight) == 0 &&
                capacity == airplane.capacity &&
                Objects.equals(model, airplane.model);
    }
}
