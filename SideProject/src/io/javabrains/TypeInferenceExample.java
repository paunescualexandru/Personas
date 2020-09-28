package io.javabrains;
/**
 *
 * @author Dinamo
 */
public class TypeInferenceExample {
    public static void main(String[] args) {
        //StringLengthLambda myLambda = s -> s.length();
       // System.out.println(myLambda.getLength("Hello Lambda"));
       printLambda(s -> s.length());
    }
    
    public static void printLambda(StringLengthLambda l){
        System.out.println(l.getLength("Hello Lambda2"));
    } 
    
    interface StringLengthLambda{
        int getLength(String s);
    }
}
