
package DaysOfCode30;

public class Cat extends Animal {
    public Cat(){
        super(7);
        System.out.println("A cat has been created"); 
    }
    
     public void eat(){
        System.out.println("A cat is eating");
    }
     
     public void sleep(){
            System.out.println("A cat is sleeping");
    }
    
    public void mew(){
        System.out.println("A cat meows");
    }
    public void prance(){
        System.out.println("A cat is prancing");
    }
}
