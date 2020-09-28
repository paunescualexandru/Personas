/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sideproject;

import java.util.Scanner;

/**
 *
 * @author Dinamo
 */
public class SideProjectAlex {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner imput = new Scanner(System.in);
        System.out.print("What is your name?");
        String yourName = imput.nextLine();
        //System.out.print("Hello, ");
        //System.out.print(yourName);
       // System.out.println("!!!");
       System.out.printf("Hello, %s!!!\n",yourName);
        
    }
    
}
