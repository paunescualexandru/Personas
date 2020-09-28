package caleb;

import java.util.Scanner;



/**
 *
 * @author Dinamo
 */
public class Java1 {
    public static void main(String[] args) {
        System.out.println("What is you name?");
        
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        System.out.println("hello " + name);
        String string = new String("This is a string");
        String easier = "Wow, that was easy!";
        System.out.println(easier + ":)");
        
    }
    
}
