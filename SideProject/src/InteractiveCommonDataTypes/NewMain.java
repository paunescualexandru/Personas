/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InteractiveCommonDataTypes;

import java.util.Scanner;

/**
 *
 * @author Dinamo
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
      Scanner input = new Scanner(System.in);
    
        String name = "Alex";
        int age = 31;
        double gpa = 3.9;
        System.out.print("Enter student`s name : ");
        name = input.nextLine();
        System.out.print("Enter student`s gpa : ");      
        gpa = input.nextDouble();
        System.out.print("Enter student`s age : ");
        age = input.nextInt();
        System.out.printf("%s is %d years old. %s has a %4.3f gpa.\n", name, age, name, gpa);
    }
    
}
