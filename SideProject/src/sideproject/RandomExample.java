/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sideproject;

import java.util.Random;

/**
 *
 * @author Dinamo
 */
public class RandomExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Pseudo -random number example.
        Random generator = new Random ();
        int i = generator.nextInt(10);
        System.out.println(i);
        i = generator.nextInt(10);
        System.out.println(i);
        i = generator.nextInt(10);
        System.out.println(i);
        
    }
    
}
