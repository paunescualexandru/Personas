
package DaysOfCode30;

public class Enemy implements Character {
    
    public String weapon = "lightsaber";
    
    public Enemy() {
        
    }
    public String getWeapen(){
        return weapon;
    }
    
public void attack(){
    System.out.println("The enemy ataks YOU!");
}
public void heal(){
    System.out.println("The enemy heals himself");
}    
public void whaponDraw(){
    System.out.println("draw out weapon");
}

    @Override
    public String weapon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
