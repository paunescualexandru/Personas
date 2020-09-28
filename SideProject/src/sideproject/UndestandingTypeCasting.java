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
public class UndestandingTypeCasting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // 20/15 == 1.333333
        int x = 20;
        int y = 15;
        int i = x/y; // int/ int ==> int
        double d1 = x/y; // int/int ==> int ==> double
        double d2 = x/ (1.0* y); //  int /(double*int) ==> double
        double d3 = x/ (double) y ; // int/double ==> double
        System.out.println(i);
        System.out.println(d1);
        System.out.println(d2);
        System.out.println(d3);
        
        
        
    }
    
}
