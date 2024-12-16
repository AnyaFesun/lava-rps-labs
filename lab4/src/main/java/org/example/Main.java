package org.example;

public class Main {
    /**
     * @summary
     * StudentVariant - 24
     * C17 = 7
     *
     * Відсортувати слова заданого тексту, що починаються з голосних літер, за другою літерою.
     */
    public static void main(String[] args) {
        String inputText = InputValidator.getFilledText();
        Text text = new Text(inputText);

        TextProcessor processor = new TextProcessor();
        String result = processor.processText(text);

        System.out.println("Sort result: " + result);
    }
}
