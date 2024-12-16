package org.example;

/**
 * Represents a single punctuation mark.
 */
class PunctuationMark {
    private char mark;

    /**
     * Constructs a PunctuationMark with the specified mark.
     *
     * @param mark The punctuation mark character.
     */
    public PunctuationMark(char mark) {
        this.mark = mark;
    }

    /**
     * Gets the punctuation mark character.
     *
     * @return The punctuation mark character.
     */
    public char getMark() {
        return mark;
    }
}