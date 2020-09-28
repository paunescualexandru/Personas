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
public class MethodBaisics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     /*   System.out.println("Retagle area is:"+rectangleArea(5,10));
        System.out.println("Retagle area is:"+rectangleArea(7,6));
        System.out.println("Retagle area is:"+rectangleArea(3,1));
        System.out.println("Retagle Perimeter is :"+retaglePerimeter(5,10));*/
     int length, width;
     Scanner input = new Scanner(System.in);
     System.out.println("Emnter the lenght :");
     length = input.nextInt(); 
     System.out.println("Emnter the width :");
     width = input.nextInt();
     int area  = rectangleArea(length, width);
     int per = retaglePerimeter(length, width);
     System.out.printf("Rectangle Area : %d; Perimeter : %d\n", area, per);
    }
    
    public static int rectangleArea(int someLength, int someWidth){
     return someLength * someWidth;
    }
    public static int retaglePerimeter(int someLength, int someWidth){
    return 2 *(someLength + someWidth);
    }
}
