/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellingerrorgenerator;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author kamonson17
 */
public class StringManager {

    DictionarySearch wordSearch;
    ArrayList<String> words;
    String output = null;
    DictionarySearch check;
    String[] sentence;
    String error;

    StringManager() {
        this.check = new DictionarySearch();
        this.words = new ArrayList<>();
        this.wordSearch = new DictionarySearch();
    }

    public String runUncheker(String input) throws IOException {
        sentence = input.split("[\\s]");
        for (int i = 0; i < sentence.length; i++) {
            words.add(sentence[i]);
            if (wordSearch.isWord(words.get(i))) {
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

    public String injectError(String input) {
        error = input;
        if (error == "meet") {
            error = "meat";
        } else if (error == "meat") {
            error = "meet";
        } else if (error == "a lot") {
            error = "alot";
        } else if (error == "lose") {
            error = "loose";
        } else if ("loose".equals(error)) {
            error = "lose";
        } else if (error == "weird") {
            error = "wiered";
        } else if (error == "wiered") {
            error = "weird";
        } else if (error == "their") {
            error = "they're";
            return error;
        } else if (error == "there") {
            error = "their";
        } else if (error == "they're") {
            error = "there";
        } else if (error == "your") {
            error = "weird";
        } else if (error == "it's") {
            error = "its";
        } else if (error == "its") {
            error = "it's";
        } else if (error == "affect") {
            error = "effect";
        } else if (error == "effect") {
            error = "affect";
        } else if (error == "weather") {
            error = "whether";
        } else if (error == "whether") {
            error = "weather";
        } else if (error == "then") {
            error = "than";
        } else if (error == "than") {
            error = "then";
        } else if (error.matches("(.*)o(.*)")) {
            error = error.replaceAll("o", "oo");
        } else if (error.matches("(.*)ie(.*)")) {
            error = error.replaceAll("ie", "ei");
        }
        if (error.matches("(.*)\\?(.*)")) {
            error = error.replaceAll("\\?", ".");
        }
        if (error.matches("(.*),(.*)")) {
            error = error.replaceAll(",", ".");
        }
        if (error.matches("(.*)\\.(.*)")) {
            error = error.replaceAll("(.*)(?<!Mr|Mrs|Dr|Ms)\\./", "?");
        }
        return error;
    }
}
