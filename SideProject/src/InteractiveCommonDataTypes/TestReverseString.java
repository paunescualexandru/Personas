/*Challenge: Given a String, write code that returns the reversed String either
 *with using the reverse method of StringBuilder - or without using the reverse method.
 * Using StringBuilder
 * Manually
 */
package InteractiveCommonDataTypes;

/**
 *
 * @author Dinamo
 */
public class TestReverseString {
    public static void main(String[] args) {
       String str = "Hello World!";
        System.out.println(reverseWhitStringBuilder(str));
        System.out.println(reverseManually(str));
    }
    //using StringBuilder
    private static String reverseWhitStringBuilder(String str){
        return new StringBuilder(str).reverse().toString();
    }
    // manually
    private static String reverseManually(String str){
        StringBuilder sb  = new StringBuilder();
        
        for(int i = str.length() - 1; i>= 0 ; i-- ){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
