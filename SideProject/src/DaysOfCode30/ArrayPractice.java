
package DaysOfCode30;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayPractice {
    
    public static <E> void printArray(E[] array){
        for (E element : array) {
            System.out.println(element + " ");
        }
    }
 
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Index: 0  1  2  3  4
        // Array:[0, 5, 3, 2, 1] -length 5
        
        // Random object from Array
        // Math.abs(rand.nextInt) % length
        
        Integer[] intArray1;
        Integer[] intArray2 = new Integer[4];
        printArray(intArray2);
        Integer[] intArray3 = {5, 2, 9, 1, 3};
        
        String[] shoppingList ={"bannas", "apples", "pares"};
        
        
        // Index: 0  1  2  3  
        // Array:[10, 8, 5, 10] -length 4
        intArray2[0] = 10;
        intArray2[1] = 8;
        intArray2[2] = 5;
        intArray2[1] = 10;
        
        // PRINT out Arrays
        System.out.println(Arrays.toString(intArray2));
        System.out.println(Arrays.toString(intArray3));
        System.out.println(Arrays.toString(intArray3));
        
        // Costum print out Arrays
        printArray(intArray2);
        printArray(intArray3);
        
        // Retrive objects
        System.out.println(intArray2[3]);
        System.out.println(Array.get(intArray2, 3));
        
        // Given function
        Arrays.sort(intArray3);
        System.out.println(Arrays.toString(intArray3));
        System.out.println(Arrays.toString(shoppingList));
        
        System.out.println("Special For Loop");
        // Special for loop: foreach
        for(String s : shoppingList){
            System.out.println(s);
            //System.out.println("hi");
        }
        
    }
    
}
