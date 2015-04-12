package spellingerrorgenerator;

import java.io.IOException;
import java.util.ArrayList;

/**
 * StringManager is the labor horse of the program Accepts strings breaks
 * sentence strings into a string array containing individual words which are
 * passed into an array list --I feel is easier to manage and can limit to a
 * single loop to increase efficacy-- checks each word against the dictionary
 * via DictionarySearch to ensure the word is a real word--very large word bank
 * can be removed if taxing, the logic is if it is already misspelled then no
 * errors need be introduced-- if the word does not exist check for an
 * apostrophe if one exists allow word to be error-o-fied. When errors have been
 * introduced repack into a string and send to main for printing
 *
 * @author kamonson
 */
public class StringManager {

    DictionarySearch wordSearch;
    ArrayList<String> words;
    String output = null;
    DictionarySearch check;
    String[] sentence;
    String error;
    int rand;

    /**
     * Constructor implements the Class objects to be used
     */
    StringManager() {
        this.check = new DictionarySearch();
        this.words = new ArrayList<>();
        this.wordSearch = new DictionarySearch();
    }

    /**
     * Break apart sentence length strings into individual words check against
     * dictionary if real add error if not check for apostrophe and add error if
     * none return word
     *
     * @param input string from main containing sentence
     * @return string with errors
     * @throws IOException if i/o problem occurs
     */
    public String runUncheker(String input) throws IOException {
        sentence = input.split("[\\s]");
        for (int i = 0; i < sentence.length; i++) {
            words.add(sentence[i]);
            if (wordSearch.isWord(words.get(i))) {
                words.set(i, this.injectError(words.get(i)));
            } else if (words.get(i).matches("(.*)\\p{Punct}(.*)")) {
                words.set(i, this.injectError(words.get(i)));
            }
            if (i >= 1) {
                output += (" " + words.get(i));
            } else {
                output = words.get(i);
            }

        }
        return output;
    }

    /**
     * Create errors: exchange common words and vowels to simulate common errors
     * Exchange punctuation to keep people on their toes, when a period is hit
     * ignore if not the end of a sentence, if it is the end of a sentence
     * randomly choose between adding a , ! or ? If a word has ' then move it or
     * remove it
     *
     * @param input word from ArrayList of words
     * @return word an error --if applicable-- or the word
     */
    public String injectError(String input) {
        error = input;
//Common Words
        if ("meet".equals(error)) {
            error = "meat";
        } else if ("a".equals(error)) {
            error = "an";
        } else if ("meat".equals(error)) {
            error = "meet";
        } else if ("a lot".equals(error)) {
            error = "alot";
        } else if ("lose".equals(error)) {
            error = "loose";
        } else if ("loose".equals(error)) {
            error = "lose";
        } else if ("weird".equals(error)) {
            error = "wiered";
        } else if ("wiered".equals(error)) {
            error = "weird";
        } else if ("their".equals(error)) {
            error = "they're";
            return error;
        } else if ("there".equals(error)) {
            error = "their";
        } else if ("they're".equals(error)) {
            error = "there";
        } else if ("your".equals(error)) {
            error = "weird";
        } else if ("it's".equals(error)) {
            error = "its";
        } else if ("its".equals(error)) {
            error = "it's";
        } else if ("affect".equals(error)) {
            error = "effect";
        } else if ("I".equals(error)) {
            error = "i";
        } else if ("effect".equals(error)) {
            error = "affect";
        } else if ("weather".equals(error)) {
            error = "whether";
        } else if ("whether".equals(error)) {
            error = "weather";
        } else if ("then".equals(error)) {
            error = "than";
        } else if ("than".equals(error)) {
            error = "then";
        } else if (error.matches("(.*)ou(.*)")) {
            error = error.replaceAll("ou", "uo");
        } else if (error.matches("(.*)ie(.*)")) {
            error = error.replaceAll("ie", "ei");
        } else if (error.matches("(.*)es(.*)")) {
            error = error.replaceAll("'es", "se");
        } else if (error.matches("(.*)ea(.*)")) {
            error = error.replaceAll("'ea", "ee");
        } else if (error.matches("(.*)or(.*)")) {
            error = error.replaceAll("or", "our");
        }
//Punctuation
        if (error.matches("(.*)!(.*)")) {
            error = error.replaceAll("!", ".");
        }
        if (error.matches("(.*)\\?(.*)")) {
            error = error.replaceAll("\\?", ".");
        } else if (error.contains(",")) {
            error = error.replaceAll(",", ".");
        } else if (error.matches("(.*)\\.(.*)")) {
            rand = 1 + (int) (Math.random() * 3);
            if (rand == 1) {
                error = error.replaceAll("(?<!\\..)(?<![A-Z].)[\\.\\?!](?!.\\.)", "?"); //crazy regex going on here: --if there is anything before the symbol or alpha . ignore-- if there is nothing after include the .--if there is anything after ignore .

            } else if (rand == 2) {
                error = error.replaceAll("(?<!\\..)(?<![A-Z].)[\\.\\?!](?!.\\.)", "!");
            } else {
                error = error.replaceAll("(?<!\\..)(?<![A-Z].)[\\.\\?!](?!.\\.)", ",");
            }
        }
//Apostrophe
        if (error.matches("(.*)'s(.*)")) {
            error = error.replaceAll("'s", "s");
        } else if (error.matches("(.*)s'(.*)")) {
            error = error.replaceAll("s", "'s");
        } else if (error.matches("(.*)'t(.*)")) {
            error = error.replaceAll("'t", "t");
        }
        return error;
    }
}
