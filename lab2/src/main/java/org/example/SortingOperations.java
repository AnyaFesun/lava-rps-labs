package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingOperations {
    /**
     * The main text processing method.
     *
     * @param text Text to process (StringBuilder).
     * @return Processed text as a string.
     */
    public static String processText(StringBuilder text) {
        List<StringBuilder> vowelWords = extractVowelWords(text);
        sortWordsBySecondLetter(vowelWords);
        return joinWords(vowelWords);
    }

    /**
     * Selects words that start with vowels.
     *
     * @param text Text to process (StringBuilder).
     * @return List of vowel-starting words as StringBuilder.
     */
    private static List<StringBuilder> extractVowelWords(StringBuilder text) {
        String vowels = "AEIOUaeiou";
        List<StringBuilder> vowelWords = new ArrayList<>();
        StringBuilder currentWord = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);

            if (Character.isWhitespace(c)) {
                if (currentWord.length() > 0 && vowels.indexOf(currentWord.charAt(0)) != -1) {
                    vowelWords.add(new StringBuilder(currentWord));
                }
                currentWord.setLength(0);
            } else {
                currentWord.append(c);
            }
        }
        if (currentWord.length() > 0 && vowels.indexOf(currentWord.charAt(0)) != -1) {
            vowelWords.add(new StringBuilder(currentWord));
        }

        return vowelWords;
    }

    /**
     * Sorts a list of words by the second letter.
     *
     * @param words List of words to sort.
     */
    private static void sortWordsBySecondLetter(List<StringBuilder> words) {
        words.sort(new Comparator<StringBuilder>() {
            @Override
            public int compare(StringBuilder word1, StringBuilder word2) {
                char secondChar1 = word1.length() > 1 ? word1.charAt(1) : '\0';
                char secondChar2 = word2.length() > 1 ? word2.charAt(1) : '\0';
                return Character.compare(secondChar1, secondChar2);
            }
        });
    }

    /**
     * Joins a list of words into a string.
     *
     * @param words List of words as StringBuilder.
     * @return Joined string.
     */
    private static String joinWords(List<StringBuilder> words) {
        StringBuilder result = new StringBuilder();

        for (StringBuilder word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(word);
        }

        return result.toString();
    }
}
