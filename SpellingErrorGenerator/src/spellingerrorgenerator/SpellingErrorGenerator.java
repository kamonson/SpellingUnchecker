/*TASK:
 You're writing code for an English activity in which the computer takes a passage and introduces a few errors 
 for the player to find and correct. Select ONE of the following types of errors, and write an error generator as 
 a command-line application. The user should be able to input a sentence into the command line, and it will output 
 a version with at least one error introduced.
 
 •	Spelling Error Generator: Misspells a word in a single sentence. The misspelling needs to look like it could be handwritten human error. (Don't worry about checking if the misspelling generated is also a real word.)
 o	NOT ACCEPTABLE: I ride horses. → I ride hzress.
 o	ACCEPTABLE: I ride horses. → I ride hroses.
 o	ACCEPTABLE: I ride horses. → I ride horsses.
 o	ACCEPTABLE: I ride horses. → I ride hoarses.
 •	Punctuation Error Generator: Changes a sentence's punctuation. The error needs to look like it could be handwritten human error.
 o	NOT ACCEPTABLE: “How are you, Bob?” → “H?ow are you%”
 o	ACCEPTABLE: “How are you, Bob?” → “How, are you Bob?”
 o	ACCEPTABLE: “How are you, Bob?” → “How are you, Bob!”
 •	Contraction Errors: Introduces a contraction error into a sentence. The error needs to look like it originated from a human who misunderstood rules of contractions. You are welcome to limit this to the “its” vs “it's” type problem.
 o	NOT ACCEPTABLE: “The man sang.” → “The man sang's.”
 o	ACCEPTABLE: “The dog's bone.” → “The dogs bone.”
 o	ACCEPTABLE: “Yes, we sell bananas.” → “Yes, we sell banana's.”
 o	ACCEPTABLE: “Its not polite to stare.” → “It's not polite to stare.”*/
package spellingerrorgenerator;

import java.io.IOException;
import java.util.Scanner;

/**
 * Run Input through StringManager check a dictionary --included in package-- to
 * ensure that words are real words --not required but fun, if the word is
 * misspelled no need to scramble it-- if the word is common misspelled exchange
 * for the common if the word has simple exchange errors --ie to ei-- make the
 * switch if the word has punctuation exchange it --Mr., W.W. II, etc. ignored--
 * if the word has an apostrophe remove or move it. Liberal use of regex as I
 * like this method of search for flexibility, however I also included standard
 * string comparison as well --this is a show case after all.
 *
 * @author kamonson
 */
public class SpellingErrorGenerator {

    /**
     * Main contains the bare necessities create objects: Scanner and
     * StringManager User inputs a line via Scanner and Passes to StringManager
     * for adding errors StringManager creates and returns errors to be printed
     * out to user
     *
     * @param args the command line arguments --none used--
     * @throws java.io.IOException if i/o fails
     */
    public static void main(String[] args) throws IOException {
        String input = null;
        Scanner UserInput = new Scanner(System.in);
        StringManager stringMan = new StringManager();

        System.out.print("Enter text: ");
        input = UserInput.nextLine();
        System.out.print(stringMan.runUncheker(input));
    }
}
