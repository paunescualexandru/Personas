
package hangman;

import java.io.IOException;
import java.util.Scanner;


public class HangmanApplication {

  
    public static void main(String[] args) throws  IOException  {
        // How do we play the game
        Scanner sc =  new Scanner(System.in);
        System.out.println("Welocom to Hangman! I will pick a word and you will "
                + "try to guess it character by character."
                + ". If you gess wrong 6 times,  then I win.\nIf you can guess it before  then,  you win."
                + "Are you ready? I hope so beceuse I am.");
        System.out.println();
        System.out.println("I have picked my word. Below is a picture, and below "
                + "that is your current guess.Which starts of as nothing. \nEvry time you "
                + "guess incorrectly. I add a body part to the picture. When is a full "
                + "person, you lose");
        
        // Allows for multipe games
        boolean doYouWantToPlay = true;
        while(doYouWantToPlay){
            // Setting up the game
            System.out.println();
            System.out.println("Alright let`s play!");
            
            Hangman game = new Hangman();
            
            do{
                // Drow the things
                System.out.println();
                System.out.println(game.drawPicture());
                System.out.println();
                System.out.println(game.getFormalCurrentGuess());
                //System.out.print(game.mysteryWord);
                System.out.println("");
                
                // Get the guess
                System.out.println("Enter a character that you think is in the word");
                char guess = (sc.next().toLowerCase().charAt(0));
                System.out.println();
                
                // Chek if the character is guesed already
                while(game.isGuessedAlready(guess)){
                    System.out.println("Try again! You`ve already guessed that character");
                    guess =  (sc.next().toLowerCase().charAt(0));
                }
                 
                 // Play The guess
                if (game.playGuess(guess)){
                    System.out.println("Great guess! That character is in the word!");
                }else{
                    System.out.println("Unfortunately that character isn`t in the word");
                }
                
               
            
            }
            while(!game.gameOver()); // Keep playing until the game is over
                // Playing the game
            
            
            // Play again or no?
            System.out.println();
            System.out.println("Do you want to play another game? Enter Y if you do");
            Character response = (sc.next().toUpperCase()).charAt(0);
            doYouWantToPlay = (response == 'Y');
        }
    }
    
}
