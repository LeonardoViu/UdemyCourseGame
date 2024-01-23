package org.udemy;

import java.util.Scanner;

public class GuessTheWord {

    private boolean play = true;
    private Words randomWord = new Words();
    private Scanner scan = new Scanner(System.in);
    private int rounds = 10;
    private char lastRound;

    public void start(){
        do{
            showWord();
            getInput();
            checkInput();
        }
        while(play);
    }

    void showWord(){
        System.out.println("You have " + rounds + " rounds left.");
        System.out.println(randomWord);
    }
    void getInput(){
        System.out.print("Enter a letter to guess the word: ");
        String userGuess = scan.nextLine();
        lastRound = userGuess.charAt(0);
    }
    void checkInput(){
        boolean isGuessedRight = randomWord.guess(lastRound);
        if(isGuessedRight) {
            if (randomWord.checkIfWordGuessed()) {
                showWord();
                System.out.println("Congrats, you won");
                play = false;
            }
        }
        else{
            rounds--;
            if (rounds == 0){
                System.out.println("You lost, loser");
                play = false;
            }
        }
    }

    public void end() {
        scan.close();
    }
}
