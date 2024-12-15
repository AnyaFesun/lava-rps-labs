# Laboratory work 3

## Variant
**C11**: Variant 2: Define an aircraft class that consists of at least 5 fields

## Description
The program demonstrates sorting and searching for objects of the Airplane class. The program models information about airplanes (model, year of manufacture, wingspan, weight, passenger capacity) and performs:

1. Sorting airplanes by:
* Wingspan in ascending order.
* Passenger capacity in descending order (if wingspans are the same).
2. Searching for a given airplane in an array of objects by equality criteria..

## Instructions for starting
1. Clone repository:
   ```bash
   git clone https://github.com/AnyaFesun/lava-rps-labs.git
2. Go to the folder:
    ```bash
   cd path/to/lava-rps-labs/lab3/src/main/java
3. Compile the program:
    ```bash
   javac org/example/Main.java
4. Run the program:
    ```bash
    java org.example.Main
   
## Using the program
1. After running the program, it will output to the console
* initial list of Airplanes
* list of Airplanes after sorting
* search result for a given Airplane
2. You can add new Airplanes to the array:
   ```bash
   private static Airplane[] initializeAirplanes() {
        return new Airplane[]{
                new Airplane("Boeing 747", 1998, 59.6, 183500, 416),
                new Airplane("Airbus A320", 2015, 35.8, 73500, 180),
                new Airplane("Cessna 172", 2000, 11.0, 767, 4),
                new Airplane("Boeing 737", 2010, 35.8, 70500, 215),
                new Airplane("Antonov An-225", 1988, 88.4, 285000, 640)
        };
    }
3. You can also change the searched Airplane in the main method:
   ```bash
           Airplane searchTarget = new Airplane("Boeing 737", 2010, 35.8, 70500, 215);