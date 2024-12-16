package org.example;

public class Main {
    /**
     * @summary
     * StudentVariant - 24
     * C2 = 0 C3 = 0
     *
     * List
     * Масив із початковою кількістю елементів 15 та збільшенням кількості елементів на 30%
     */
    public static void main(String[] args) {
        try {
            CoffeeCollection coffeeCollection = new CoffeeCollection();
            coffeeCollection.add(new CoffeeBeans("Ethiopia", 20.0, 10.0, 85.0));
            coffeeCollection.add(new GroundCoffee("Brazil", 15.0, 8.0, 90.0));
            coffeeCollection.add(new InstantCoffeeCans("Colombia", 10.0, 5.0, 75.0, 2.55));
            coffeeCollection.add(new InstantCoffeePackets("Spain", 12.0, 3.0, 60.0, 20));

            System.out.println("Initial Coffee Collection:");
            coffeeCollection.forEach(System.out::println);

            System.out.println("\nRemoving the first item from the collection...");
            coffeeCollection.remove(0);
            System.out.println("Updated Coffee Collection:");
            coffeeCollection.forEach(System.out::println);

            System.out.println("\nAdding a new coffee item...");
            coffeeCollection.add(new CoffeeBeans("Kenya", 25.0, 9.0, 88.0));
            System.out.println("Updated Coffee Collection:");
            coffeeCollection.forEach(System.out::println);

            double minQuality = 80.0;
            double maxQuality = 90.0;
            System.out.println("\nSearching for coffee in the quality range " + minQuality + " to " + maxQuality + ":");
            coffeeCollection.stream()
                    .filter(coffee -> coffee.getQuality() >= minQuality && coffee.getQuality() <= maxQuality)
                    .forEach(System.out::println);

            System.out.println("\nChecking coffee collection before sorting:");
            coffeeCollection.forEach(System.out::println);

            coffeeCollection.removeIf(java.util.Objects::isNull);
            System.out.println("\nSorting coffee collection by price-to-weight ratio...");
            coffeeCollection.sort((c1, c2) -> {
                if (c1 == null && c2 == null) return 0;
                if (c1 == null) return 1;
                if (c2 == null) return -1;
                return Double.compare(c2.getPriceToWeightRatio(), c1.getPriceToWeightRatio());
            });

            System.out.println("Sorted Coffee Collection:");
            coffeeCollection.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Error: " + e.getMessage());
        }
    }

}
