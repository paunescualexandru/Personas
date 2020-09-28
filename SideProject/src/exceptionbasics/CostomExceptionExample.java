/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionbasics;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dinamo
 */
public class CostomExceptionExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* This example will thtow an ImputMismatchExeption
        when you enter a non-integer*/
        
        Scanner input =  new Scanner(System.in);
        int i ;
        System.out.print("Enter an integer between 1 and 10: ");
        try {
        i =  input.nextInt();
        if (i<1 || i>10) throw new IntegerOutOfRangeException();
        } catch  (InputMismatchException ex) {
            System.out.println("You diddn`t enter an Integer.");
             System.out.println(ex);
        } catch (IntegerOutOfRangeException ex){
        System.out.println("Your input value is not in the specified rnage");
        System.out.println(ex);
        }
    }
    
}
