package org.udemy;

import java.util.Random;

public class Words {

    private String[] randomWords = {"argentina", "different", "hello", "another", "conflict", "movie", "school", "hateful", "wonder", "sorrow", "chemical", "romance", "afternoon", "evening", "university", "book", "insurance", "deathly", "white", "soccer", "event", "anarchy", "unfortunately", "home", "mirror", "chair", "orthodox", "present", "runner", "technology", "universe", "void", "public"};
    private String selectedWord;
    private Random random = new Random();
    private char[] letters;

    public Words(){
        selectedWord = randomWords[random.nextInt(randomWords.length)];
        letters = new char[selectedWord.length()];
    }
    public String toString() {
        StringBuilder text = new StringBuilder();

        for (char letter : letters) {
            text.append(letter == '\u0000' ? "-": letter);
            text.append(" ");
        }
        return text.toString();
    }

    public boolean guess(char letter) {
        boolean guessRight = false;

        for(int i=0; i<selectedWord.length(); i++){
            if(letter == selectedWord.charAt(i)){
                letters[i] = letter;
                guessRight = true;
            }
        }
        return guessRight;
    }

    public boolean checkIfWordGuessed() {
        /*for(int i=0;i<selectedWord.length();i++){
            if(letters[i] != selectedWord.charAt(i)){
                return false;
            }
        }*/
        for(char letter : letters){
            if(letter == '\u0000'){
                return false;
            }
        }
        return true;
    }
}
