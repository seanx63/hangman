package hangman;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Hangman {
    String hiddenWord = "";
    ArrayList<String> testedLetters;
    int wrongGuesses = 0;
    ArrayList<Character> shroudedHiddenWord = new ArrayList<>();
    ArrayList<Integer> occurrenceList = new ArrayList<>();
    public void newWord() throws IOException {
        wrongGuesses = 0;
        int randInt = new Random().nextInt(20+1);
        BufferedReader bufRead = new BufferedReader(new FileReader("./src/main/java/hangman/wordlist.txt")); //word list to pull words from
        for (int i = 0; i < randInt; i++) {
            hiddenWord = bufRead.readLine(); //use the random number to pull a random word from wordlist
        }
        bufRead.close();
        for (int i = 0; i < hiddenWord.length(); i++) {
            shroudedHiddenWord.add('_'); //use length of random word to generate a string of unknown characters
        }
    }
    public boolean guessOccurrence(char letterGuess) { // for guessing a single letter
        boolean letterOccurrs = false;
        for (int i = 0; i < hiddenWord.length(); i++) {
            if (hiddenWord.charAt(i) == letterGuess) {
                letterOccurrs = true;
                occurrenceList.add(i);
            }
        }
        if (!letterOccurrs) {  
            return false;
        }
        updateShroudedWord();
        return true;
    } 
    public boolean guessOccurrence(String wordGuess) { // for guessing the whole word
        if (wordGuess.equals(hiddenWord)) {
            shroudedHiddenWord.clear();
            return true;
        } else {
            wrongGuesses++;
            return false;
        }
}
    void printArt(int wrongGuesses) throws IOException {
        String line;
        switch (wrongGuesses) {
            case 0:
                BufferedReader bufRead = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess0.txt"));
                while ((line = bufRead.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            case 1:
                BufferedReader bufRead1 = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess1.txt"));
                while ((line = bufRead1.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            case 2:
                BufferedReader bufRead2 = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess2.txt"));
                while ((line = bufRead2.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            case 3:
                BufferedReader bufRead3 = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess3.txt"));
                while ((line = bufRead3.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            case 4:
                BufferedReader bufRead4 = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess4.txt"));
                while ((line = bufRead4.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            case 5:
                BufferedReader bufRead5 = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess5.txt"));
                while ((line = bufRead5.readLine()) != null) {
                    System.out.println(line);
                }
                break;
            case 6:
                BufferedReader bufRead6 = new BufferedReader(new FileReader("./src/main/java/hangman/pic_guess6.txt"));
                while ((line = bufRead6.readLine()) != null) {
                    System.out.println(line);
                }
                break;
        }
        if (shroudedHiddenWord.contains('_') && wrongGuesses < 6) {
            for (char c : shroudedHiddenWord) {
                System.out.print(c);
            }
            System.out.println("");
        }
    }

    private void updateShroudedWord() {
        for (int i : occurrenceList) {
            shroudedHiddenWord.set(i, hiddenWord.charAt(i));
        }
    }
}