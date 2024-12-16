package org.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a text, which is a collection of sentences.
 */
class Text {
    private List<Sentence> sentences;

    /**
     * Constructs a Text from the specified string.
     *
     * @param text The string to parse into a Text.
     */
    public Text(String text) {
        this.sentences = new ArrayList<>();
        parseText(text);
    }

    /**
     * Parses the input string into sentences.
     *
     * @param text The string to parse.
     */
    private void parseText(String text) {
        text = text.replaceAll("[\t\s]+", " "); // Normalize spaces
        String[] sentenceStrings = text.split("(?<=[.!?])");
        for (String sentence : sentenceStrings) {
            if (!sentence.isBlank()) {
                sentences.add(new Sentence(sentence.trim()));
            }
        }
    }

    /**
     * Retrieves all sentences in the text.
     *
     * @return A list of Sentence objects in the text.
     */
    public List<Sentence> getSentences() {
        return sentences;
    }

    /**
     * Retrieves the text as a string.
     *
     * @return The string representation of the text.
     */
    public String getText() {
        StringBuilder text = new StringBuilder();
        for (Sentence sentence : sentences) {
            text.append(sentence.getSentence()).append(" ");
        }
        return text.toString().trim();
    }
}

