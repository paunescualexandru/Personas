/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sideproject;

/**
 *
 * @author Dinamo
 */
public class StringBuilderExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // reverse string
        String forward = "This is a test!";
        StringBuilder sb = new StringBuilder();
        sb.append(forward);
        String reverse = sb.reverse().toString();
        
        System.out.println(forward);
        System.out.println(reverse);
    }
    
}
