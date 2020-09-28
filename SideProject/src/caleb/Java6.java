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
public class Java6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String x = "my oh my chicken pot pie";
    System.out.println(x.charAt(x.length()-1));
    String fullAd = x.concat(" Now whit 20% more chiken");
    System.out.println(fullAd);
    System.out.println(fullAd.contains("chicken"));
    System.out.println(fullAd.indexOf("my"));
    int number = 9;        
String str = String.format("%04d", 9);  // 0009      
System.out.printf("original number %d, numeric string with padding : %s", 9, str);
    }
    
}
