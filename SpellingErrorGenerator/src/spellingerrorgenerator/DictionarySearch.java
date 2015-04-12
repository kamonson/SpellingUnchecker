/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spellingerrorgenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kamonson17
 */
public class DictionarySearch {

    DictionarySearch() {
    }

    public boolean isWord(String input) throws IOException {
        Pattern regexp = Pattern.compile("(?i)" + input);
        Matcher matcher = regexp.matcher(input);
        Path path = Paths.get("src/wordList.txt");
        BufferedReader read = Files.newBufferedReader(path);
        LineNumberReader readLine = new LineNumberReader(read);
        String line = null;
        while ((line = readLine.readLine()) != null) {
            matcher.reset(line);
            if (matcher.find()) {
                return true;
            }
        }
        return false;
    }
}
