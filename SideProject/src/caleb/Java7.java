/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caleb;

import java.util.Scanner;

/**
 *
 * @author Dinamo
 */
public class Java7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    String fullAd = "y   ummm...my oh my chicken pot pie .Now whit 20% more chiken";
    System.out.println(fullAd.toUpperCase());
    String password = "let me in";
    System.out.println("Guess the password: ");
    Scanner input = new Scanner(System.in);
    String guess = input.nextLine();
    System.out.println(password.equals(guess));
    
    }
    
}
