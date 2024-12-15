package org.example;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
    /**
     * @summary
     * StudentVariant - 24
     * C11 = 2
     *
     * Визначити клас літак, який складається як мінімум з 5-и полів.
     */
    public static void main(String[] args) {
        Airplane[] airplanes = initializeAirplanes();
        displayAirplanes(airplanes, "Before sorting: ");

        sortAirplanes(airplanes);
        displayAirplanes(airplanes, "After sorting: ");

        Airplane searchTarget = new Airplane("Boeing 737", 2010, 35.8, 70500, 215);
        searchAirplane(airplanes, searchTarget);
    }

    /**
     * Initializes and returns an array of Airplane objects.
     *
     * @return an array of predefined Airplane objects
     */
    private static Airplane[] initializeAirplanes() {
        return new Airplane[]{
                new Airplane("Boeing 747", 1998, 59.6, 183500, 416),
                new Airplane("Airbus A320", 2015, 35.8, 73500, 180),
                new Airplane("Cessna 172", 2000, 11.0, 767, 4),
                new Airplane("Boeing 737", 2010, 35.8, 70500, 215),
                new Airplane("Antonov An-225", 1988, 88.4, 285000, 640)
        };
    }

    /**
     * Sorts the array of airplanes by wingspan (ascending) and capacity (descending).
     *
     * @param airplanes the array of Airplane objects to sort
     */
    private static void sortAirplanes(Airplane[] airplanes) {
        Arrays.sort(airplanes, Comparator
                .comparingDouble(Airplane::getWingspan)
                .thenComparing(Comparator.comparingInt(Airplane::getCapacity).reversed()));
    }

    /**
     * Displays the details of each airplane in the array.
     *
     * @param airplanes the array of Airplane objects to display
     * @param message text displayed before the Airplane array
     */
    private static void displayAirplanes(Airplane[] airplanes, String message) {
        System.out.println(message);
        for (Airplane airplane : airplanes) {
            System.out.println(airplane);
        }
    }

    /**
     * Searches for a specified airplane in the array and prints the result.
     *
     * @param airplanes   the array of Airplane objects to search in
     * @param searchTarget the Airplane object to search for
     */
    private static void searchAirplane(Airplane[] airplanes, Airplane searchTarget) {
        boolean found = false;
        for (Airplane airplane : airplanes) {
            if (airplane.equals(searchTarget)) {
                System.out.println("\nFound the target airplane: " + airplane);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("\nThe target airplane was not found in the array.");
        }
    }

}