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
public class IfElseStatement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input =new Scanner(System.in);
        System.out.print("Enter you grade, a number between 0 and 100 : ");
        int grade = input.nextInt();
        if (grade>=0 && grade <=100){
            if (grade<70){
        System.out.println("You are not a very brigt student!");
            }else{
        System.out.printf("The value %d is a nice grade!\n", grade);
        }
         }else{
        System.out.printf("The value %d is  outside the range 0 to 100.\n", grade);
                }
        }
        
    }    

