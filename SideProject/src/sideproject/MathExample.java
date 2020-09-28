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
public class MathExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Ciricumferince and are of a cirlce
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the Circle Radius : ");
        double radius = input.nextDouble();
        
        double circ = 2* Math.PI *radius;
        double area = Math.PI *radius *radius;
        System.out.printf("Circumferece : %f; Area%f/n", circ, area);
        
    }
    
}
