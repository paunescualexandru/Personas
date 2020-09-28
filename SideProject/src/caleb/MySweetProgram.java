package caleb;

import java.util.Scanner;

/**
 *
 * @author Dinamo
 */
public class MySweetProgram {

    public static void main(String[] args) {
   User user = new User();
   user.firstName = "Alex"; //setting a property
   user.lastName = "Paunescu";
   System.out.println(user.getFullName());
    }

}
