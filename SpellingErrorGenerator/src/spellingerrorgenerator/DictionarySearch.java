/**
 * wordList compiled from http://scrabblehelper.googlecode.com/svn-history/r20/trunk/ScrabbleHelper/src/dictionaries/sowpods.txt
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
 * --this can be removed out if it is not desired: removing will speed up program
 * but as it is not a large program I chose to use it--
 * Opens a wordList of English words and checks if the passed in word is real --by
 * the standards of this list-- if it is return true if not return false the boolean
 * returned tells the StringManager what to do with the word
 * @author kamonson
 */
public class DictionarySearch {
/**
 * empty no-arg constructor for object creation only
 */
    DictionarySearch() {
    }
    /**
     * Check word list to verify that the word entered is in fact a real word
     * @param input word passed from StringManager
     * @return boolean true if it is a word boolean false if it is not
     * @throws IOException when errors in i/o occur
     */
    public boolean isWord(String input) throws IOException {
        Pattern regexp = Pattern.compile("(?i)" + input);//ignore case for checking
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
