package org.example;

/**
 * Represents a single letter in the text.
 */
class Letter {
    private char character;

    /**
     * Constructs a Letter with the specified character.
     *
     * @param character The character to represent.
     */
    public Letter(char character) {
        this.character = character;
    }

    /**
     * Gets the character of the Letter.
     *
     * @return The character represented by this Letter.
     */
    public char getCharacter() {
        return character;
    }
}