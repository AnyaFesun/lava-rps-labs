package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a sentence, which is a collection of words and punctuation marks.
 */
class Sentence {
    private List<Word> words;
    private List<PunctuationMark> punctuationMarks;

    /**
     * Constructs a Sentence from the specified string.
     *
     * @param sentence The string to parse into a Sentence.
     */
    public Sentence(String sentence) {
        this.words = new ArrayList<>();
        this.punctuationMarks = new ArrayList<>();
        parseSentence(sentence);
    }

    /**
     * Parses the input string into words and punctuation marks.
     *
     * @param sentence The string to parse.
     */
    private void parseSentence(String sentence) {
        String[] tokens = sentence.split("(?=[,.!?;])|\s+");
        for (String token : tokens) {
            if (token.matches("[,.!?;:()]")) {
                punctuationMarks.add(new PunctuationMark(token.charAt(0))); // Punctuation
            } else if (!token.isBlank()) {
                words.add(new Word(token)); // Word
            }
        }
    }

    /**
     * Retrieves all words in the sentence.
     *
     * @return A list of Word objects in the sentence.
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * Retrieves all punctuation marks in the sentence.
     *
     * @return A list of PunctuationMark objects in the sentence.
     */
    public List<PunctuationMark> getPunctuationMarks() {
        return punctuationMarks;
    }

    /**
     * Retrieves the sentence as a string.
     *
     * @return The string representation of the sentence.
     */
    public String getSentence() {
        StringBuilder sentence = new StringBuilder();
        Iterator<Word> wordIterator = words.iterator();
        Iterator<PunctuationMark> punctuationIterator = punctuationMarks.iterator();

        while (wordIterator.hasNext()) {
            sentence.append(wordIterator.next().getWord());
            if (punctuationIterator.hasNext()) {
                sentence.append(punctuationIterator.next().getMark());
            }
            if (wordIterator.hasNext()) {
                sentence.append(" ");
            }
        }

        return sentence.toString().trim();
    }
}