package org.example;

import java.util.List;

public class Main {
    /**
     * @summary
     * StudentVariant - 24
     * C13 = 11
     *
     * Завантажити фургон певного обсягу вантажем на певну суму з різних
     * сортів кави, що можуть перебувати у різних фізичних станах (зерно,
     * мелена, розчинна в банках і пакетиках). Ураховувати обсяг кави разом
     * з упаковкою. Провести сортування товарів на основі співвідношення
     * ціни й ваги. Знайти товар у фургоні, що відповідає заданому діапазону
     * якості кави.
     */
    public static void main(String[] args) {
        try {
            Truck truck = new Truck(100.0);
            truck.loadCoffee(new CoffeeBeans("Ethiopia", 20.0, 10.0, 85.0));
            truck.loadCoffee(new GroundCoffee("Brazil", 15.0, 8.0, 90.0));
            truck.loadCoffee(new InstantCoffeeCans("Colombia", 10.0, 5.0, 75.0, 2.55));
            truck.loadCoffee(new InstantCoffeePackets("Spain", 12.0, 3.0, 60.0, 20));

            System.out.println("Contents of the van to be sorted:");
            truck.printCargo();

            truck.sortCargoByPriceToWeightRatio();
            System.out.println("\nContents of the van after sorting (price-weight ratio):");
            truck.printCargo();

            double minQuality = 80.0;
            double maxQuality = 90.0;
            List<Coffee> highQualityCoffee = truck.findCoffeeByQualityRange(minQuality, maxQuality);
            System.out.println("\nCoffee in the specified quality range from " + minQuality + " to " + maxQuality);
            for (Coffee coffee : highQualityCoffee) {
                System.out.println(coffee);
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}