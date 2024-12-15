package org.example;
import java.util.Scanner;

public class Main {
    /**
     * @summary
     * StudentVariant - 24
     * C3 = 0 C17 = 7
     *
     * StringBuilder
     * Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.
     */
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String inputText = null;
            System.out.println("Enter text: ");
            inputText = scanner.nextLine();

            StringBuilder text = new StringBuilder(inputText);


            String result = SortingOperations.processText(text);
            System.out.println("Sort result: " + result);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}