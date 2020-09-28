/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.javabrains;

/**
 *
 * @author Dinamo
 */
public class Greeter {
    public void greet(Greeting greeting){
        //System.out.print("Hello World");
        greeting.perform();
    }
    
    public static void main(String[] args) {
        Greeter greeter =  new Greeter();
        //HelloWorldGreeting helloWorldGreeting = new HelloWorldGreeting();
        
        
  //MyLamda myLamdaFunction = () -> System.out.print("Hello World!");
    Greeting myLamdaFunction = () -> System.out.print("Hello World2"); 
    Greeting helloWorldGreeting = new HelloWorldGreeting();
    Greeting innerClassGreeting = new Greeting(){
    public void perform(){
        System.out.print("HelloWorld3");
    }
    };
    
       // myLamdaFunction.perform();
       // helloWorldGreeting.perform();
       // innerClassGreeting.perform();
        
        
        greeter.greet(innerClassGreeting);
        greeter.greet(myLamdaFunction);
        greeter.greet(helloWorldGreeting);
    
    } 
}
/*
interface MyLamda{
    void foo();
}
*/
