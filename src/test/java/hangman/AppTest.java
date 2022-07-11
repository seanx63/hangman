package hangman;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    Hangman hangman = new Hangman();
    /**
     * Rigorous Test :-)
     */
    @Test
    public void allLettersInHiddenWordAreRight() {
        char[] hiddenWordCharArr = hangman.hiddenWord.toCharArray();
        for (char c : hiddenWordCharArr) {
            assertTrue(hangman.guessOccurrence(c));
        }
    }
    @Test
    public void aWrongLetterIncrementsWrongGuesses() {
        hangman.hiddenWord = "draw";
        assertFalse(hangman.guessOccurrence("z"));        
    }
}
