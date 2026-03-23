/**
 * Exercise 08: Reverse a String
 * 
 * CONCEPT: Strings in Java are immutable. 
 * Reversing implies reading from end to beginning.
 */
public class ReverseString {
    public static void main(String[] args) {
        String original = "OOP Fundamentals";
        String reversed = "";

        // Standard iterative reversal
        // Start from last index (length-1) and decrement
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        System.out.println("Original: " + original);
        System.out.println("Reversed: " + reversed);
        
        // Pro-tip: For high efficiency, use StringBuilder.reverse()
        // String result = new StringBuilder(original).reverse().toString();
    }
}
