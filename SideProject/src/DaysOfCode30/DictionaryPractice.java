
package DaysOfCode30;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;


public class DictionaryPractice {

    public static void main(String[] args) {
        // English to Spanish Dictionary
        Map<String,String>engSpanDictionary = new HashMap<String, String>();
        //Inserting things in Dictionary
        engSpanDictionary.put("Monday" , "Lunes");
        engSpanDictionary.put("Tuesday","Martes");
        engSpanDictionary.put("Wednesday","Miercoles");
        engSpanDictionary.put("Thursday","Jueves");
        engSpanDictionary.put("Friday", "Viernes");
        engSpanDictionary.put("Saturday", "Sabado");
        engSpanDictionary.put("Sunday", "Domingo");
        // Retrive things from our dictionary
        System.out.println(engSpanDictionary.get("Monday"));
        System.out.println(engSpanDictionary.get("Tuesday"));
        System.out.println(engSpanDictionary.get("Wednesday"));
        System.out.println(engSpanDictionary.get("Thursday"));
        System.out.println(engSpanDictionary.get("Friday"));
        // Print all keys
        System.out.println(engSpanDictionary.keySet());
        // Print out all values
        System.out.println(engSpanDictionary.values());
        // Print out size
        System.out.println("The size of our Dictionary is "+engSpanDictionary.size());
        
        System.out.println();
        System.out.println();
        
        //Shopping list
        Map<String, Boolean> shoppingList =  new HashMap<String, Boolean>();
        // inserting things in shopping list
        shoppingList.put("Ham", Boolean.TRUE);
        shoppingList.put("Bread", Boolean.TRUE);
        shoppingList.put("Oreos", true);
        shoppingList.put("Eggs", Boolean.FALSE);
        shoppingList.put("Sugar", false);
        // Retrive items
        System.out.println(shoppingList.get("Ham"));
        System.out.println(shoppingList.get("Sugar"));
        //Key-Value pairs Print Out
        System.out.println(shoppingList.toString());
        // Is Empty?
        System.out.println(shoppingList.isEmpty());
        // Remove
        shoppingList.remove("Eggs");
        // Replace
        shoppingList.replace("Bread", Boolean.FALSE);
        //Clear our dictionary
        shoppingList.clear();
        System.out.println(shoppingList.toString());
        // Is Empty?
        System.out.println(shoppingList.isEmpty());
        
                
        
        
    }
    
}
