# Laboratory work 6

## Variant
**C2**: Variant 0: List

**C3**: Variant 0: An array with an initial number of elements of 15 and an increase 
in the number of elements by 30%

## Description
The project demonstrates managing a collection of objects representing different types
of coffee. The collection implements the List interface and is based on an array with
an initial number of elements of 15. The array increases its capacity by 30% when the
limit is reached. The project includes implementing operations for adding, removing, 
sorting, and searching objects in the collection. The main focus is on working with 
generic types and creating a custom collection.

## Instructions for starting
1. Clone repository:
   ```bash
   git clone https://github.com/AnyaFesun/lava-rps-labs.git
2. Go to the folder:
    ```bash
   cd path/to/lava-rps-labs/lab6/src/main/java
3. Compile the program:
    ```bash
   javac org/example/Main.java
4. Run the program:
    ```bash
    java org.example.Main

## Using the program
In the main class Main you can change the values of the following parameters:
1. Add different types of coffee
   ```bash
   coffeeCollection.add(new CoffeeBeans("Ethiopia", 20.0, 10.0, 85.0));
   coffeeCollection.add(new GroundCoffee("Brazil", 15.0, 8.0, 90.0));
   coffeeCollection.add(new InstantCoffeeCans("Colombia", 10.0, 5.0, 75.0, 2.55));
   coffeeCollection.add(new InstantCoffeePackets("Spain", 12.0, 3.0, 60.0, 20));
2. Choose which elements to highlight by index
   ```bash
    coffeeCollection.remove(0);
3.  You can change the quality range for searching for products
   ```bash
   double minQuality = 80.0;
   double maxQuality = 90.0;