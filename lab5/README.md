# Laboratory work 1

## Variant
**C13**: Variant 11: Load a van of a certain volume with a certain amount of cargo from
different varieties of coffee, which can be in different physical states (grain, ground,
instant in cans and bags). Take into account the volume of coffee together with the
packaging. Sort the goods based on the ratio of price and weight. Find the goods in the
van that correspond to the given range of coffee quality.

## Description
This project implements a system to manage the loading of different types of coffee
into a van, taking into account their volume, weight, price, and quality. The user 
can add coffee to the van, sort it by price-to-weight ratio, and search for products 
within a given quality range.

## Instructions for starting
1. Clone repository:
   ```bash
   git clone https://github.com/AnyaFesun/lava-rps-labs.git
2. Go to the folder:
    ```bash
   cd path/to/lava-rps-labs/lab5/src/main/java
3. Compile the program:
    ```bash
   javac org/example/Main.java
4. Run the program:
    ```bash
    java org.example.Main

## Using the program
In the main class Main you can change the values of the following parameters:
1. Change the volume of the van
   ```bash
   Truck truck = new Truck(100.0);
2. Add different types of coffee
   ```bash
   truck.loadCoffee(new CoffeeBeans("Ethiopia", 20.0, 10.0, 85.0));
   truck.loadCoffee(new GroundCoffee("Brazil", 15.0, 8.0, 90.0));
   truck.loadCoffee(new InstantCoffeeCans("Colombia", 10.0, 5.0, 75.0, 2.55));
   truck.loadCoffee(new InstantCoffeePackets("Spain", 12.0, 3.0, 60.0, 20));
3.  You can change the quality range for searching for products
   ```bash
   double minQuality = 80.0;
   double maxQuality = 90.0;