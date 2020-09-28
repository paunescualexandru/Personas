/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caleb;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Dinamo
 */
public class Java2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  Scanner input =  new Scanner(System.in);
      //String x = input.nextLine();
      //System.out.println(x);
      int y = input.nextInt();
      System.out.println(y);
      int a = y + 10;
      System.out.println(a);
      BigDecimal money = input.nextBigDecimal();
      
      System.out.println(Integer.MIN_VALUE);
   System.out.println(Double.isNaN(Math.sqrt(-1)));
   System.out.println(Math.pow(9999, 9999999));
    }
    
}
