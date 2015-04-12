/*
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
 o	ACCEPTABLE: “Its not polite to stare.” → “It's not polite to stare.”

 */
package spellingerrorgenerator;

import java.io.IOException;
import java.util.Scanner;

/**
 * Run Input through 
 *
 * @author kamonson17
 */
public class SpellingErrorGenerator {

    /**
     *
     * @param args the command line arguments
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
