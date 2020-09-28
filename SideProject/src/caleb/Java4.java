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
public class Java4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // static method
        int x = 10;
        int y = 20;
        System.out.println(Integer.max(x, y));
        System.out.println(Integer.compare(x, y));
        String money = "300";

        System.out.println(Integer.valueOf(money)); //Integer /object
        System.out.println(Integer.parseInt(money)); // int
// instance 
//Integer myInt = 5;
//myInt.toString();
    }

}
