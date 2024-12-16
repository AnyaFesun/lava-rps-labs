package org.example;

import java.util.Scanner;

public class InputValidator {
    /**
     * Prompts the user to enter non-empty text and validates the input.
     *
     * @return a valid non-empty string entered by the user
     */
    public static String getFilledText() {
        Scanner scanner = new Scanner(System.in);
        String inputText;
        while (true) {
            try {
                System.out.println("Enter text:");
                inputText = scanner.nextLine();

                if (inputText == null || inputText.trim().isEmpty()) {
                    throw new IllegalArgumentException("You have not entered any text! Try again:");
                }
                return inputText;
            } catch (IllegalArgumentException e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }
}
