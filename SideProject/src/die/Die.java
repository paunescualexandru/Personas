/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package die;

import java.util.Random;

/**
 *
 * @author Dinamo
 */
public class Die {
    /*
    roll()
    getValue()
    getSides()
    setSides(int sides)
    */
    private int sides;
    private int value;
    private Random generator;
    
    public Die(int sides){
    this.sides =sides ;
    generator = new Random();
    this.value = this.roll();
    }
    // Overloard method
    public Die(int sides, int seed){
    this.sides = sides;
    this.generator = new Random(seed); 
    }
    public int roll(){
    this.value = this.generator.nextInt(this.sides) +1;
    return this.value;
    }
    public int getValue(){
       return this.value;
    }
    public int getSides(){
       return this.sides;   
    }
    public void setSides(int sides){
       this.sides = sides;
    }
    
}
