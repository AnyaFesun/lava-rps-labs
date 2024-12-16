package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Processes the text using custom logic.
 */
class TextProcessor {

    /**
     * Processes the text to extract and sort words starting with vowels.
     *
     * @param text The Text object to process.
     * @return The processed text as a string.
     */
    public String processText(Text text) {
        List<Word> vowelWords = new ArrayList<>();
        for (Sentence sentence : text.getSentences()) {
            for (Word word : sentence.getWords()) {
                if (isVowel(word.getWord().charAt(0))) {
                    vowelWords.add(word);
                }
            }
        }

        vowelWords.sort(Comparator.comparing(Word::getSecondCharacter));

        StringBuilder result = new StringBuilder();
        for (Word word : vowelWords) {
            result.append(word.getWord()).append(" ");
        }

        return result.toString().trim();
    }

    /**
     * Determines if a character is a vowel.
     *
     * @param c The character to check.
     * @return True if the character is a vowel, false otherwise.
     */
    private boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
