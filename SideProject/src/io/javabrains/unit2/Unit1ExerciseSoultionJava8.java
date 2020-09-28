package io.javabrains.unit2;


import io.javabrains.Person;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author Dinamo
 */
public class Unit1ExerciseSoultionJava8 {
    public static void main(String[] args) {
         List<Person> people = Arrays.asList(
                new Person("Charls", "Dickens", 60),
                new Person("Lewis", "Carroll", 42),
                new Person("Thomas", "Carlyle", 51),
                new Person("Charlotte", "Bronte", 45),
                new Person("Matthew", "Arnold", 39)
        );
        // Step 1: Sort list by last name
        Collections.sort(people, (p1, p2) ->p1.getLastName().compareTo(p2.getLastName()));
        
        // step 2: Create a method that prints all elements in the list
        System.out.println("Printing all Perosons");
        performConditionally(people, p -> true, p-> System.out.println(p));
        
        // Step 3: Create a method that prints all people that have a last name begining whit C
        System.out.println("Printing all persons whit the last name beginning whit C ");
        performConditionally(people, p -> p.getLastName().startsWith("C"),  p-> System.out.println(p));
         System.out.println("Printing all persons whit the first name beginning whit C ");
         performConditionally(people, p -> p.getFirstName().startsWith("C"),  p-> System.out.println(p.getFirstName()));
       
    }   
        private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
       for(Person p : people){
            if(predicate.test(p)){
                consumer.accept(p);
            }
        }
    }
    
}
