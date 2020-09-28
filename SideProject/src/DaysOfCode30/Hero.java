
package DaysOfCode30;

public class Hero implements Character{
    public String weapon = "The Force";
    
    public String getWeapon(){
        return weapon;
    }

    public void attack(){
        System.out.println("The hero attacks the enemy");
    }
    
    public void heal(){
        System.out.println("The hero heals you");
    }

    @Override
    public String weapon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
