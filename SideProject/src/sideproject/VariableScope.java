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
public class VariableScope {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String name = "Mike";
        SayHello(name);
        SayHello("Dave");
        
        }
    public static void SayHello(String name){
        System.out.printf("Hello, %s\n",name);
        name = "Tony" ;
    }
    
}
