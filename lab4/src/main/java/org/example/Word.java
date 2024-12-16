package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a word, which is a collection of letters.
 */
class Word {
    private List<Letter> letters;

    /**
     * Constructs a Word from the specified string.
     *
     * @param word The string to convert into a Word.
     */
    public Word(String word) {
        this.letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            if (Character.isLetter(c)) {
                this.letters.add(new Letter(c));
            }
        }
    }

    /**
     * Retrieves the word as a string.
     *
     * @return The string representation of the word.
     */
    public String getWord() {
        StringBuilder word = new StringBuilder();
        for (Letter letter : letters) {
            word.append(letter.getCharacter());
        }
        return word.toString();
    }

    /**
     * Retrieves the second character of the word.
     *
     * @return The second character, or '\0' if the word has fewer than two letters.
     */
    public char getSecondCharacter() {
        return letters.size() > 1 ? letters.get(1).getCharacter() : '\0';
    }
}