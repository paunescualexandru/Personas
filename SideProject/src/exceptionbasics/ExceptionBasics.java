
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
public class ExceptionBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int i = 0;
        boolean done = false;
        do{
        try{
        Scanner input =  new Scanner(System.in);
        System.out.print("Enter a integer : ");
        i =  input.nextInt();
        done = true;
        } catch(InputMismatchException e){
        System.out.println("You didn`t enter a Integer");
        } finally{
        System.out.println("This happends whether the exception occurs or not");
        }
        
        } while (!done);
        System.out.printf("You entered %d\n",i);
    }
        
}
