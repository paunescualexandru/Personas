/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caleb;

/**
 *
 * @author Dinamo
 */
public class Java5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           //String x = "hello\n\n\ncats";
        String x = "hello cats";
        System.out.println(x + " and dogs");
        x += " and puppies";
        System.out.println(x);
        String name = "Alex";
        System.out.println(String.format("hello %s", name));
        System.out.println(name.length());// the length of name(Alex) =4:)
    }
    
}
