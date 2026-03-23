import java.util.Scanner;

/**
 * Exercise 04: Palindrome Checker
 * 
 * ALGORITHM:
 * 1. Read input string.
 * 2. Traverse the string from end to start and build a reversed version.
 * 3. Compare original (ignoring case) with reversed.
 */
public class Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();
        
        // Manually build the reversed string using StringBuilder for performance
        // StringBuilder is more efficient than string concatenation in loops
        // because strings are immutable - each += creates a new String object
        StringBuilder reversed = new StringBuilder();

        // Loop starts from (length - 1) and goes down to 0
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i)); // Append characters one by one
        }

        // Case-insensitive comparison
        if (str.equalsIgnoreCase(reversed.toString())) {
            System.out.println("'" + str + "' is a palindrome.");
        } else {
            System.out.println("'" + str + "' is NOT a palindrome.");
        }
        scanner.close();
    }
}
