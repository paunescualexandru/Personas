
package tictactoeapplication;

import java.awt.BorderLayout;
import java.util.Scanner;


public class TicTacToeApplication {

   
    public static void main(String[] args) {
        // getting input
        Scanner sc =  new Scanner(System.in);
        // Allow for cont. games
        boolean doYouWhantToPlay =  true;
        
        while(doYouWhantToPlay) {
            System.out.println("Welcome to Tic Tac Toe! You are about to go against" 
                    + "the master of Tic Tac Toe. Are you ready? I hope so!\n BUT FIRST,you"
                    + "must pick what character you whant to be and witch character I will be");
            System.out.println();
            System.out.println("Enter a single character that will represent you on the board");
            char playerToken =  sc.next().charAt(0);
            System.out.println("Enter a singel character that will represet your opponet on the borad");

            char opponentToken =sc.next().charAt(0);
            TicTacToe game = new TicTacToe(playerToken, opponentToken);
            Ai ai = new Ai();
            
            //set up the game
            System.out.println();
            System.out.println("Now we can start the game. To play, enter a number and your token shall be put "
                    + "in its place.\nThe numbers go from 1-9, left to right. We shall see who will win this round.");
            TicTacToe.printIndexBoard();
            System.out.println();
            
            // Let`s play!
            
            while (game.gameOver().equals("notOver")) {  
                if (game.currentMarker == game.userMarker){
                    // USER TURN
                    System.out.println("It`s your turn! Enter a spot for your token");
                    int spot = sc.nextInt();
                    while(!game.playTurn(spot)) {
                        System.out.println("Try again " +spot + "ïs invalid.This spot is already taken"
                                + " or it is out of range");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                }else{
                   // AI Turn
                    System.out.println("It`s my turn!");
                    //Pick a spot
                    int aiSpot = ai.pickSpot(game);
                    game.playTurn(aiSpot);
                    System.out.println("i picked " + aiSpot + "!");
                }
                // print out new boardsout
                System.out.println();
                game.printBoard();   
            }
                  System.out.println(game.gameOver());
                  System.out.println();
                  //Set up a new game... or not depending on the response
                  System.out.println("Do you want to play again?Enter Y if you do. Enter anything else if you are tierd of me.");
                  char response =  sc.next().charAt(0);
                  doYouWhantToPlay = (response == 'Y');
                  System.out.println();
                  System.out.println();
        }
    }
    
}
