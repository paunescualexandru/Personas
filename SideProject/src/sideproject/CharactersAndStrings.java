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
public class CharactersAndStrings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String thisIsAString = "This is a string!";
Character chInPosition3 = thisIsAString.charAt(3);
String substringFrom5to8 = thisIsAString.substring(5, 8);
System.out.println("Char from index 3 of String "+thisIsAString+"is: "+chInPosition3);
System.err.println("Substring from index 5 to index 8 of String "+thisIsAString+"is: "+substringFrom5to8);
System.out.println("String "+thisIsAString+" without whitespaces is "+thisIsAString.trim());
System.out.println("String "+thisIsAString+" in lowercase is "+thisIsAString.toLowerCase());
System.out.println("String "+thisIsAString+" in uppercase is "+thisIsAString.toUpperCase());
// Searching in strings
System.out.println("String "+thisIsAString+" contains substring is starting with index "+thisIsAString.indexOf("is"));
// Repace a character with another in a String
System.out.println("In String "+thisIsAString+" replacing i with t results "+thisIsAString.replace('i', 't'));
// Compare Strings
String thisIsAnotherString = "This is a string!"; // another String object with same content!
System.out.println("Between two String objects with the same content there are no differences: "+thisIsAString.compareTo(thisIsAnotherString));
System.out.println("If two String objects have the same content these are equals?: "+thisIsAString.equals(thisIsAnotherString));
    }
    
    
}
