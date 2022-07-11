package hangman;

import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Hangman hangmanInstance = new Hangman();
        hangmanInstance.newWord();
        Scanner in = new Scanner(System.in);
        while (hangmanInstance.shroudedHiddenWord.contains('_') && hangmanInstance.wrongGuesses < 6) {
            hangmanInstance.printArt(hangmanInstance.wrongGuesses);
            var input = in.next();
            if (isSingleChar(input)) { 
                if (hangmanInstance.guessOccurrence(input.charAt(0)) == false) { //if guess is wrong, increment wrongGuesses
                    hangmanInstance.wrongGuesses++;
                };
            } else {
                hangmanInstance.guessOccurrence((String) input); //if guess is longer than one character, interpret as guessing the word
            }
        }
        in.close();
        if (hangmanInstance.shroudedHiddenWord.contains('_')) {
            hangmanInstance.printArt(hangmanInstance.wrongGuesses);
            System.out.println("YOU LOSE! The word was: "+hangmanInstance.hiddenWord);
        } else {
            System.out.println("YOU WIN!");
        }
    }
    static boolean isSingleChar(String input) {
        if (input.length() == 1) {
            return true;
        } else {
            return false;
        }
    }
    
}
