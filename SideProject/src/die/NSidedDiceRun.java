/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package die;

import die.Die;

/**
 *
 * @author Dinamo
 */
public class NSidedDiceRun {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Die d12 = new Die(12);// makes a 12-sided die!
        Die normal = new Die(6); // regular die
        Die skullcrusher = new Die(20); // 20-sided die
        //System.out.println(normal.roll());
        //System.out.println(d12.roll());
        //System.out.println(normal.getValue());
        //System.out.println(normal.roll());
        //normal.setSides(20);
        //System.out.println(normal.roll());
        System.out.printf("Rolling %d sided die : %d\n",normal.getSides(), normal.roll());
        System.out.printf("Rolling %d sided die : %d\n",d12.getSides(), d12.roll());
        System.out.printf("Rolling %d sided die : %d\n",skullcrusher.getSides(), skullcrusher.roll());
        
    }
    
    
}
