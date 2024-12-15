package org.example;

import java.util.Scanner;

public class Validator {
    /**
     * Checks if a valid integer is entered
     *
     * @param scanner - input scanner
     * @param message - transmitted message
     * @return input result positive integer
     */
    public static int getValidInteger(Scanner scanner, String message) {
        System.out.print(message);
        while (true) {
            try {
                String input = scanner.nextLine();
                int value = Integer.parseInt(input);
                if (value <= 0) {
                    throw new IllegalArgumentException("The number must be positive!");
                }
                return value;
            } catch (NumberFormatException e) {
                System.err.println("Error: Enter a positive integer!");
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
