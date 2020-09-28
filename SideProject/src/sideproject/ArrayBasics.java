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
public class ArrayBasics {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] grades = new int[4];
        // assing values
        grades[0] = 77;
        grades[1] = 84;
        grades[2] = 80;
        grades[3] = 96;
       
        String[] students =  new String[]{ "Tom", "Ed","Joe", "Bob"};
        double sum = 0.0;
        
        System.out.printf("#\tStudent\tGrade\n");
        System.out.printf("-\t-------\t-----\n");
        for(int i=0; i<grades.length; i++){
        System.out.printf("%d\t%s\t%d\n", i, students[i], grades[i]);
        sum += grades[i];
        }
        double average = sum / grades.length;
        System.out.printf("Class Avrage %f\n", average);
    }
    
}
